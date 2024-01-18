package model.entity;

import model.enums.PlayerMarkEnum;

public class Score {
    private int X = 0;
    private int O = 0;

    public void increase(PlayerMarkEnum playerMark) {
        if (playerMark == PlayerMarkEnum.X) {
            X++;
        } else {
            O++;
        }
    }
}
