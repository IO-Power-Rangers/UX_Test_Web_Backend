package com.uxtest.backend.repository.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardSortingTestRepository extends JpaRepository<CardSortingTest, Long> {
}
