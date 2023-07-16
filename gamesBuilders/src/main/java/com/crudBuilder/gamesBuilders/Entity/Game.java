package com.crudBuilder.gamesBuilders.Entity;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private  String gameName;

    private  String gameCategory;

    private  int gamePlayStatus;

    private  int gameFinishStatus;

    public Game(String gameName, String gameCategory, int gamePlayStatus, int gameFinishStatus) {
        this.gameName = gameName;
        this.gameCategory = gameCategory;
        this.gamePlayStatus = gamePlayStatus;
        this.gameFinishStatus = gameFinishStatus;
    }

    public Game() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameCategory() {
        return gameCategory;
    }

    public int getGamePlayStatus() {
        return gamePlayStatus;
    }

    public int getGameFinishStatus() {
        return gameFinishStatus;
    }
}