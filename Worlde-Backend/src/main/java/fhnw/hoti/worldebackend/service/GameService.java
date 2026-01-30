package fhnw.hoti.worldebackend.service;


import fhnw.hoti.worldebackend.dto.GuessRequest;
import fhnw.hoti.worldebackend.dto.GuessResponse;
import fhnw.hoti.worldebackend.model.Game;
import fhnw.hoti.worldebackend.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private static final List<String> WORDS = List.of(
            "APPLE", "HOUSE", "PLANT", "TRAIN", "WATER"
    );

    public Game startNewGame() {
        String word = WORDS.get(new Random().nextInt(WORDS.size()));
        Game game = Game.builder()
                .solutionWord(word)
                .attempts(0)
                .completed(false)
                .build();
        return gameRepository.save(game);
    }

    public GuessResponse makeGuess(GuessRequest request) {
        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(() -> new RuntimeException("Game not found"));

        if (game.isCompleted()) {
            throw new RuntimeException("Game already finished");
        }

        String guess = request.getGuess().toUpperCase();
        String solution = game.getSolutionWord();

        game.setAttempts(game.getAttempts() + 1);

        String feedback = generateFeedback(guess, solution);

        boolean success = guess.equals(solution);
        boolean completed = success || game.getAttempts() >= 6;

        game.setCompleted(completed);
        gameRepository.save(game);

        return new GuessResponse(feedback, completed, success);
    }

    private String generateFeedback(String guess, String solution) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char g = guess.charAt(i);
            char s = solution.charAt(i);

            if (g == s) {
                result.append("G"); // Green
            } else if (solution.contains(String.valueOf(g))) {
                result.append("Y"); // Yellow
            } else {
                result.append("R"); // Red
            }
        }
        return result.toString();
    }
}
