package se.rydberg.feedback.simple;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackAnswerRepository extends MongoRepository<FeedbackAnswer, String>{


}
