package view.canvas;

import contract.constant.XOCanvasConst;
import contract.enums.PlayerMarkEnum;
import presenter.MapPresenterInterface;
import view.contract.XOCanvasInterface;
import view.exception.IncorrectMarkValueException;

import java.awt.*;

public class XOCanvas extends Canvas implements XOCanvasInterface {
    private final MapPresenterInterface mapPresenter;
    private Graphics2D graphics2D;

    public XOCanvas(MapPresenterInterface mapPresenter) {
        this.mapPresenter = mapPresenter;

        setSize(XOCanvasConst.WIDTH, XOCanvasConst.HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.graphics2D = (Graphics2D) g;

        drawGameGrid();
    }

    private void drawGameGrid() {
        graphics2D.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());
        graphics2D.drawLine(getWidth() / 3 * 2, 0, getWidth() / 3 * 2, getHeight());

        graphics2D.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3);
        graphics2D.drawLine(0, getHeight() / 3 * 2, getWidth(), getHeight() / 3 * 2);

        drawPlayersMarks(mapPresenter.getMap().getField());
    }

    private void drawPlayersMarks(PlayerMarkEnum[] marks) {
        for (int i = 0; i < marks.length; i++) {
            if (null == marks[i]) {
                continue;
            }

            drawMark(convertIndexToXCoordinate(i), convertIndexToYCoordinate(i), marks[i]);
        }
    }

    private void drawMark(Integer xCoordinate, Integer yCoordinate, PlayerMarkEnum playerMarkEnum) {
        int xMin = getWidth() / 3 * (xCoordinate - 1);
        int yMin = getHeight() / 3 * (yCoordinate - 1);

        int xMax = getWidth() / 3 * xCoordinate;
        int yMax = getHeight() / 3 * yCoordinate;

        int squareWidth = xMax - xMin;
        int squareHeight = yMax - yMin;

        int xOffset = squareWidth / 5;
        int yOffset = squareHeight / 5;

        if (PlayerMarkEnum.X.equals(playerMarkEnum)) {
            graphics2D.drawLine(xMin + xOffset, yMin + yOffset, xMax - xOffset, yMax - yOffset);
            graphics2D.drawLine(xMax - xOffset, yMin + yOffset, xMin + xOffset, yMax - yOffset);
        } else if (PlayerMarkEnum.O.equals(playerMarkEnum)) {
            graphics2D.drawOval(
                xMin + xOffset,
                yMin + xOffset,
                squareWidth - 2 * xOffset,
                squareHeight - 2 * yOffset
            );
        } else {
            throw new IncorrectMarkValueException();
        }
    }

    private Integer convertIndexToXCoordinate(Integer index) {
        int result = (index + 1) % 3;

        if (0 == result) {
            return 3;
        }

        return result;
    }

    private Integer convertIndexToYCoordinate(Integer index) {
        return (int) Math.ceil((float) (index + 1) / 3);
    }
}
