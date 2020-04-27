package com.uxtest.backend.repository;

import com.uxtest.backend.model.test.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
