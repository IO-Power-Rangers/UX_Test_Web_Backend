package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.results.QuestionType;
import com.uxtest.backend.model.questionnaire.question.AnswerExport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionExport {
    private List<AnswerExport> answerExportList;
    private String question;
    private QuestionType questionType;
}
