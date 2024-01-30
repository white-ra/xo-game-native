package whitera.xogamenative.model;

import whitera.xogamenative.contract.entity.MapInterface;
import whitera.xogamenative.contract.entity.ScoreInterface;
import whitera.xogamenative.model.contract.GameInterface;
import whitera.xogamenative.model.entity.Map;
import whitera.xogamenative.model.entity.Score;
import whitera.xogamenative.contract.enums.PlayerMarkEnum;
import whitera.xogamenative.contract.enums.EventEnum;
import whitera.xogamenative.model.factory.MapFactory;

public class Game implements GameInterface {
    private final MapFactory mapFactory;
    private final Score score;
    private Map map;
    private PlayerMarkEnum playerTurn;
    private boolean isGameEnd;

    public Game(MapFactory mapFactory) {
        this.mapFactory = mapFactory;
        score = new Score();

        restartGame();
    }

    public EventEnum doTurn(Integer xCoordinate, Integer yCoordinate) {
        if (isGameEnd) {
            return EventEnum.GAME_END;
        }

        if (map.isSetMark(xCoordinate, yCoordinate)) {
            return EventEnum.CELL_IS_ALREADY_OCCUPIED;
        }

        map.setMark(playerTurn, xCoordinate, yCoordinate);

        if (map.isPlayerWin(playerTurn)) {
            isGameEnd = true;
            score.increase(playerTurn);

            return playerTurn == PlayerMarkEnum.X ? EventEnum.PLAYER_X_WIN : EventEnum.PLAYER_O_WIN;
        }

        switchPlayerTurn();

        return playerTurn == PlayerMarkEnum.X ? EventEnum.PLAYER_X_TURN : EventEnum.PLAYER_O_TURN;
    }

    public EventEnum restartGame() {
        map = this.mapFactory.create();
        playerTurn = PlayerMarkEnum.X;
        isGameEnd = false;

        return EventEnum.GAME_START;
    }

    @Override
    public MapInterface getMap() {
        return map;
    }

    @Override
    public ScoreInterface getScore() {
        return score;
    }

    private void switchPlayerTurn() {
        playerTurn = playerTurn == PlayerMarkEnum.X ? PlayerMarkEnum.O : PlayerMarkEnum.X;
    }
}
