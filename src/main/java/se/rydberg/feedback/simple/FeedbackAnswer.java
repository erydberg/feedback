package se.rydberg.feedback.simple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedback")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackAnswer {

    @Id
    private String id;
    private String name;
    private String question;
    private String questionid;
    private String feedbackMessage;
}
