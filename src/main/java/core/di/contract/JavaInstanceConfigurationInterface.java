package core.di.contract;

import java.util.LinkedHashMap;

public interface JavaInstanceConfigurationInterface {
    LinkedHashMap<Class<?>, Class<?>[]> getInstanceConfigure();
}
