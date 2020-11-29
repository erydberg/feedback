package se.rydberg.feedback.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("answer")
public class FeedbackAnswerController {

    private FeedbackAnswerService feedbackAnswerService;
    private FeedbackQuestionService feedbackQuestionService;

    public FeedbackAnswerController(FeedbackAnswerService feedbackAnswerService,
            FeedbackQuestionService feedbackQuestionService) {
        this.feedbackAnswerService = feedbackAnswerService;
        this.feedbackQuestionService = feedbackQuestionService;
    }

    @PostMapping("/save")
    public String save(FeedbackAnswer answer, Model model) {
        feedbackAnswerService.save(answer);

        return "answer_thankyou";
    }

    @GetMapping("viewanswers")
    public String viewAnswers(Model model){
        model.addAttribute("questions", feedbackQuestionService.getAll());
        return "list_questions_for_answers";
    }

    @GetMapping("viewanswersfor/{id}")
    public String viewAll(@PathVariable String id, Model model){
        model.addAttribute("question", feedbackQuestionService.getQuestion(id));
        model.addAttribute("answers", feedbackAnswerService.getAnswersForQuestion(id));
        return "list_answers";
    }

}
