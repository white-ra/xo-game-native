package whitera.xogamenative.model.contract;

import whitera.xogamenative.contract.entity.MapInterface;
import whitera.xogamenative.contract.entity.ScoreInterface;

public interface GameInterface {
    MapInterface getMap();

    ScoreInterface getScore();

    void restart();

    void doTurn(Integer xCoordinate, Integer yCoordinate);
}
