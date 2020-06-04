package com.uxtest.backend.service;

import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.model.user.User;
import com.uxtest.backend.model.uxmodel.UxModel;
import com.uxtest.backend.repository.TaskRepository;
import com.uxtest.backend.repository.TestRepository;
import com.uxtest.backend.repository.UserRepository;
import com.uxtest.backend.repository.UxModelRepository;
import com.uxtest.backend.repository.questionnaire.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;
    @Autowired
    QuestionnaireRepository questionnaireRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UxModelRepository uxModelRepository;

    public Test getTestById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found"));
    }


    public void createTest(Test test) {
        User creator = test.getCreator();
        List<Task> tasks = test.getTasks();
        UxModel uxModel = test.getUxModel();
        saveCreator(creator, test);
        testRepository.save(test);
        saveTasks(tasks, test);
        saveUxModel(uxModel, test);
    }

    private void saveUxModel(UxModel uxModel, Test test) {
        UxModel uxModel1 = uxModelRepository.getOne(uxModel.getAxLink());
        uxModel1.getTests().add(test);
        uxModelRepository.save(uxModel1);
    }

    private void saveTasks(List<Task> tasks, Test test) {
        tasks.forEach(task -> {task.setTest(test);taskRepository.save(task);});
    }

    private void saveCreator(User creator, Test test) {
        User user = userRepository.getOne(creator.getId());
        user.getTests().add(test);
        userRepository.save(user);
    }

    private void saveQuestionnaire(Questionnaire questionnaire, Test test) {
        questionnaire.setTest(test);
        questionnaireRepository.save(questionnaire);
    }

    public void updateTest(Test test, Long id) {
        if (testRepository.existsById(id)) {
            test.setId(id);
            testRepository.save(test);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }

    public List<Test> getTests() {
        return testRepository.findAll();
    }
}
