package fhnw.hoti.worldebackend.controller;

import fhnw.hoti.worldebackend.dto.GuessRequest;
import fhnw.hoti.worldebackend.dto.GuessResponse;
import fhnw.hoti.worldebackend.dto.StartGameResponse;
import fhnw.hoti.worldebackend.model.Game;
import fhnw.hoti.worldebackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
@CrossOrigin
public class GameController {

    private final GameService gameService;

    @GetMapping("/start")
    public StartGameResponse startGame() {
        Game game = gameService.startNewGame();
        return new StartGameResponse(game.getId());
    }

    @PostMapping("/guess")
    public GuessResponse guess(@RequestBody GuessRequest request) {
        return gameService.makeGuess(request);
    }
}