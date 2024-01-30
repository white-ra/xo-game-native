package whitera.xogamenative.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import whitera.xogamenative.contract.enums.EventEnum;
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
    void doTurnWhenMarkSettedAndReturnMarkSettedEvent() {
        Mockito.when(mapMock.isSetMark(1, 1)).thenReturn(true);

        Assertions.assertEquals(EventEnum.CELL_IS_ALREADY_OCCUPIED, game.doTurn(1, 1));
        Mockito.verify(mapMock, Mockito.times(1)).isSetMark(1, 1);
    }

    @Test
    void doTurnWhenPlayerXNotWinAndReturnPlayerOTurnEvent() {
        Mockito.when(mapMock.isSetMark(1, 1)).thenReturn(false);
        Mockito.when(mapMock.isPlayerWin(PlayerMarkEnum.X)).thenReturn(false);

        EventEnum event = game.doTurn(1, 1);

        Mockito.verify(mapMock, Mockito.times(1))
            .isSetMark(1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .setMark(PlayerMarkEnum.X, 1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .isPlayerWin(PlayerMarkEnum.X);

        Assertions.assertEquals(EventEnum.PLAYER_O_TURN, event);
        Assertions.assertEquals(0, game.getScore().getXPlayer());
        Assertions.assertEquals(0, game.getScore().getOPlayer());
    }

    @Test
    void doTurnWhenPlayerXWinAndReturnXPlayerWinEvent() {
        Mockito.when(mapMock.isSetMark(1, 1)).thenReturn(false);
        Mockito.when(mapMock.isPlayerWin(PlayerMarkEnum.X)).thenReturn(true);

        EventEnum event = game.doTurn(1, 1);

        Mockito.verify(mapMock, Mockito.times(1))
            .isSetMark(1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .setMark(PlayerMarkEnum.X, 1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .isPlayerWin(PlayerMarkEnum.X);

        Assertions.assertEquals(EventEnum.PLAYER_X_WIN, event);
        Assertions.assertEquals(1, game.getScore().getXPlayer());
        Assertions.assertEquals(0, game.getScore().getOPlayer());
    }

    @Test
    void doTurnWhenPlayerXWinAndReturnsGameEndEvent() {
        Mockito.when(mapMock.isSetMark(1, 1)).thenReturn(false);
        Mockito.when(mapMock.isPlayerWin(PlayerMarkEnum.X)).thenReturn(true);

        game.doTurn(1, 1);
        EventEnum event = game.doTurn(1, 2);

        Mockito.verify(mapMock, Mockito.times(1))
            .isSetMark(1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .setMark(PlayerMarkEnum.X, 1, 1);
        Mockito.verify(mapMock, Mockito.times(1))
            .isPlayerWin(PlayerMarkEnum.X);

        Assertions.assertEquals(EventEnum.GAME_END, event);
        Assertions.assertEquals(1, game.getScore().getXPlayer());
        Assertions.assertEquals(0, game.getScore().getOPlayer());
    }

    @Test
    void restartGame() {
        Assertions.assertEquals(EventEnum.GAME_START, game.restartGame());
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