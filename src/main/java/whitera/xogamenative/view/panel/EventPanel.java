package whitera.xogamenative.view.panel;

import whitera.xogamenative.contract.enums.EventEnum;
import whitera.xogamenative.view.contract.EventPanelInterface;

import javax.swing.*;

public class EventPanel extends JPanel implements EventPanelInterface {
    private final JLabel event;

    public EventPanel() {
        this.event = new JLabel(EventEnum.GAME_START.getMessage());

        add(this.event);
    }

    @Override
    public void setEvent(EventEnum eventEnum) {
        event.setText(eventEnum.getMessage());
    }
}
