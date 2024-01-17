package controller;

import view.panel.MenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainMenuPanelController {
    private final MenuPanel menuPanel;

    public MainMenuPanelController(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;

        JButton startGameButton = menuPanel.getStartGameButton();
        JButton exitGameButton = menuPanel.getExitGameButton();

        startGameButton.addActionListener(this::setStartGameAction);
        exitGameButton.addActionListener(this::setExitGameAction);
    }

    public void setStartGameAction(ActionEvent actionEvent) {
        System.out.println("START");
    }

    public void setExitGameAction(ActionEvent actionEvent) {
        System.out.println("EXIT");
    }
}
