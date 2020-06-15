package com.uxtest.backend.controller.cardsorting;

import com.uxtest.backend.dto.cardsorting.CardSortingResultDTO;
import com.uxtest.backend.dto.cardsorting.CardSortingTestDTO;
import com.uxtest.backend.model.cardsorting.CardSortingResult;
import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.service.cardsorting.CardSortingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/api/cardsorting/tests")
@RestController
public class CardSortingTestController {
    @Autowired
    private CardSortingTestService testService;

    @GetMapping("/{id}")
    @ResponseBody
    public CardSortingTestDTO getTest(@PathVariable("id") Long id) {
        return testService.getTestById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<CardSortingTestDTO> getTests() {
        return testService.getTests().stream().map(CardSortingTest::mapToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}/results")
    @ResponseBody
    public List<CardSortingResultDTO> getTestResults(@PathVariable("id") Long id) {
        return testService.getTestById(id).getResults().stream().filter(r -> r.getTest().getId().equals(id)).map(CardSortingResult::mapToDTO).collect(Collectors.toList());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createTest(@RequestBody CardSortingTestDTO testDTO) {
        CardSortingTest test = testDTO.parseTest();
        testService.createTest(test);
        return test.getId();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTest(@RequestBody CardSortingTestDTO testDTO, @PathVariable Long id) {
        testService.updateTest(testDTO.parseTest(), id);
    }
}
