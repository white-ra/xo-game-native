package whitera.xogamenative.presenter;

import whitera.xogamenative.contract.entity.MapInterface;
import whitera.xogamenative.model.contract.GameInterface;

public class MapPresenter implements MapPresenterInterface {
    private final GameInterface game;

    public MapPresenter(GameInterface game) {
        this.game = game;
    }

    @Override
    public MapInterface getMap() {
        return game.getMap();
    }
}
