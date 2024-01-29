package whitera.xogamenative.view.panel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class TitlePanel extends JPanel {
    private final JLabel titleLabel;

    public TitlePanel() {
        titleLabel = new JLabel("XO Game");

        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        add(titleLabel);
    }
}
