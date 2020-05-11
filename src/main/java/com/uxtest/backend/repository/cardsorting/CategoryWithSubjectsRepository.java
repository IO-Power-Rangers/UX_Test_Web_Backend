package com.uxtest.backend.repository.cardsorting;

import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryWithSubjectsRepository extends JpaRepository<CategoryWithSubjects, Long> {
}
