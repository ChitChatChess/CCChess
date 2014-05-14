/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccchess;

import environment.Actor;
import environment.Velocity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Owner
 */
public class Chesspiece extends Actor {

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        if (selected) {
            graphics.setColor(Color.red);
            graphics.drawRect(getPosition().x - 5, getPosition().y - 5, this.getObjectBoundary().width + 10, this.getObjectBoundary().height + 10);
        }
    }

    public Chesspiece(Character column, int row, Side side, ChesspieceType type,
            StandardFormLocationCoordinateTranslatorIntf locationTranslator, CellSizeProviderIntf cellSizeProvider) {
        super(new Point(0, 0), new Velocity(0, 0));
        this.cellSizeProvider = cellSizeProvider;
        this.side = side;
        this.type = type;
        this.locationTranslator = locationTranslator;
        this.setImage(ChesspieceImageFactory.getImage(side, type));
        this.setStandardFormLocation(column, row);
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private final StandardFormLocationCoordinateTranslatorIntf locationTranslator;
    private boolean selected = false;
    private Side side  = Side.WHITE;
    private ChesspieceType type;
    private StandardFormLocation standardFormLocation = new StandardFormLocation('a', 1);
    private CellSizeProviderIntf cellSizeProvider;

    /**
     * @return the type
     */
    public ChesspieceType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ChesspieceType type) {
        this.type = type;
    }

    /**
     * @return the standardFormLocation
     */
    public StandardFormLocation getStandardFormLocation() {
        return standardFormLocation;
    }

    /**
     * @param standardFormLocation the standardFormLocation to set
     */
    public void setStandardFormLocation(StandardFormLocation standardFormLocation) {
        this.standardFormLocation = standardFormLocation;
        updatePosition();
    }

    /**
     * @param standardFormLocation the standardFormLocation to set
     */
    public void setStandardFormLocation(Character column, int row) {
        this.standardFormLocation.setColumn(column);
        this.standardFormLocation.setRow(row);

        updatePosition();
    }

    private void updatePosition() {
        if (this.locationTranslator != null) {
//            this.setPosition(locationTranslator.getScreenLocationFromStandardFormLocation(standardFormLocation));
            Point temp = locationTranslator.getScreenLocationFromStandardFormLocation(standardFormLocation);
            Dimension size = cellSizeProvider.getCellSize();

            temp.x += (size.width - this.getObjectBoundary().width) / 2; //math
            temp.y += (size.height - this.getObjectBoundary().height) / 2;
            this.setPosition(temp);
        }
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the side
     */
    public Side getSide() {
        return side;
    }

    /**
     * @param side the side to set
     */
    public void setSide(Side side) {
        this.side = side;
    }
//</editor-fold>
}
