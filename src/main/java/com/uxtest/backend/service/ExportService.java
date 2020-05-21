package com.uxtest.backend.service;

import com.uxtest.backend.model.questionnaire.question.QuestionExport;
import com.uxtest.backend.model.questionnaire.ExcelExport;
import com.uxtest.backend.model.questionnaire.question.AnswerExport;
import com.uxtest.backend.model.questionnaire.question.Question;
import com.uxtest.backend.service.questionnaire.QuestionnaireService;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExportService {

    private final static List<String> HEADER = List.of("Question no.", "Question", "Type", "First name", "Last name", "Answer");
    private final static String TABLE_NAME = "Table";
    private final static String STYLE_NAME = "TableStyleMedium14";
    private final static String FILE_NAME_FORMAT = "QuestionnaireExport-%d.xlsx";

    @Autowired
    private QuestionnaireService questionnaireService;


    public ExcelExport getExcelExport(long questionnaireId) throws IOException{
        List<QuestionExport> exportData = getData(questionnaireId);
        String fileName = String.format(FILE_NAME_FORMAT, questionnaireId);
        XSSFWorkbook workbook = createWorkbook(exportData,fileName);

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            workbook.write(byteArrayOutputStream);
            workbook.close();
            String base64String = Base64.encodeBase64String(byteArrayOutputStream.toByteArray());

            return  new ExcelExport(base64String,fileName);
        }
    }

    private List<QuestionExport> getData(long questionnaireId) {
        return questionnaireService
                .getQuestionsByQuestionnaireId(questionnaireId)
                .stream()
                .map(Question::getExportData).collect(Collectors.toList());
    }

    private XSSFWorkbook createWorkbook(List<QuestionExport> exportData,String fileName) {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet(fileName);

        int rowCounter = parseQuestions(sheet, exportData);
        createTable(workbook, sheet, rowCounter);
        return workbook;
    }

    private void createTable(XSSFWorkbook workbook, XSSFSheet sheet, int rowCounter) {

        int XLastCell = rowCounter - 1;
        int YLastCell = HEADER.size() - 1;
        CellReference startCellReference = new CellReference(0, 0);
        CellReference endCellReference = new CellReference(XLastCell, YLastCell);

        AreaReference reference = workbook.getCreationHelper().createAreaReference(
                startCellReference, endCellReference);

        XSSFTable table = sheet.createTable(reference);
        for (int i = 1; i <= YLastCell; i++) {
            table.getCTTable().getTableColumns().getTableColumnArray(i).setId(i + 1);
        }

        table.setName(TABLE_NAME);
        table.setDisplayName(TABLE_NAME);
        setTableStyle(table);
    }

    private void setTableStyle(XSSFTable table) {
        table.getCTTable().addNewTableStyleInfo();
        table.getCTTable().getTableStyleInfo().setName(STYLE_NAME);

        XSSFTableStyleInfo style = (XSSFTableStyleInfo) table.getStyle();
        style.setName(STYLE_NAME);
        style.setShowColumnStripes(true);
        style.setShowRowStripes(true);
        style.setFirstColumn(false);
        style.setLastColumn(false);
    }

    private int parseQuestions(XSSFSheet sheet, List<QuestionExport> exportData) {
        int rowCounter = 0;
        int questionCounter = 0;
        rowCounter = addRow(sheet, HEADER, rowCounter);

        for (QuestionExport questionExport : exportData) {
            rowCounter = parseQuestion(sheet, questionExport, rowCounter, ++questionCounter);
        }
        return rowCounter;
    }

    private int parseQuestion(XSSFSheet sheet, QuestionExport questionExport, int rowCounter, int questionCounter) {
        List<AnswerExport> answerExportList = questionExport.getAnswerExportList();
        String question = questionExport.getQuestion();
        String type = questionExport.getQuestionType().getLowerCase();
        for (AnswerExport answerExports : answerExportList) {
            rowCounter = parseRow(sheet, answerExports, question, questionCounter, rowCounter, type);
        }

        if (answerExportList.isEmpty()) {
            List<String> questionList = new ArrayList<>();
            questionList.add(String.valueOf(questionCounter));
            questionList.add(question);
            rowCounter = addRow(sheet, questionList, rowCounter);
        }

        return rowCounter;
    }


    private int addRow(XSSFSheet sheet, List<String> dataToadded, int rowCounter) {
        XSSFRow row = sheet.createRow(rowCounter++);
        int columnCounter = 0;
        for (String data : dataToadded) {
            XSSFCell cell = row.createCell(columnCounter++);
            cell.setCellValue(data);
        }
        return rowCounter;
    }

    private int parseRow(XSSFSheet sheet, AnswerExport answerExports, String question, int questionNumber, int rowCounter, String type) {
        List<String> answerList = new ArrayList<>();
        answerList.add(String.valueOf(questionNumber));
        answerList.add(question);
        answerList.add(type);
        answerList.add(answerExports.getUser().getFirstName());
        answerList.add(answerExports.getUser().getLastName());
        answerList.add(answerExports.getAnswer());
        return addRow(sheet, answerList, rowCounter);
    }
}
