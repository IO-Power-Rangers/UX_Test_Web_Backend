package com.uxtest.backend.controller.cardsorting;

import com.uxtest.backend.dto.cardsorting.CardSortingResultDTO;
import com.uxtest.backend.model.cardsorting.CardSortingResult;
import com.uxtest.backend.service.cardsorting.CardSortingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/api/cardsorting/results")
@RestController
public class CardSortingResultController {
    @Autowired
    private CardSortingResultService resultService;

    @GetMapping("/{id}")
    @ResponseBody
    public CardSortingResultDTO getResult(@PathVariable("id") Long id) {
        return resultService.getResultById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<CardSortingResultDTO> getResults() {
        return resultService.getResults().stream().map(CardSortingResult::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createResult(@RequestBody CardSortingResultDTO resultDTO) {
        resultService.createResult(resultDTO.parseResult());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateResult(@RequestBody CardSortingResultDTO resultDTO, @PathVariable Long id) {
        resultService.updateResult(resultDTO.parseResult(), id);
    }
}
