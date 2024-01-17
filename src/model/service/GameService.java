package model.service;

import model.entity.Map;

public class GameService {

    public final int X_PLAYER = 1;
    public final int O_PLAYER = 2;

    private Map map;
    private int playerTurn;

    public void doTurn(int xCoordinate, int yCoordinate) throws Exception {
        if (playerTurn == 0) {
            throw new NullPointerException();
        }
    }

    public void initMap() {
        this.map = new Map();
    }

    public void initPlayerTurn() {
        this.playerTurn = X_PLAYER;
    }
}
