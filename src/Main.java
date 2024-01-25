import core.di.DependencyInjectionContainer;
import core.di.ServiceLocator;

public class Main {
    public static void main(String[] args) {
        DependencyInjectionContainer dependencyInjectionContainer = new DependencyInjectionContainer();
        dependencyInjectionContainer.configureFromJavaInstanceConfiguration(new InstancesConfiguration());
        dependencyInjectionContainer.initInstances();
    }
}