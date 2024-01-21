package model.entity;

import contract.entity.ScoreInterface;
import contract.enums.PlayerMarkEnum;

public class Score implements ScoreInterface {
    private Integer X = 0;
    private Integer O = 0;

    public void increase(PlayerMarkEnum playerMark) {
        if (playerMark == PlayerMarkEnum.X) {
            X++;
        } else {
            O++;
        }
    }

    @Override
    public Integer getXPlayer() {
        return X;
    }

    @Override
    public Integer getOPlayer() {
        return O;
    }
}
