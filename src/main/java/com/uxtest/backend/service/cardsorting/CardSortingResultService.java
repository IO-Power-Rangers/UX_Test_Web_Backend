package com.uxtest.backend.service.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingResult;
import com.uxtest.backend.repository.cardsorting.CardSortingResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CardSortingResultService {
    @Autowired
    CardSortingResultRepository resultRepository;

    public CardSortingResult getResultById(Long id) {
        return resultRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found"));
    }

    public void createResult(CardSortingResult cardSortingResult) {
        resultRepository.save(cardSortingResult);
    }

    public void updateResult(CardSortingResult cardSortingResult, Long id) {
        if (resultRepository.existsById(id)) {
            cardSortingResult.setId(id);
            resultRepository.save(cardSortingResult);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found");
        }
    }

    public List<CardSortingResult> getResults() {
        return resultRepository.findAll();
    }
}
