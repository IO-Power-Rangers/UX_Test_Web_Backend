package com.uxtest.backend.controller.cardsorting;

import com.uxtest.backend.dto.cardsorting.SubjectDTO;
import com.uxtest.backend.model.cardsorting.Subject;
import com.uxtest.backend.service.cardsorting.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/api/cardsorting/subject")
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{id}")
    @ResponseBody
    public SubjectDTO getSubject(@PathVariable("id") Long id) {
        return subjectService.getSubjectById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<SubjectDTO> getSubjects() {
        return subjectService.getSubjects().stream().map(Subject::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubject(@RequestBody SubjectDTO subjectDTO) {
        subjectService.createSubject(subjectDTO.parseSubject());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSubject(@RequestBody SubjectDTO subjectDTO, @PathVariable Long id) {
        subjectService.updateSubject(subjectDTO.parseSubject(), id);
    }
}
