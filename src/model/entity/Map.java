package model.entity;

public class Map {
    private final int[] playersChars = new int[9];

    public void setChar(int playerChar, int xCoordinate, int yCoordinate) {
        this.playersChars[this.convertCoordinatesToIndex(xCoordinate, yCoordinate)] = playerChar;
    }

    public int[] getMapArray() {
        return this.playersChars;
    }

    public boolean isSetChar(int xCoordinate, int yCoordinate) {
        return 0 == this.playersChars[this.convertCoordinatesToIndex(xCoordinate, yCoordinate)];
    }

    private int convertCoordinatesToIndex(int xCoordinate, int yCoordinate) {
        return (yCoordinate - 1) * 3 + xCoordinate;
    }
}
