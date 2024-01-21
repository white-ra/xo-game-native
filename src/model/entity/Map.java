package model.entity;

import contract.entity.MapInterface;
import contract.enums.PlayerMarkEnum;

public class Map implements MapInterface {
    private final PlayerMarkEnum[] field = new PlayerMarkEnum[9];

    public void setMark(PlayerMarkEnum playerMark, int xCoordinate, int yCoordinate) {
        this.field[convertCoordinatesToIndex(xCoordinate, yCoordinate)] = playerMark;
    }

    public PlayerMarkEnum[] getMapArray() {
        return this.field;
    }

    public boolean isSetMark(int xCoordinate, int yCoordinate) {
        return null != field[this.convertCoordinatesToIndex(xCoordinate, yCoordinate)];
    }

    public boolean isPlayerWin(PlayerMarkEnum playerMark) {
        return field[0] == playerMark && field[1] == playerMark && field[2] == playerMark
            || field[3] == playerMark && field[4] == playerMark && field[5] == playerMark
            || field[6] == playerMark && field[7] == playerMark && field[8] == playerMark
            || field[0] == playerMark && field[3] == playerMark && field[6] == playerMark
            || field[1] == playerMark && field[4] == playerMark && field[7] == playerMark
            || field[2] == playerMark && field[5] == playerMark && field[8] == playerMark
            || field[0] == playerMark && field[4] == playerMark && field[8] == playerMark
            || field[2] == playerMark && field[4] == playerMark && field[6] == playerMark;
    }

    public PlayerMarkEnum[] getField() {
        return field;
    }

    private int convertCoordinatesToIndex(Integer xCoordinate, Integer yCoordinate) {
        return (yCoordinate - 1) * 3 + xCoordinate - 1;
    }
}
