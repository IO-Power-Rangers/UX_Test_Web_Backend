package com.uxtest.backend.controller.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.TextAnswerDTO;
import com.uxtest.backend.service.TextAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/answer/text")
@RestController
public class TextAnswerController {

    private final TextAnswerService textAnswerService;

    @Autowired
    public TextAnswerController(TextAnswerService textAnswerService) {
        this.textAnswerService = textAnswerService;
    }

    @PostMapping
    public void add(@RequestBody TextAnswerDTO textAnswerDTO) {
        textAnswerService.addTextAnswer(textAnswerDTO.parseTextAnswer());
    }
}
