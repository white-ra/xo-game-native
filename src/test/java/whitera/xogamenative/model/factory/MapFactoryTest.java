package whitera.xogamenative.model.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import whitera.xogamenative.model.entity.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapFactoryTest {

    private static MapFactory mapFactory;

    @BeforeAll
    public static void initialization() {
        mapFactory = new MapFactory();
    }

    @Test
    void create() {
        Assertions.assertInstanceOf(Map.class, mapFactory.create());
    }
}