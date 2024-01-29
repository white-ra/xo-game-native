package whitera.xogamenative;

import whitera.xogamenative.configuration.InstancesConfiguration;
import whitera.simpleiocontainer.DependencyInjectionContainer;

public class Main {
    public static void main(String[] args) {
        DependencyInjectionContainer dependencyInjectionContainer = new DependencyInjectionContainer();
        dependencyInjectionContainer.configureFromJavaInstanceConfiguration(new InstancesConfiguration());
        dependencyInjectionContainer.initInstances();
    }
}