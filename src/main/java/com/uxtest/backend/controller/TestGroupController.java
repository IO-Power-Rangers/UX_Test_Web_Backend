package com.uxtest.backend.controller;


import com.uxtest.backend.dto.TestDTO;
import com.uxtest.backend.dto.TestGroupDTO;
import com.uxtest.backend.model.grouping.TestGroup;
import com.uxtest.backend.service.TestGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/groups", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TestGroupController {

    @Autowired
    private TestGroupService testGroupService;

    @GetMapping
    @ResponseBody
    public List<TestGroupDTO> getGroup(){
       return this.testGroupService.getGroup().stream().map(TestGroup::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createGroup(@RequestBody TestGroupDTO testGroupDTO){
        TestGroup testGroup = testGroupDTO.parseTestGroup();
        testGroupService.createTestGroup(testGroup);
        return testGroup.getId();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTestGroup(@RequestBody TestGroupDTO testGroupDTO, @PathVariable Long id) {
        testGroupService.updateTest(testGroupDTO.parseTestGroup(), id);
    }
}
