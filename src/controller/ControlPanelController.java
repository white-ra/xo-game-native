package controller;

import model.contract.GameInterface;
import view.contract.ControlPanelInterface;
import view.contract.XOCanvasInterface;

import java.awt.event.ActionEvent;

public class ControlPanelController {
    private final ControlPanelInterface controlPanel;
    private final GameInterface game;
    private final XOCanvasInterface xoCanvas;

    public ControlPanelController(ControlPanelInterface controlPanel, GameInterface gameInterface, XOCanvasInterface xoCanvas) {
        this.controlPanel = controlPanel;
        this.game = gameInterface;
        this.xoCanvas = xoCanvas;

        controlPanel.getRestartButton().addActionListener(this::restartAction);
    }

    private void restartAction(ActionEvent e) {
        game.restart();
        xoCanvas.repaint();
    }
}
