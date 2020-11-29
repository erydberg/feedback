package se.rydberg.feedback.simple;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackQuestionService {

    private MongoTemplate mongoTemplate;

    public FeedbackQuestionService(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<FeedbackQuestion> getAll(){
        return mongoTemplate.findAll(FeedbackQuestion.class);
    }

    public FeedbackQuestion getQuestion(String id){
        return mongoTemplate.findById(id, FeedbackQuestion.class);
    }

}
