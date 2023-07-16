package com.crudBuilder.gamesBuilders.Builder;

public interface Builder {
    GameBuilder setGameName(String name);
    GameBuilder setGameCategory(String category);
    GameBuilder setPlayStatus(int playStatus);
    GameBuilder setFinishStatus(int finishStatus);

}
