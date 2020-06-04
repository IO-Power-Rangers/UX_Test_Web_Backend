package com.uxtest.backend.service.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.Subject;
import com.uxtest.backend.model.user.User;
import com.uxtest.backend.repository.UserRepository;
import com.uxtest.backend.repository.cardsorting.CardSortingTestRepository;
import com.uxtest.backend.repository.cardsorting.CategoryRepository;
import com.uxtest.backend.repository.cardsorting.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CardSortingTestService {
    @Autowired
    CardSortingTestRepository testRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    UserRepository userRepository;

    public CardSortingTest getTestById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found"));
    }

    public void createTest(CardSortingTest cardSortingTest) {
        testRepository.save(cardSortingTest);
        saveSubjects(cardSortingTest.getSubjects(), cardSortingTest);
        saveCategories(cardSortingTest.getCategories(), cardSortingTest);
        saveCreator(cardSortingTest.getCreator(), cardSortingTest);
    }

    private void saveCreator(User creator, CardSortingTest cardSortingTest) {
        User user = userRepository.getOne(creator.getId());
        user.getCardSortingTests().add(cardSortingTest);
        userRepository.save(user);
    }

    private void saveCategories(List<Category> categories, CardSortingTest test) {
        categories.forEach(c -> {
            c.setTest(test);
            categoryRepository.save(c);
        });
    }

    private void saveSubjects(List<Subject> subjects, CardSortingTest test) {
        subjects.forEach(s -> {
            s.setTest(test);
            subjectRepository.save(s);
        });
    }

    public void updateTest(CardSortingTest cardSortingTest, Long id) {
        if (testRepository.existsById(id)) {
            cardSortingTest.setId(id);
            testRepository.save(cardSortingTest);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }

    public List<CardSortingTest> getTests() {
        return testRepository.findAll();
    }
}
