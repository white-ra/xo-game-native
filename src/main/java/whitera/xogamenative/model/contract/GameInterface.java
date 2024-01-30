package whitera.xogamenative.model.contract;

import whitera.xogamenative.contract.entity.MapInterface;
import whitera.xogamenative.contract.entity.ScoreInterface;
import whitera.xogamenative.contract.enums.EventEnum;

public interface GameInterface {
    MapInterface getMap();

    ScoreInterface getScore();

    EventEnum restartGame();

    EventEnum doTurn(Integer xCoordinate, Integer yCoordinate);
}
