package model;

import contract.entity.MapInterface;
import contract.entity.ScoreInterface;
import model.contract.GameInterface;
import model.entity.Map;
import model.entity.Score;
import contract.enums.PlayerMarkEnum;
import model.factory.MapFactory;

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

    public void doTurn(Integer xCoordinate, Integer yCoordinate) {
        if (isGameEnd) {
            System.out.println("Restart game");
            return;
        }

        if (map.isSetMark(xCoordinate, yCoordinate)) {
            System.out.println("Field is set");
            return;
        }

        map.setMark(playerTurn, xCoordinate, yCoordinate);

        if (map.isPlayerWin(playerTurn)) {
            isGameEnd = true;
            score.increase(playerTurn);
            System.out.printf("Player %s win%n", playerTurn);
            return;
        }

        switchPlayerTurn();
    }

    public void restartGame() {
        map = this.mapFactory.create();
        playerTurn = PlayerMarkEnum.X;
        isGameEnd = false;
    }

    @Override
    public MapInterface getMap() {
        return map;
    }

    @Override
    public ScoreInterface getScore() {
        return score;
    }

    @Override
    public void restart() {
        restartGame();
    }

    private void switchPlayerTurn() {
        playerTurn = playerTurn == PlayerMarkEnum.X ? PlayerMarkEnum.O : PlayerMarkEnum.X;
    }
}
