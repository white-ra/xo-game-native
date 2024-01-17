package view;

import view.panel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final static String GAME_TITLE = "XO Game";
    private final static Integer GAME_WIDTH = 300;
    private final static Integer GAME_HEIGHT = 300;

    private final MenuPanel menuPanel;

    public MainFrame(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        add(this.menuPanel, BorderLayout.CENTER);

        setTitle(GAME_TITLE);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        showFrame();
    }

    private void showFrame() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
