package com.uxtest.backend.service.cardsorting;

import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.Subject;
import com.uxtest.backend.repository.cardsorting.CategoryRepository;
import com.uxtest.backend.repository.cardsorting.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found"));
    }

    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void updateSubject(Subject subject, Long id) {
        if (subjectRepository.existsById(id)) {
            subject.setId(id);
            subjectRepository.save(subject);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found");
        }
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }
}
