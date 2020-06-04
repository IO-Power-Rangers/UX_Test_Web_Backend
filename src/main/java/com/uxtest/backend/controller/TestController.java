package com.uxtest.backend.controller;

import com.uxtest.backend.dto.TestDTO;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.model.user.User;
import com.uxtest.backend.model.uxmodel.UxModel;
import com.uxtest.backend.service.TaskService;
import com.uxtest.backend.service.TestService;
import com.uxtest.backend.service.UserService;
import com.uxtest.backend.service.UxModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @Autowired
    private UxModelService uxModelService;
    @Autowired
    private UserService userService;

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
    public Long createTest(@RequestBody TestDTO testDTO) {
        Test test = testDTO.parseTest();
        testService.createTest(test);
        return test.getId();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTest(@RequestBody TestDTO testDTO, @PathVariable Long id) {
        testService.updateTest(testDTO.parseTest(), id);
    }
}
