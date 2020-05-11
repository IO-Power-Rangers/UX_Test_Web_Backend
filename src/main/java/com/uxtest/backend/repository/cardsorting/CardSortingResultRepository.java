package com.uxtest.backend.repository.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardSortingResultRepository extends JpaRepository<CardSortingResult, Long> {
}
