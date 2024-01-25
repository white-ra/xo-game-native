package core.di;

import core.di.adaptor.JavaInstanceConfigurationAdaptor;
import core.di.contract.JavaInstanceConfigurationInterface;

import java.util.LinkedHashMap;
import java.util.Map;

public class DependencyInjectionContainer {
    private LinkedHashMap<Class<?>, Class<?>[]> instanceConfigurationMap;

    private final ServiceLocator serviceLocator;
    private final JavaInstanceConfigurationAdaptor javaInstanceConfigurationAdaptor;

    public DependencyInjectionContainer() {
        serviceLocator = new ServiceLocator();
        javaInstanceConfigurationAdaptor = new JavaInstanceConfigurationAdaptor();
    }

    public void initInstances() {
        for (Map.Entry<Class<?>, Class<?>[]> entry : instanceConfigurationMap.entrySet()) {
            if (null != entry.getValue()) {
                Object[] instanceParams = new Object[entry.getValue().length];

                for (int i = 0; i < entry.getValue().length; i++) {
                    instanceParams[i] = serviceLocator.get(entry.getValue()[i]);
                }

                serviceLocator.create(entry.getKey(), instanceParams);
            } else {
                serviceLocator.create(entry.getKey(), new Object[0]);
            }
        }
    }

    public void configureFromJavaInstanceConfiguration(JavaInstanceConfigurationInterface javaInstanceConfiguration) {
        instanceConfigurationMap = javaInstanceConfigurationAdaptor.adapt(javaInstanceConfiguration);
    }
}
