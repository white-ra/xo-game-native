package presenter;

import contract.entity.ScoreInterface;
import model.contract.GameInterface;

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
