package com.crudBuilder.gamesBuilders.Controller;

import com.crudBuilder.gamesBuilders.Entity.Game;
import com.crudBuilder.gamesBuilders.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/list")
    public ArrayList<Game> getGames(){
        return gameService.getAll();
    }

    @GetMapping("/{gameId}")
    public Optional<Game> getGameById(@PathVariable("gameId") Integer id){
        return gameService.getById(id);
    }

    @GetMapping("/category")
    public ArrayList<Game> getGamesByCategory(@RequestParam("category") String category){
        return gameService.listByCategory(category);
    }

    @GetMapping("/finished")
    public ArrayList<Game> getFinishedGames(@RequestParam("type") int type){
            return gameService.listByFinished(type);
    }

    @GetMapping("/played")
    public ArrayList<Game> getPlayedGames(@RequestParam("type") int type){
        return gameService.listByPlayed(type);
    }

    @PostMapping("/saveGame")
    public Game saveGame(@RequestBody Game game){
        return gameService.addGame(game);
    }

    @PutMapping("/finished/{gameId}")
    public void updateGameToFinished(@PathVariable("gameId") Integer id){
        gameService.updateGameToFinished(id);
    }

    @PutMapping("/played/{gameId}")
    public void updateGameToPlayed(@PathVariable("gameId") Integer id){
        gameService.updateGameToPlayed(id);
    }

    @DeleteMapping("/deleteGame/{gameId}")
    public String deleteGame(@PathVariable("gameId") Integer id){
        boolean ok = gameService.deleteGame(id);
        if (ok) {
            return "Se elimino el juego con id : " + id;
        } else {
            return "No se pudo eliminar el juego con id : " + id;
        }
    }

}