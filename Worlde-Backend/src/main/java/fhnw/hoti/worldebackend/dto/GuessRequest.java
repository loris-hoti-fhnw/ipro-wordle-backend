package fhnw.hoti.worldebackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuessRequest {
    private Long gameId;
    private String guess;
}