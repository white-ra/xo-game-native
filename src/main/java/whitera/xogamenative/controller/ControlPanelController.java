package whitera.xogamenative.controller;

import whitera.xogamenative.contract.enums.EventEnum;
import whitera.xogamenative.model.contract.GameInterface;
import whitera.xogamenative.view.contract.ControlPanelInterface;
import whitera.xogamenative.view.contract.EventPanelInterface;
import whitera.xogamenative.view.contract.XOCanvasInterface;

import java.awt.event.ActionEvent;

public class ControlPanelController {
    private final ControlPanelInterface controlPanel;
    private final GameInterface game;
    private final XOCanvasInterface xoCanvas;
    private final EventPanelInterface eventPanel;

    public ControlPanelController(
        ControlPanelInterface controlPanel,
        GameInterface gameInterface,
        XOCanvasInterface xoCanvas,
        EventPanelInterface eventPanel
    ) {
        this.controlPanel = controlPanel;
        this.game = gameInterface;
        this.xoCanvas = xoCanvas;
        this.eventPanel = eventPanel;

        this.controlPanel.getRestartButton().addActionListener(this::restartAction);
    }

    private void restartAction(ActionEvent e) {
        EventEnum event = game.restartGame();
        xoCanvas.repaint();

        eventPanel.setEvent(event);
    }
}
