package se.rydberg.feedback.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("questions", feedbackQuestionService.getAllActive());

        return "list_questions";
    }

    @GetMapping("/answer/{id}")
    public String showQuestion(Model model, @PathVariable String id){
        FeedbackQuestion feedbackQuestion = feedbackQuestionService.getQuestion(id);
        FeedbackAnswer feedbackAnswer = FeedbackAnswer.builder().question(feedbackQuestion.getQuestion()).questionid(feedbackQuestion.getId()).build();
        model.addAttribute("answer", feedbackAnswer);
        return "question_answer";
    }

    @GetMapping("/create")
    public String createQuestion(Model model){
        model.addAttribute("question", FeedbackQuestion.builder().build());
        return "question_create";
    }

    @PostMapping("/save")
    public String save(FeedbackQuestion feedbackQuestion, Model model){
        feedbackQuestionService.save(feedbackQuestion);
        return "answer_thankyou";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model){
        feedbackQuestionService.delete(id);
        model.addAttribute("message", "Frågan är borttagen");
        return "question_management";
    }

    @GetMapping("/deactivate/{id}")
    public String deactivate(@PathVariable String id, Model model){
        feedbackQuestionService.deactivate(id);
        model.addAttribute("message", "Frågan är avpublicerad");
        return "question_management";
    }

    @GetMapping("/activate/{id}")
    public String activate(@PathVariable String id, Model model){
        feedbackQuestionService.activate(id);
        model.addAttribute("message", "Frågan är publicerad");
        return "question_management";
    }
}

