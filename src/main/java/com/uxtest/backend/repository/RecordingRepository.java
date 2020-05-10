package com.uxtest.backend.repository;

import com.uxtest.backend.model.Recording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingRepository extends JpaRepository<Recording, Long> {
}
