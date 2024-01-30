package whitera.xogamenative.view.panel;

import whitera.xogamenative.contract.entity.ScoreInterface;
import whitera.xogamenative.presenter.ScorePresenterInterface;
import whitera.xogamenative.view.contract.ScorePanelInterface;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel implements ScorePanelInterface {
    private static final Integer WIDTH = MenuPanel.WIDTH;
    private static final String PLAYER_SCORE_TEMPLATE = "Player %s: %d";

    private final ScorePresenterInterface scorePresenter;

    private final JLabel scoreCountX;
    private final JLabel scoreCountO;

    public ScorePanel(ScorePresenterInterface scorePresenter) {
        this.scorePresenter = scorePresenter;

        scoreCountX = new JLabel();
        scoreCountO = new JLabel();

        GridLayout layout = new GridLayout(2, 1, 0, 0);
        setLayout(layout);

        add(scoreCountX);
        add(scoreCountO);

        updateScore();

        int leftBorder = (WIDTH / 2 - scoreCountX.getFont().getSize() * scoreCountX.getText().length() / 4);
        setBorder(BorderFactory.createEmptyBorder(0, leftBorder, 0, 0));
    }

    public void updateScore() {
        ScoreInterface score = scorePresenter.getScore();

        scoreCountX.setText(PLAYER_SCORE_TEMPLATE.formatted("X", score.getXPlayer()));
        scoreCountO.setText(PLAYER_SCORE_TEMPLATE.formatted("O", score.getOPlayer()));
    }
}
