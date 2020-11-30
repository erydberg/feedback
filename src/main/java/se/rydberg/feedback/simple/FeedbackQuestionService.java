package se.rydberg.feedback.simple;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackQuestionService {

    private MongoTemplate mongoTemplate;

    public FeedbackQuestionService(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<FeedbackQuestion> getAll(){
        Query query = new Query().with(Sort.by(Sort.Direction.ASC, "order"));
        return mongoTemplate.find(query, FeedbackQuestion.class);
    }

    public FeedbackQuestion getQuestion(String id){
        return mongoTemplate.findById(id, FeedbackQuestion.class);
    }

    public void save(FeedbackQuestion feedbackQuestion){
        mongoTemplate.save(feedbackQuestion);
    }

    public void delete(String id) {
        Query query = new Query().addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, FeedbackQuestion.class);
    }
}
