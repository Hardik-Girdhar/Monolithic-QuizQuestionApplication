package com.hardik.QuestionQuiz.controller;

import com.hardik.QuestionQuiz.model.Question;
import com.hardik.QuestionQuiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // GET = http://localhost:8080/question/getQuestions
    @GetMapping("getQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // GET = http://localhost:8080/question/getQuestions?category=Java
    @GetMapping(value = "getQuestions", params = "category")
    public ResponseEntity<List<Question>> getAllQuestionByParamCategory(@RequestParam String category){
        return questionService.getQuestionByCategory(category);
    }

    // GET = http://localhost:8080/question/getQuestions/Java
    @GetMapping("getQuestions/{category}")
    public ResponseEntity<List<Question>> getAllQuestionByPathCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    // POST = http://localhost:8080/question/addQuestion
    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // PUT = http://localhost:8080/question/updateQuestion
    @PutMapping("updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    // PUT = http://localhost:8080/question/updateQuestion/21
    @PutMapping("updateQuestion/{id}")
    public ResponseEntity<String> updateQuestionById(@PathVariable int id, @RequestBody Question question){
        return questionService.updateQuestionById(id, question);
    }

    // DELETE = http://localhost:8080/question/deleteQuestion/21
    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }
}
