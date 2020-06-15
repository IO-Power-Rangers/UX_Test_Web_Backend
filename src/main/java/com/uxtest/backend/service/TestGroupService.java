package com.uxtest.backend.service;

import com.uxtest.backend.dto.TestGroupDTO;
import com.uxtest.backend.model.grouping.TestGroup;
import com.uxtest.backend.repository.TestGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TestGroupService {
    private final TestService testService;
    private final TestGroupRepository testGroupRepository;

    @Autowired
    public TestGroupService(TestService testService, TestGroupRepository testGroupRepository) {
        this.testService = testService;
        this.testGroupRepository = testGroupRepository;
    }



    public List<TestGroup> getGroup() {
        return this.testGroupRepository.findAll();
    }

    public void createTestGroup(TestGroupDTO testGroupDTO){
        var test = testService.getTestById(testGroupDTO.getTestId());
        var testGroup = testGroupDTO.parseTestGroup();

        testGroup.setTest(test);
        testGroupRepository.save(testGroup);
    }

    public void updateTest(TestGroupDTO testGroupDTO, Long id) {
        var testGroup = testGroupDTO.parseTestGroup();
        var test = testService.getTestById(testGroupDTO.getTestId());
        if (testGroupRepository.existsById(id)) {
            testGroup.setTest(test);
            testGroup.setId(id);
            testGroupRepository.save(testGroup);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }
}
