package model.contract;

import contract.entity.MapInterface;
import contract.entity.ScoreInterface;

public interface GameInterface {
    MapInterface getMap();

    ScoreInterface getScore();

    void restart();

    void doTurn(Integer xCoordinate, Integer yCoordinate);
}
