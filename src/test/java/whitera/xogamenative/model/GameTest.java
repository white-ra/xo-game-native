package whitera.xogamenative.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import whitera.xogamenative.contract.enums.PlayerMarkEnum;
import whitera.xogamenative.model.entity.Map;
import whitera.xogamenative.model.entity.Score;
import whitera.xogamenative.model.factory.MapFactory;

class GameTest {
    private Game game;
    private MapFactory mapFactoryMock;
    private Map mapMock;

    @BeforeEach
    public void initialization() {
        mapFactoryMock = Mockito.mock(MapFactory.class);
        mapMock = Mockito.mock(Map.class);
        Mockito.when(mapFactoryMock.create()).thenReturn(mapMock);

        game = new Game(mapFactoryMock);
    }

    @Test
    void doTurnWhenMarkSetted() {
        Mockito.when(mapMock.isSetMark(1, 1)).thenReturn(true);

        game.doTurn(1, 1);

        Mockito.verify(mapMock, Mockito.times(1)).isSetMark(1, 1);
    }

    @Test
    void doTurnWhenMarkNotSettedAndXPlayerNotWin() {
        Mockito.when(mapMock.isSetMark(1, 1)).thenReturn(false);
        Mockito.when(mapMock.isPlayerWin(PlayerMarkEnum.X)).thenReturn(false);

        game.doTurn(1, 1);

        Mockito.verify(mapMock, Mockito.times(1))
            .isSetMark(1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .setMark(PlayerMarkEnum.X, 1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .isPlayerWin(PlayerMarkEnum.X);

        Assertions.assertEquals(0, game.getScore().getXPlayer());
        Assertions.assertEquals(0, game.getScore().getOPlayer());
    }

    @Test
    void doTurnWhenMarkNotSettedAndXPlayerWin() {
        Mockito.when(mapMock.isSetMark(1, 1)).thenReturn(false);
        Mockito.when(mapMock.isPlayerWin(PlayerMarkEnum.X)).thenReturn(true);

        game.doTurn(1, 1);

        Mockito.verify(mapMock, Mockito.times(1))
            .isSetMark(1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .setMark(PlayerMarkEnum.X, 1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .isPlayerWin(PlayerMarkEnum.X);

        Assertions.assertEquals(1, game.getScore().getXPlayer());
        Assertions.assertEquals(0, game.getScore().getOPlayer());
    }

    @Test
    void restartGame() {
        game.restartGame();

        Assertions.assertEquals(mapMock, game.getMap());
    }

    @Test
    void getMap() {
        Assertions.assertEquals(mapMock, game.getMap());
    }

    @Test
    void getScore() {
        Assertions.assertInstanceOf(Score.class, game.getScore());
    }
}