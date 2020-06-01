package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerExport {
    private String answer;
    private User user;
}
