package whitera.xogamenative.controller.listener;

import whitera.xogamenative.contract.constant.GameFieldPanelConst;
import whitera.xogamenative.contract.enums.EventEnum;
import whitera.xogamenative.model.contract.GameInterface;
import whitera.xogamenative.view.contract.EventPanelInterface;
import whitera.xogamenative.view.contract.ScorePanelInterface;
import whitera.xogamenative.view.contract.XOCanvasInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SetMarkListener implements MouseListener {
    private final GameInterface game;
    private final XOCanvasInterface xoCanvas;
    private final ScorePanelInterface scorePanel;
    private final EventPanelInterface eventPanel;

    public SetMarkListener(
        GameInterface game,
        XOCanvasInterface xoCanvas,
        ScorePanelInterface scorePanel,
        EventPanelInterface eventPanel
    ) {
        this.game = game;
        this.xoCanvas = xoCanvas;
        this.scorePanel = scorePanel;
        this.eventPanel = eventPanel;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        EventEnum event = game.doTurn(
            covertMouseXPositionToXCoordinate(e.getX()),
            covertMouseYPositionToYCoordinate(e.getY())
        );

        scorePanel.updateScore();
        xoCanvas.repaint();
        eventPanel.setEvent(event);
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
        return (int) Math.ceil((double) mouseXPosition / ((double) GameFieldPanelConst.WIDTH / 3));
    }

    private Integer covertMouseYPositionToYCoordinate(Integer mouseYPosition) {
        return (int) Math.ceil((double) mouseYPosition / ((double) GameFieldPanelConst.HEIGHT / 3));
    }
}
