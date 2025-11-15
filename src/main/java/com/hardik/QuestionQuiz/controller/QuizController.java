package com.hardik.QuestionQuiz.controller;

import com.hardik.QuestionQuiz.model.Response;
import com.hardik.QuestionQuiz.model.WrapperQuestion;
import com.hardik.QuestionQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // POST = http://localhost:8080/quiz/createQuiz?category=Java&numQ=3&title=Quiz1
    @PostMapping("createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    // GET = http://localhost:8080/quiz/getQuizById/0
    @GetMapping("getQuizById/{id}")
    public ResponseEntity<List<WrapperQuestion>> getQuizQuestion(@PathVariable int id){
        return quizService.getQuizQuestion(id);
    }

    // POST = http://localhost:8080/quiz/submit/0
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateResult(@PathVariable int id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
