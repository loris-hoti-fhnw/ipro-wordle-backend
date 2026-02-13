package fhnw.hoti.worldebackend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String solutionWord;

    private int attempts;

    private boolean completed;

    public void setAttempts(int attempts) {
        if(attempts > 6 || attempts < 1) {
            this.attempts = 6;
        } else {
            this.attempts = attempts;
        }
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
