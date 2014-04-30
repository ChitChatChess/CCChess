/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ccchess;

import environment.Actor;
import environment.Velocity;
import java.awt.Point;



/**
 *
 * @author Owner
 */
public class Chesspiece extends Actor {
    private StandardFormLocationCoordinateTranslatorIntf locationTranslator;

    
//    public Chesspiece(Point position, Velocity velocity, ChesspieceColor color, ChesspieceType type) {
    public Chesspiece(Character column, int row, ChesspieceColor color, ChesspieceType type, StandardFormLocationCoordinateTranslatorIntf locationTranslator) {
        super(new Point(0, 0), new Velocity(0, 0));
        this.color = color;
        this.type = type;
        this.locationTranslator = locationTranslator;
        this.setImage(ChesspieceImageFactory.getImage(color, type));
        this.setStandardFormLocation(column, row);
    }
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private ChesspieceColor color;
    private ChesspieceType type;
    private StandardFormLocation standardFormLocation = new StandardFormLocation('a', 1);
    
    /**
     * @return the color
     */
    public ChesspieceColor getColor() {
        return color;
    }
    
    /**
     * @param color the color to set
     */
    public void setColor(ChesspieceColor color) {
        this.color = color;
    }
    
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
//</editor-fold>

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
            this.setPosition(locationTranslator.getScreenLocationFromStandardFormLocation(standardFormLocation));
        }
    }
    
}
