package instances.configuration;

import controller.ControlPanelController;
import controller.GameFieldPanelController;
import controller.listener.SetMarkListener;
import model.Game;
import model.factory.MapFactory;
import presenter.MapPresenter;
import presenter.ScorePresenter;
import view.MainFrame;
import view.canvas.XOCanvas;
import view.panel.*;
import white.ra.simple.io.container.contract.JavaInstanceConfigurationInterface;

import java.util.LinkedHashMap;

public class InstancesConfiguration implements JavaInstanceConfigurationInterface {
    @Override
    public LinkedHashMap<Class<?>, Class<?>[]> getInstanceConfigure() {
        LinkedHashMap<Class<?>, Class<?>[]> iC = new LinkedHashMap<>();

        iC.put(MapFactory.class, null);
        iC.put(Game.class, new Class<?>[]{MapFactory.class});

        iC.put(ScorePresenter.class, new Class<?>[]{Game.class});
        iC.put(MapPresenter.class, new Class<?>[]{Game.class});

        iC.put(XOCanvas.class, new Class<?>[]{MapPresenter.class});

        iC.put(TitlePanel.class, null);
        iC.put(ScorePanel.class, new Class<?>[]{ScorePresenter.class});
        iC.put(ControlPanel.class, null);
        iC.put(GameFieldPanel.class, new Class<?>[]{XOCanvas.class});
        iC.put(MenuPanel.class, new Class<?>[]{ScorePanel.class, ControlPanel.class});

        iC.put(MainFrame.class, new Class<?>[]{TitlePanel.class, MenuPanel.class, GameFieldPanel.class});

        iC.put(SetMarkListener.class, new Class<?>[]{Game.class, XOCanvas.class, ScorePanel.class});
        iC.put(ControlPanelController.class, new Class<?>[]{ControlPanel.class, Game.class, XOCanvas.class});
        iC.put(GameFieldPanelController.class, new Class<?>[]{GameFieldPanel.class, SetMarkListener.class});

        return iC;
    }
}
