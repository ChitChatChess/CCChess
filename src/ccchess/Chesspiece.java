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

//    public static void chesspieceFactory(ChesspieceColor color, ChesspieceType type){
//        return Chesspiece(new Point(0, 0), new Velocity(0, 0), color, type);
//    }
    
    
    public Chesspiece(Point position, Velocity velocity, ChesspieceColor color, ChesspieceType type) {
        super(position, velocity);
        this.color = color;
        this.type = type;
//        this.setImage(????);
    }
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private ChesspieceColor color;
    private ChesspieceType type;
    
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
    
}
