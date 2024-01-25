package core.di;

import core.di.exception.CreateInstanceException;
import core.di.exception.NoSuchInstanceException;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServiceLocator {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void create(Class<T> clazz, Object[] params) {
        if (Objects.isNull(clazz)) {
            throw new NullPointerException("'class' is null");
        }

        try {
            Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();

            if (null == params) {
                Constructor<T> noArgsConstructor = clazz.getConstructor();
                this.instances.put(clazz, noArgsConstructor.newInstance());
            } else {
                for (Constructor<T> constructor : constructors) {
                    if (params.length != constructor.getParameterCount()) {
                        continue;
                    }

                    this.instances.put(clazz, constructor.newInstance(params));
                    break;
                }
            }
        } catch (ReflectiveOperationException exception) {
            throw new CreateInstanceException(clazz);
        }
    }

    public <T> T get(Class<T> clazz) {
        if (Objects.isNull(clazz)) {
            throw new NullPointerException("'class' is null");
        }

        T instance = clazz.cast(this.instances.get(clazz));
        if (instance == null) {
            throw new NoSuchInstanceException(clazz);
        }

        return instance;
    }
}
