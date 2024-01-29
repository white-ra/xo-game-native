package whitera.xogamenative.controller;

import whitera.xogamenative.model.contract.GameInterface;
import whitera.xogamenative.view.contract.ControlPanelInterface;
import whitera.xogamenative.view.contract.XOCanvasInterface;

import java.awt.event.ActionEvent;

public class ControlPanelController {
    private final ControlPanelInterface controlPanel;
    private final GameInterface game;
    private final XOCanvasInterface xoCanvas;

    public ControlPanelController(ControlPanelInterface controlPanel, GameInterface gameInterface, XOCanvasInterface xoCanvas) {
        this.controlPanel = controlPanel;
        this.game = gameInterface;
        this.xoCanvas = xoCanvas;

        this.controlPanel.getRestartButton().addActionListener(this::restartAction);
    }

    private void restartAction(ActionEvent e) {
        game.restartGame();
        xoCanvas.repaint();
    }
}
