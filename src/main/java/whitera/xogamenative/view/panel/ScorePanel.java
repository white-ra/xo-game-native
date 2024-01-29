package whitera.xogamenative.view.panel;

import whitera.xogamenative.contract.entity.ScoreInterface;
import whitera.xogamenative.presenter.ScorePresenterInterface;
import whitera.xogamenative.view.contract.ScorePanelInterface;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel implements ScorePanelInterface {
    private final ScorePresenterInterface scorePresenter;

    private final JLabel playerX;
    private final JLabel playerY;
    private final JLabel scoreCountX;
    private final JLabel scoreCountY;

    public ScorePanel(ScorePresenterInterface scorePresenter) {
        this.scorePresenter = scorePresenter;

        playerX = new JLabel("Player X: ");
        playerY = new JLabel("Player O: ");

        scoreCountX = new JLabel("0");
        scoreCountY = new JLabel("0");

        GridLayout layout = new GridLayout(2, 2, 0, 0);
        setLayout(layout);

        add(playerX);
        add(scoreCountX);
        add(playerY);
        add(scoreCountY);
    }

    public void updateScore() {
        ScoreInterface score = scorePresenter.getScore();

        scoreCountX.setText(String.valueOf(score.getXPlayer()));
        scoreCountY.setText(String.valueOf(score.getOPlayer()));
    }
}
