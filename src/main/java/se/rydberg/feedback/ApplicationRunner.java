package se.rydberg.feedback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import se.rydberg.feedback.simple.FeedbackQuestion;

import java.util.List;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public ApplicationRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Query query = new Query();
        List<FeedbackQuestion> questions = mongoTemplate.find(query, FeedbackQuestion.class);
        if (questions.isEmpty()) {
            FeedbackQuestion feedbackQuestion = FeedbackQuestion.builder()
                    .question("En första testfråga?")
                    .active(true)
                    .order(1)
                    .build();
            mongoTemplate.save(feedbackQuestion);
            System.out.println("Skapat en första testfråga");
        } else {
            System.out.println("Sökning mot mongodb ok");
        }

    }
}
