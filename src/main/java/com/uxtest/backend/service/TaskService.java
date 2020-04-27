package com.uxtest.backend.service;

import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task, Long id) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            taskRepository.save(task);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}
