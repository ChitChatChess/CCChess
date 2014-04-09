/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ccchess;

import environment.Environment;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Point;
import grid.Grid;
import image.ResourceTools;
import java.awt.Color;


/**
 *
 * @author Owner
 */
class ChessBoard extends Environment {
    
    StandardBoard Board;

    @Override
    public void initializeEnvironment() {
        
        this.setBackground(ResourceTools.loadImageFromResource("chessres/Chess Wood.sjpg"));
        
        Board = new StandardBoard();
        Board.setCellHeight(100);
        Board.setCellWidth(100);
        Board.setColumns(8);
        Board.setRows(8);
        Board.setPosition(new Point(80, 80));
        Board.setColor(new Color(0,0,0,0));
    }

    @Override
    public void timerTaskHandler() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (Board != null) {
            Board.paintComponent(graphics);
        }
    }

    
}
