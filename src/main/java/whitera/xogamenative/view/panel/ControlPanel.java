package whitera.xogamenative.view.panel;

import whitera.xogamenative.view.contract.ControlPanelInterface;

import javax.swing.*;

public class ControlPanel extends JPanel implements ControlPanelInterface {
    private final JButton restartButton;

    public ControlPanel() {
        this.restartButton = new JButton("Restart");

        add(restartButton);
    }

    public JButton getRestartButton() {
        return restartButton;
    }
}
