package com.crudBuilder.gamesBuilders.Service;

import com.crudBuilder.gamesBuilders.Builder.GameBuilder;
import com.crudBuilder.gamesBuilders.Entity.Game;
import com.crudBuilder.gamesBuilders.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Game addGame(Game game){
        Game newGame = new GameBuilder()
                .setGameName(game.getGameName())
                .setGameCategory(game.getGameCategory())
                .setPlayStatus(game.getGamePlayStatus())
                .setFinishStatus(game.getGameFinishStatus())
                .build();
        return gameRepository.save(newGame);
    }

    public void updateGameToFinished(Integer id){
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()){
            Game game = optionalGame.get();
            Game updateGame = new GameBuilder()
                    .setGameName(game.getGameName())
                            .setGameCategory(game.getGameCategory())
                                    .setPlayStatus(game.getGamePlayStatus())
                                            .setFinishStatus(1)
                                                    .build();
            gameRepository.save(updateGame);
        }
    }

    public void updateGameToPlayed(Integer id){
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()){
            Game game = optionalGame.get();
            Game updateGame = new GameBuilder()
                    .setGameName(game.getGameName())
                    .setGameCategory(game.getGameCategory())
                    .setPlayStatus(1)
                    .setFinishStatus(game.getGameFinishStatus())
                    .build();
            gameRepository.save(updateGame);
        }
    }

    public boolean deleteGame(Integer id){
        try {
            gameRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public ArrayList<Game> getAll(){
        return (ArrayList<Game>) gameRepository.findAll();
    }

    public Optional<Game> getById(Integer id){
        return gameRepository.findById(id);
    }

    public ArrayList<Game> listByCategory(String category){
        return gameRepository.findAllByGameCategory(category);
    }

    public ArrayList<Game> listByPlayed(int played){
        return gameRepository.findAllByGamePlayStatus(played);
    }


    public ArrayList<Game> listByFinished(int finished){
        return gameRepository.findAllByGameFinishStatus(finished);
    }


}
