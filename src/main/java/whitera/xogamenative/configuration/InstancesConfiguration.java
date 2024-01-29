package whitera.xogamenative.configuration;

import whitera.xogamenative.controller.ControlPanelController;
import whitera.xogamenative.controller.GameFieldPanelController;
import whitera.xogamenative.controller.listener.SetMarkListener;
import whitera.xogamenative.model.Game;
import whitera.xogamenative.model.factory.MapFactory;
import whitera.xogamenative.presenter.MapPresenter;
import whitera.xogamenative.presenter.ScorePresenter;
import whitera.xogamenative.view.MainFrame;
import whitera.xogamenative.view.canvas.XOCanvas;
import whitera.xogamenative.view.panel.ControlPanel;
import whitera.xogamenative.view.panel.GameFieldPanel;
import whitera.xogamenative.view.panel.MenuPanel;
import whitera.xogamenative.view.panel.ScorePanel;
import whitera.xogamenative.view.panel.TitlePanel;
import whitera.simpleiocontainer.contract.JavaInstanceConfigurationInterface;

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
