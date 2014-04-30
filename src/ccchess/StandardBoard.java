/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccchess;

import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Owner
 */
public class StandardBoard extends Grid implements StandardFormLocationCoordinateTranslatorIntf {

    private Color light = Color.WHITE;
    private Color dark = new Color(205,133,63);

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (int row = 0; row < this.getRows(); row++) {
            for (int column = 0; column < this.getColumns(); column++) {
                if ((row + column) % 2 == 0) {
                    graphics.setColor(light);
                } else {
                    graphics.setColor(dark);
                }
                graphics.fillRect(this.getCellSystemCoordinate(column, row).x, this.getCellSystemCoordinate(column, row).y, this.getCellWidth(), this.getCellHeight());
            }
        }
    }
    
//<editor-fold defaultstate="collapsed" desc="StandardFormLocationCoordinateTranslatorIntf Methods">
    @Override
    public Point getScreenLocationFromStandardFormLocation(StandardFormLocation sfloc) {
        return this.getCellSystemCoordinate(sfloc.getGridLocation());
    }
//</editor-fold>
}
