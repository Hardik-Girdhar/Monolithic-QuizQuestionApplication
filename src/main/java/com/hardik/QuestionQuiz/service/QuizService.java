package com.hardik.QuestionQuiz.service;

import com.hardik.QuestionQuiz.model.Question;
import com.hardik.QuestionQuiz.model.Quiz;
import com.hardik.QuestionQuiz.model.Response;
import com.hardik.QuestionQuiz.model.WrapperQuestion;
import com.hardik.QuestionQuiz.repo.QuestionRepo;
import com.hardik.QuestionQuiz.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepo.findByCategoryNumQ(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Quiz has created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<WrapperQuestion>> getQuizQuestion(int id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questionFromDb = quiz.getQuestions();
        List<WrapperQuestion> questionForClient = new ArrayList<>();
        for(Question q: questionFromDb){
            WrapperQuestion wq = new WrapperQuestion();
            wq.setId(q.getId());
            wq.setQuestiontitle(q.getQuestiontitle());
            wq.setOption1(q.getOption1());
            wq.setOption2(q.getOption2());
            wq.setOption3(q.getOption3());
            wq.setOption4(q.getOption4());

            questionForClient.add(wq);
        }
        return new ResponseEntity<>(questionForClient, HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i=0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightanswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
