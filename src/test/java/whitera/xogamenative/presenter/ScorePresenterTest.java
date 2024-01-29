package whitera.xogamenative.presenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import whitera.xogamenative.contract.entity.ScoreInterface;
import whitera.xogamenative.model.contract.GameInterface;

import static org.junit.jupiter.api.Assertions.*;

class ScorePresenterTest {
    private static ScorePresenter scorePresenter;
    private static GameInterface gameMock;

    @BeforeAll
    public static void initialization() {
        gameMock = Mockito.mock(GameInterface.class);
        scorePresenter = new ScorePresenter(gameMock);
    }
    @Test
    void getScore() {
        ScoreInterface scoreMock = Mockito.mock(ScoreInterface.class);
        Mockito.when(gameMock.getScore()).thenReturn(scoreMock);

        Assertions.assertEquals(scoreMock, scorePresenter.getScore());
    }
}