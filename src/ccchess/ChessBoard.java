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
import java.awt.image.BufferedImage;

/**
 *
 * @author Owner
 */
class ChessBoard extends Environment {

    StandardBoard Board;

    BufferedImage image, w_king, w_queen, w_bishop, w_knight, w_rook, w_pawn, b_king, b_queen, b_bishop, b_knight, b_rook, b_pawn;

    @Override
    public void initializeEnvironment() {

        this.setBackground(ResourceTools.loadImageFromResource("chessres/chess_wood.jpg"));

        Board = new StandardBoard();
        Board.setCellHeight(75);
        Board.setCellWidth(75);
        Board.setColumns(8);
        Board.setRows(8);
        Board.setPosition(new Point(80, 80));
        Board.setColor(new Color(0, 0, 0, 0));

        image = (BufferedImage) ResourceTools.loadImageFromResource("chessres/Chessmen.png");

//        White
        w_king = ChesspieceImageFactory.getImage(ChesspieceColor.WHITE, ChesspieceType.KING);
        w_queen = ChesspieceImageFactory.getImage(ChesspieceColor.WHITE, ChesspieceType.QUEEN);
        w_bishop = ChesspieceImageFactory.getImage(ChesspieceColor.WHITE, ChesspieceType.BISHOP);
        w_knight = ChesspieceImageFactory.getImage(ChesspieceColor.WHITE, ChesspieceType.KNIGHT);
        w_rook = ChesspieceImageFactory.getImage(ChesspieceColor.WHITE, ChesspieceType.ROOK);
        w_pawn = ChesspieceImageFactory.getImage(ChesspieceColor.WHITE, ChesspieceType.PAWN);
        
//        Black
        b_king = ChesspieceImageFactory.getImage(ChesspieceColor.BLACK, ChesspieceType.KING);
        b_queen = ChesspieceImageFactory.getImage(ChesspieceColor.BLACK, ChesspieceType.QUEEN);
        b_bishop = ChesspieceImageFactory.getImage(ChesspieceColor.BLACK, ChesspieceType.BISHOP);
        b_knight = ChesspieceImageFactory.getImage(ChesspieceColor.BLACK, ChesspieceType.KNIGHT);
        b_rook = ChesspieceImageFactory.getImage(ChesspieceColor.BLACK, ChesspieceType.ROOK);
        b_pawn = ChesspieceImageFactory.getImage(ChesspieceColor.BLACK, ChesspieceType.PAWN);
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
//       Board
        if (Board != null) {
            Board.paintComponent(graphics);
        }
        
//       White Chesspieces
        if (w_king != null) {
            graphics.drawImage(w_king, 100, 0, this);
        }
        if (w_queen != null) {
            graphics.drawImage(w_queen, 200, 0, this);
        }
        if (w_bishop != null) {
            graphics.drawImage(w_bishop, 300, 0, this);
        }
        if (w_knight != null) {
            graphics.drawImage(w_knight, 400, 0, this);
        }
        if (w_rook != null) {
            graphics.drawImage(w_rook, 500, 0, this);
        }
        if (w_pawn != null) {
            graphics.drawImage(w_pawn, 600, 0, this);
        }
        
//        Black Chesspieces
        if (b_king != null) {
            graphics.drawImage(b_king, 100, 80, this);
        }
        if (b_queen != null) {
            graphics.drawImage(b_queen, 200, 80, this);
        }
        if (b_bishop != null) {
            graphics.drawImage(b_bishop, 300, 80, this);
        }
        if (b_knight != null) {
            graphics.drawImage(b_knight, 400, 80, this);
        }
        if (b_rook != null) {
            graphics.drawImage(b_rook, 500, 80, this);
        }
        if (b_pawn != null) {
            graphics.drawImage(b_pawn, 600, 80, this);
        }
        
    }

}
