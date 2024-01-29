package whitera.xogamenative.presenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import whitera.xogamenative.contract.entity.MapInterface;
import whitera.xogamenative.model.contract.GameInterface;
import whitera.xogamenative.presenter.MapPresenter;

class MapPresenterTest {
    private static MapPresenter mapPresenter;
    private static GameInterface gameMock;

    @BeforeAll
    public static void initialization() {
        gameMock = Mockito.mock(GameInterface.class);
        mapPresenter = new MapPresenter(gameMock);
    }

    @Test
    void getMap() {
        MapInterface mapMock = Mockito.mock(MapInterface.class);
        Mockito.when(gameMock.getMap()).thenReturn(mapMock);

        Assertions.assertEquals(mapMock, mapPresenter.getMap());
    }
}
