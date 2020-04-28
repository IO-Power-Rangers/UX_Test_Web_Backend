package com.uxtest.backend.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.TestDTO;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.service.TaskService;
import com.uxtest.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/tests", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    @ResponseBody
    public TestDTO getTest(@PathVariable("id") Long id) {
        return testService.getTestById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<TestDTO> getTest() {
        return testService.getTests().stream().map(Test::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTest(@RequestBody TestDTO testDTO) {
        List<Task> tasks = testDTO.getTasks();
        tasks.forEach(task->taskService.createTask(task));
        Test test = testDTO.parseTest();
        tasks.forEach(task->task.setTest(test));
        testService.createTest(test);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTest(@RequestBody TestDTO testDTO, @PathVariable Long id) {
        testService.updateTest(testDTO.parseTest(), id);
    }
}
