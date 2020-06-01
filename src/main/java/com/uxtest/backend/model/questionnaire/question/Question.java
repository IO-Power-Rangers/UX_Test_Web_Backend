package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.results.QuestionType;
import com.uxtest.backend.dto.questionnaire.results.ResultsDTO;

import java.util.List;

import static java.util.stream.Collectors.toList;

public interface Question {

    String getContent();

    ResultsDTO getResults();

    List<? extends ExportDataAnswer> getDataAnswer();

    QuestionType getQuestionType();

    default QuestionExport getExportData() {
        List<AnswerExport> answerExportList = getDataAnswer().stream().map(ExportDataAnswer::getAnswerExport).collect(toList());
        return new QuestionExport(answerExportList, getContent(), getQuestionType());
    }

    ;
}
