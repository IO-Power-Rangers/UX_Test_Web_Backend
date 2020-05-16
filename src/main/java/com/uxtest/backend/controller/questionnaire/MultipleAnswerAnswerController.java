package com.uxtest.backend.controller.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.MultipleAnswerAnswerDTO;

import com.uxtest.backend.service.questionnaire.MultipleAnswerAnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/answer/multipleAnswer")
@RestController
public class MultipleAnswerAnswerController {

    private final MultipleAnswerAnswerService multipleAnswerAnswerService;

    @Autowired
    public MultipleAnswerAnswerController(MultipleAnswerAnswerService multipleAnswerAnswerService) {
        this.multipleAnswerAnswerService = multipleAnswerAnswerService;
    }

    @PostMapping
    public void add(@RequestBody MultipleAnswerAnswerDTO multipleAnswerAnswerDTO) {
        multipleAnswerAnswerService.addMultipleAnswerAnswer(multipleAnswerAnswerDTO);
    }
}
