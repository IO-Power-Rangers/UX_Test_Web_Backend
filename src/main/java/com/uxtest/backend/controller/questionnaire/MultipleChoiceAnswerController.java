package com.uxtest.backend.controller.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.MultipleChoiceAnswerDTO;
import com.uxtest.backend.service.questionnaire.MultipleChoiceAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/answer/multipleChoice")
@RestController
public class MultipleChoiceAnswerController {

    private final MultipleChoiceAnswerService multipleChoiceAnswerService;

    @Autowired
    public MultipleChoiceAnswerController(MultipleChoiceAnswerService multipleChoiceAnswerService) {
        this.multipleChoiceAnswerService = multipleChoiceAnswerService;
    }

    @PostMapping
    public void add(@RequestBody MultipleChoiceAnswerDTO multipleChoiceAnswerDTO) {
        multipleChoiceAnswerService.addMultipleChoiceAnswer(multipleChoiceAnswerDTO);
    }
}
