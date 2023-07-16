package com.crudBuilder.gamesBuilders.Repository;

import com.crudBuilder.gamesBuilders.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    public ArrayList<Game> findAllByGameCategory(String category);

    public ArrayList<Game> findAllByGameFinishStatus(int finished);

    public ArrayList<Game> findAllByGamePlayStatus(int played);

}
