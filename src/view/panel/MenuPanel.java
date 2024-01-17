package view.panel;

import javax.swing.*;

public class MenuPanel extends JPanel {
    private final JButton startGameButton = new JButton("Start");
    private final JButton exitGameButton = new JButton("Exit");

    public MenuPanel() {
        GroupLayout groupLayout = new GroupLayout(this);
        setLayout(groupLayout);

        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(startGameButton)
                .addComponent(exitGameButton)
        );

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addComponent(startGameButton)
                .addComponent(exitGameButton)
        );
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }

    public JButton getExitGameButton() {
        return exitGameButton;
    }
}
