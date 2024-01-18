package core;

import controller.MainMenuPanelController;
import core.exception.CreateInstanceException;
import model.Game;
import model.factory.MapFactory;
import view.MainFrame;
import view.panel.MenuPanel;

public class DependencyInjectionContainer {

    private final ServiceLocator serviceLocator;

    public DependencyInjectionContainer(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void initInstance() {
        try {
            serviceLocator.create(MenuPanel.class);
            serviceLocator.create(MainMenuPanelController.class, serviceLocator.get(MenuPanel.class));
            serviceLocator.create(MainFrame.class, serviceLocator.get(MenuPanel.class));

            serviceLocator.create(MapFactory.class);
            serviceLocator.create(Game.class, serviceLocator.get(MapFactory.class));
        } catch (ReflectiveOperationException reflectiveOperationException) {
            throw new CreateInstanceException(reflectiveOperationException.getMessage());
        }
    }
}
