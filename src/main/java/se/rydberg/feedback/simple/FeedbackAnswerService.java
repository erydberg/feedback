package se.rydberg.feedback.simple;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FeedbackAnswerService {

    private MongoTemplate mongoTemplate;

    public FeedbackAnswerService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(FeedbackAnswer answer){
        mongoTemplate.save(answer);
    }

    public List<FeedbackAnswer> getAnswersForQuestion(String id){
        Query query = new Query().addCriteria(Criteria.where("questionid").is(id));
        return mongoTemplate.find(query, FeedbackAnswer.class);
    }
}
