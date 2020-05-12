package com.uxtest.backend.repository.cardsorting;

import com.uxtest.backend.model.cardsorting.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
