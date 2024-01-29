package whitera.xogamenative.view;

import whitera.xogamenative.view.panel.GameFieldPanel;
import whitera.xogamenative.view.panel.MenuPanel;
import whitera.xogamenative.view.panel.TitlePanel;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    private final static String GAME_TITLE = "XO Game";

    private final TitlePanel titlePanel;
    private final MenuPanel menuPanel;
    private final GameFieldPanel gameFieldPanel;

    public MainFrame(TitlePanel titlePanel, MenuPanel menuPanel, GameFieldPanel gameFieldPanel) {
        this.titlePanel = titlePanel;
        this.menuPanel = menuPanel;
        this.gameFieldPanel = gameFieldPanel;

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        add(this.titlePanel, NORTH);
        add(this.menuPanel, WEST);
        add(this.gameFieldPanel, CENTER);

        setTitle(GAME_TITLE);

        showFrame();
    }

    private void showFrame() {
        pack();
        setResizable(false);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
