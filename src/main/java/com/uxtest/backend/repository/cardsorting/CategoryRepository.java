package com.uxtest.backend.repository.cardsorting;

import com.uxtest.backend.model.cardsorting.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
