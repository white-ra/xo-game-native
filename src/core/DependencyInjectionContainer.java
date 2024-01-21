package core;

import controller.ControlPanelController;
import controller.GameFieldPanelController;
import controller.listener.SetMarkListener;
import core.exception.CreateInstanceException;
import model.Game;
import model.factory.MapFactory;
import presenter.MapPresenter;
import presenter.ScorePresenter;
import view.MainFrame;
import view.canvas.XOCanvas;
import view.panel.*;

public class DependencyInjectionContainer {
    private final ServiceLocator sL;

    public DependencyInjectionContainer(ServiceLocator serviceLocator) {
        this.sL = serviceLocator;
    }

    public void initInstance() {
        try {
            sL.create(MapFactory.class);
            sL.create(Game.class, sL.get(MapFactory.class));

            sL.create(ScorePresenter.class, sL.get(Game.class));
            sL.create(MapPresenter.class, sL.get(Game.class));

            sL.create(XOCanvas.class, sL.get(MapPresenter.class));

            sL.create(TitlePanel.class);
            sL.create(ScorePanel.class, sL.get(ScorePresenter.class));
            sL.create(ControlPanel.class);
            sL.create(GameFieldPanel.class, sL.get(XOCanvas.class));
            sL.create(MenuPanel.class, sL.get(ScorePanel.class), sL.get(ControlPanel.class));

            sL.create(MainFrame.class, sL.get(TitlePanel.class), sL.get(MenuPanel.class), sL.get(GameFieldPanel.class));

            sL.create(SetMarkListener.class, sL.get(Game.class), sL.get(XOCanvas.class), sL.get(ScorePanel.class));

            sL.create(GameFieldPanelController.class, sL.get(GameFieldPanel.class), sL.get(SetMarkListener.class));
            sL.create(
                ControlPanelController.class,
                sL.get(ControlPanel.class),
                sL.get(Game.class),
                sL.get(XOCanvas.class));
        } catch (ReflectiveOperationException reflectiveOperationException) {
            throw new CreateInstanceException(reflectiveOperationException.getMessage());
        }
    }
}
