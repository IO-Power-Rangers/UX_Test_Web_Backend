package com.uxtest.backend.controller;

import com.uxtest.backend.dto.TaskDTO;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/tasks", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    @ResponseBody
    public TaskDTO getTask(@PathVariable("id") Long id) {
        return taskService.getTaskById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getTasks() {
        return taskService.getTasks().stream().map(Task::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody TaskDTO taskDTO) {
        taskService.createTask(taskDTO.parseTask());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody TaskDTO taskDTO, @PathVariable Long id) {
        taskService.updateTask(taskDTO.parseTask(), id);
    }
}
