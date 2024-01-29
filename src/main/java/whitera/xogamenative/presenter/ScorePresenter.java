package whitera.xogamenative.presenter;

import whitera.xogamenative.contract.entity.ScoreInterface;
import whitera.xogamenative.model.contract.GameInterface;

public class ScorePresenter implements ScorePresenterInterface {
    private final GameInterface game;

    public ScorePresenter(GameInterface game) {
        this.game = game;
    }

    @Override
    public ScoreInterface getScore() {
        return game.getScore();
    }
}
