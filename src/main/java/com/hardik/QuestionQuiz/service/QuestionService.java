package com.hardik.QuestionQuiz.service;

import com.hardik.QuestionQuiz.model.Question;
import com.hardik.QuestionQuiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepo.save(question);
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        if(questionRepo.existsById(question.getId())){
            questionRepo.save(question);
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("No Question found to update",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestionById(int id, Question question) {
        if(questionRepo.existsById(id)){
            question.setId(id);
            questionRepo.save(question);
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("No Question found to update",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestion(int id) {
        if(questionRepo.existsById(id)){
            questionRepo.deleteById(id);
            return new ResponseEntity<>("Question Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("No Question found to delete", HttpStatus.BAD_REQUEST);
    }
}
