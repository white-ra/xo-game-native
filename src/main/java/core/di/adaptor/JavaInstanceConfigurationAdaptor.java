package core.di.adaptor;

import core.di.contract.JavaInstanceConfigurationInterface;

import java.util.LinkedHashMap;

public class JavaInstanceConfigurationAdaptor {
    public LinkedHashMap<Class<?>, Class<?>[]> adapt(JavaInstanceConfigurationInterface javaInstanceConfiguration) {
        return javaInstanceConfiguration.getInstanceConfigure();
    }
}
