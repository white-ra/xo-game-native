package whitera.xogamenative.view.panel;

import whitera.xogamenative.view.canvas.XOCanvas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class GameFieldPanel extends JPanel {
    private final XOCanvas xoCanvas;

    public GameFieldPanel(XOCanvas xoCanvas) {
        this.xoCanvas = xoCanvas;

        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        add(this.xoCanvas);
    }

    public XOCanvas getXoCanvas() {
        return xoCanvas;
    }
}
