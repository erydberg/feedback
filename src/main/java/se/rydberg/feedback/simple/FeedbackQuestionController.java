package se.rydberg.feedback.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class FeedbackQuestionController {
    private FeedbackQuestionService feedbackQuestionService;

    public FeedbackQuestionController(FeedbackQuestionService feedbackQuestionService) {
        this.feedbackQuestionService = feedbackQuestionService;
    }

    @GetMapping("")
    public String start(Model model){
        model.addAttribute("questions", feedbackQuestionService.getAll());

        return "list_questions";
    }

    @GetMapping("/answer/{id}")
    public String showQuestion(Model model, @PathVariable String id){
        FeedbackQuestion feedbackQuestion = feedbackQuestionService.getQuestion(id);
        FeedbackAnswer feedbackAnswer = FeedbackAnswer.builder().question(feedbackQuestion.getQuestion()).questionid(feedbackQuestion.getId()).build();
        model.addAttribute("answer", feedbackAnswer);
        return "question_answer";
    }







}
