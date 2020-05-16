package com.uxtest.backend.controller.cardsorting;

import com.uxtest.backend.dto.cardsorting.CardSortingTestDTO;
import com.uxtest.backend.dto.cardsorting.CategoryDTO;
import com.uxtest.backend.dto.cardsorting.SubjectDTO;
import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.Subject;
import com.uxtest.backend.service.cardsorting.CardSortingTestService;
import com.uxtest.backend.service.cardsorting.CategoryService;
import com.uxtest.backend.service.cardsorting.SubjectService;
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
    public CardSortingTestDTO getCategory(@PathVariable("id") Long id) {
        return testService.getTestById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<CardSortingTestDTO> getTests() {
        return testService.getTests().stream().map(CardSortingTest::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTest(@RequestBody CardSortingTestDTO testDTO) {
        testService.createTest(testDTO.parseTest());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTest(@RequestBody CardSortingTestDTO testDTO, @PathVariable Long id) {
        testService.updateTest(testDTO.parseTest(), id);
    }
}
