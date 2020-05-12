package com.uxtest.backend.service.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.repository.cardsorting.CardSortingTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CardSortingTestService {
    @Autowired
    CardSortingTestRepository testRepository;

    public CardSortingTest getTestById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found"));
    }

    public void createTest(CardSortingTest cardSortingTest) {
        testRepository.save(cardSortingTest);
    }

    public void updateTest(CardSortingTest cardSortingTest, Long id) {
        if (testRepository.existsById(id)) {
            cardSortingTest.setId(id);
            testRepository.save(cardSortingTest);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }

    public List<CardSortingTest> getTests() {
        return testRepository.findAll();
    }
}
