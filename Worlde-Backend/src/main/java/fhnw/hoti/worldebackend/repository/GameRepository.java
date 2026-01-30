package fhnw.hoti.worldebackend.repository;


import fhnw.hoti.worldebackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}