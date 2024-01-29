package whitera.xogamenative.controller;

import whitera.xogamenative.controller.listener.SetMarkListener;
import whitera.xogamenative.view.canvas.XOCanvas;
import whitera.xogamenative.view.panel.GameFieldPanel;

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
