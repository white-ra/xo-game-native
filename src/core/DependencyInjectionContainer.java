package core;

import controller.MainMenuPanelController;
import core.exception.CreateInstanceException;
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
        } catch (ReflectiveOperationException reflectiveOperationException) {
            throw new CreateInstanceException(reflectiveOperationException.getMessage());
        }
    }
}
