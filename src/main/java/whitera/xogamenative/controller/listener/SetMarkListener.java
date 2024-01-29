package whitera.xogamenative.controller.listener;

import whitera.xogamenative.contract.constant.XOCanvasConst;
import whitera.xogamenative.model.contract.GameInterface;
import whitera.xogamenative.view.contract.ScorePanelInterface;
import whitera.xogamenative.view.contract.XOCanvasInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SetMarkListener implements MouseListener {
    private final GameInterface game;
    private final XOCanvasInterface xoCanvas;
    private final ScorePanelInterface scorePanel;

    public SetMarkListener(GameInterface game, XOCanvasInterface xoCanvas, ScorePanelInterface scorePanel) {
        this.game = game;
        this.xoCanvas = xoCanvas;
        this.scorePanel = scorePanel;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.doTurn(
            covertMouseXPositionToXCoordinate(e.getX()),
            covertMouseYPositionToYCoordinate(e.getY())
        );

        scorePanel.updateScore();
        xoCanvas.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private Integer covertMouseXPositionToXCoordinate(Integer mouseXPosition) {
        return (int) Math.ceil((double) mouseXPosition / ((double) XOCanvasConst.WIDTH / 3));
    }

    private Integer covertMouseYPositionToYCoordinate(Integer mouseYPosition) {
        return (int) Math.ceil((double) mouseYPosition / ((double) XOCanvasConst.HEIGHT / 3));
    }
}
