package fhnw.hoti.worldebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GuessResponse {
    private String feedback;
    private boolean completed;
    private boolean success;
}