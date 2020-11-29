package se.rydberg.feedback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import se.rydberg.feedback.simple.FeedbackQuestion;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public ApplicationRunner(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override public void run(String... args) throws Exception {
        FeedbackQuestion feedbackQuestion = FeedbackQuestion.builder().question("Vem är grundaren av scoutrörelsen?").active(true).order(1).build();
        mongoTemplate.save(feedbackQuestion);
        System.out.println("En fråga sparad");

    }
}
