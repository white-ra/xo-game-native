package whitera.xogamenative.view.panel;

import whitera.xogamenative.contract.constant.GameFieldPanelConst;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MenuPanel extends JPanel {
    public static final Integer WIDTH = 150;
    private static final Integer HEIGHT = GameFieldPanelConst.HEIGHT;

    private final ScorePanel scorePanel;
    private final ControlPanel controlPanel;
    private final EventPanel eventPanel;

    public MenuPanel(ScorePanel scorePanel, ControlPanel controlPanel, EventPanel eventPanel) {
        this.scorePanel = scorePanel;
        this.controlPanel = controlPanel;
        this.eventPanel = eventPanel;

        GridLayout layout = new GridLayout(3, 1, 7, 7);
        setLayout(layout);

        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        add(this.scorePanel);
        add(this.controlPanel);
        add(this.eventPanel);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
