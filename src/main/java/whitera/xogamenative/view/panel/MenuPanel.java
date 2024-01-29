package whitera.xogamenative.view.panel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MenuPanel extends JPanel {
    private final ScorePanel scorePanel;
    private final ControlPanel controlPanel;

    public MenuPanel(ScorePanel scorePanel, ControlPanel controlPanel) {
        this.scorePanel = scorePanel;
        this.controlPanel = controlPanel;

        GridLayout layout = new GridLayout(2, 1, 7, 7);
        setLayout(layout);

        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        add(this.scorePanel);
        add(this.controlPanel);
    }
}
