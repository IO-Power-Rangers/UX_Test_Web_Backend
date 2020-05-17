package com.uxtest.backend.controller.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.LikertScaleAnswerDTO;
import com.uxtest.backend.dto.questionnaire.answer.MultipleAnswerAnswerDTO;
import com.uxtest.backend.service.questionnaire.LikertScaleAnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/answer/likert")
@RestController
public class LikertScaleAnswerController {

    private final LikertScaleAnswerService likertScaleAnswerService;

    @Autowired
    public LikertScaleAnswerController(LikertScaleAnswerService likertScaleAnswerService) {
        this.likertScaleAnswerService = likertScaleAnswerService;
    }

    @PostMapping
    public void add(@RequestBody LikertScaleAnswerDTO likertScaleAnswerDTO) {
        likertScaleAnswerService.addLikertScaleAnswer(likertScaleAnswerDTO);
    }
}
