package core;

import view.MainFrame;

public class DependencyInjectionContainer {

    private final ServiceLocator serviceLocator;

    public DependencyInjectionContainer(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void initInstance() {
        try {
            this.serviceLocator.create(MainFrame.class);
        } catch (ReflectiveOperationException reflectiveOperationException) {
            System.out.println("pizdec");
        }
    }
}
