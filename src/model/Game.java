package model;

import model.entity.Map;
import model.entity.Score;
import model.enums.PlayerMarkEnum;
import model.factory.MapFactory;

public class Game {
    private final MapFactory mapFactory;
    private Map map;

    private final Score score;

    private PlayerMarkEnum playerTurn;

    public Game(MapFactory mapFactory) {
        this.mapFactory = mapFactory;
        this.score = new Score();

        restartGame();
    }

    public void doTurn(int xCoordinate, int yCoordinate) {
        if (map.isSetMark(xCoordinate, yCoordinate)) {
            System.out.println("Field is set");
            return;
        }

        map.setMark(playerTurn, xCoordinate, yCoordinate);

        if (map.isPlayerWin(playerTurn)) {
            score.increase(playerTurn);
            System.out.printf("Player %s win%n", playerTurn.mark);
            return;
        }

        switchPlayerTurn();
    }

    public void restartGame() {
        this.map = this.mapFactory.create();
        this.playerTurn = PlayerMarkEnum.X;
    }

    private void switchPlayerTurn() {
        playerTurn = playerTurn == PlayerMarkEnum.X ? PlayerMarkEnum.O : PlayerMarkEnum.X;
    }
}
