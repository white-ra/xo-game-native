package controller;

import controller.listener.SetMarkListener;
import view.canvas.XOCanvas;
import view.panel.GameFieldPanel;

public class GameFieldPanelController {
    private final GameFieldPanel gameFieldPanel;
    private final SetMarkListener setMarkListener;

    public GameFieldPanelController(
        GameFieldPanel gameFieldPanel,
        SetMarkListener setMarkListener
    ) {
        this.gameFieldPanel = gameFieldPanel;
        this.setMarkListener = setMarkListener;

        XOCanvas canvas = this.gameFieldPanel.getXoCanvas();

        canvas.addMouseListener(this.setMarkListener);
    }
}
