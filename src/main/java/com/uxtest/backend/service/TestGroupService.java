package com.uxtest.backend.service;

import com.uxtest.backend.model.grouping.TestGroup;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.repository.TestGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TestGroupService {
    @Autowired
    private TestGroupRepository testGroupRepository;

    public List<TestGroup> getGroup() {
        return this.testGroupRepository.findAll();
    }

    public void createTestGroup(TestGroup testGroup){
        testGroupRepository.save(testGroup);
    }

    public void updateTest(TestGroup testGroup, Long id) {
        if (testGroupRepository.existsById(id)) {
            testGroup.setId(id);
            testGroupRepository.save(testGroup);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }
}
