package se.rydberg.feedback.simple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackQuestion {

    @Id
    private String id;
    private String question;
    private boolean active;
    private int Order;


}
