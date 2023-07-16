package com.crudBuilder.gamesBuilders.Builder;

import com.crudBuilder.gamesBuilders.Entity.Game;

public class GameBuilder implements Builder{

    private String name;
    private String category;
    private int playStatus;
    private int finishStatus;

    @Override
    public GameBuilder setGameName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public GameBuilder setGameCategory(String category) {
        this.category = category;
        return this;
    }

    @Override
    public GameBuilder setPlayStatus(int playStatus) {
        this.playStatus = playStatus;
        return this;
    }

    @Override
    public GameBuilder setFinishStatus(int finishStatus) {
        this.finishStatus = finishStatus;
        return this;
    }

    public Game build(){
        return new Game(name, category, playStatus, finishStatus);
    }
}
