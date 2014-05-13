/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccchess;

import environment.Actor;
import environment.Environment;
import environment.Velocity;
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

    StandardBoard board;

    BufferedImage image, w_king, w_queen, w_bishop, w_knight, w_rook, w_pawn, b_king, b_queen, b_bishop, b_knight, b_rook, b_pawn;

    @Override
    public void initializeEnvironment() {

        this.setBackground(ResourceTools.loadImageFromResource("chessres/chess_wood.jpg"));

        board = new StandardBoard();
        board.setCellHeight(75);
        board.setCellWidth(75);
        board.setColumns(8);
        board.setRows(8);
        board.setPosition(new Point(80, 80));
        board.setColor(new Color(0, 0, 0, 0));

        //Default Locations
        Chesspiece test = new Chesspiece('e', 1, ChesspieceColor.WHITE, ChesspieceType.KING, board, board);
        test.setSelected(true);

        this.getActors().add(test);
        //this.getActors().add(new Chesspiece('e', 1, ChesspieceColor.WHITE, ChesspieceType.KING, board));
        this.getActors().add(new Chesspiece('d', 1, ChesspieceColor.WHITE, ChesspieceType.QUEEN, board, board));
        this.getActors().add(new Chesspiece('c', 1, ChesspieceColor.WHITE, ChesspieceType.BISHOP, board, board));
        this.getActors().add(new Chesspiece('f', 1, ChesspieceColor.WHITE, ChesspieceType.BISHOP, board, board));
        this.getActors().add(new Chesspiece('b', 1, ChesspieceColor.WHITE, ChesspieceType.KNIGHT, board, board));
        this.getActors().add(new Chesspiece('g', 1, ChesspieceColor.WHITE, ChesspieceType.KNIGHT, board, board));
        this.getActors().add(new Chesspiece('a', 1, ChesspieceColor.WHITE, ChesspieceType.ROOK, board, board));
        this.getActors().add(new Chesspiece('h', 1, ChesspieceColor.WHITE, ChesspieceType.ROOK, board, board));
        this.getActors().add(new Chesspiece('a', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('b', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('c', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('d', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('e', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('f', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('g', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('h', 2, ChesspieceColor.WHITE, ChesspieceType.PAWN, board, board));

        this.getActors().add(new Chesspiece('e', 8, ChesspieceColor.BLACK, ChesspieceType.KING, board, board));
        this.getActors().add(new Chesspiece('d', 8, ChesspieceColor.BLACK, ChesspieceType.QUEEN, board, board));
        this.getActors().add(new Chesspiece('c', 8, ChesspieceColor.BLACK, ChesspieceType.BISHOP, board, board));
        this.getActors().add(new Chesspiece('f', 8, ChesspieceColor.BLACK, ChesspieceType.BISHOP, board, board));
        this.getActors().add(new Chesspiece('b', 8, ChesspieceColor.BLACK, ChesspieceType.KNIGHT, board, board));
        this.getActors().add(new Chesspiece('g', 8, ChesspieceColor.BLACK, ChesspieceType.KNIGHT, board, board));
        this.getActors().add(new Chesspiece('a', 8, ChesspieceColor.BLACK, ChesspieceType.ROOK, board, board));
        this.getActors().add(new Chesspiece('h', 8, ChesspieceColor.BLACK, ChesspieceType.ROOK, board, board));
        this.getActors().add(new Chesspiece('a', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('b', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('c', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('d', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('e', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('f', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('g', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));
        this.getActors().add(new Chesspiece('h', 7, ChesspieceColor.BLACK, ChesspieceType.PAWN, board, board));

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
//        if (e.getKeyCode() == KeyEvent.VK_A) {
//            ( (Chesspiece)this.getActors().get(0)).setStandardFormLocation('e', 4);
//        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
//        System.out.println(" Mouse position = " + e.getPoint().x + ", " + e.getPoint().y);
        boolean containsPiece = false;

        //test if mouse position is inside any of the piece, then mark as selected
        for (Actor chesspiece : getActors()) {
            if (chesspiece.contains(e.getPoint())) {
                //make all chesspieces deselected
                deselectAllPieces();

                ((Chesspiece) chesspiece).setSelected(true);
                containsPiece = true;
                break;
            }
        }

        if (!containsPiece) {
            Point cell = this.board.getCellLocationFromSystemCoordinate(e.getPoint());
            System.out.println(cell);
            Chesspiece selectedChesspiece = getSelected();
            if (selectedChesspiece != null) {
                selectedChesspiece.setStandardFormLocation(StandardFormLocation.getStandardFormLocation(cell.x, cell.y));
                deselectAllPieces();
            }

        }

    }

    private Chesspiece getSelected() {
        for (Actor chesspiece : getActors()) {
            if (((Chesspiece) chesspiece).isSelected()) {
                return (Chesspiece) chesspiece;
            }
        }
        return null;
    }

    private void deselectAllPieces() {
        for (Actor chessmen : getActors()) {
            ((Chesspiece) chessmen).setSelected(false);
        }
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
//       board
        if (board != null) {
            board.paintComponent(graphics);
        }

////       White Chesspieces
//        if (w_king != null) {
//            graphics.drawImage(w_king, 100, 0, this);
//        }
//        if (w_queen != null) {
//            graphics.drawImage(w_queen, 200, 0, this);
//        }
//        if (w_bishop != null) {
//            graphics.drawImage(w_bishop, 300, 0, this);
//        }
//        if (w_knight != null) {
//            graphics.drawImage(w_knight, 400, 0, this);
//        }
//        if (w_rook != null) {
//            graphics.drawImage(w_rook, 500, 0, this);
//        }
//        if (w_pawn != null) {
//            graphics.drawImage(w_pawn, 600, 0, this);
//        }
//        
////        Black Chesspieces
//        if (b_king != null) {
//            graphics.drawImage(b_king, 100, 80, this);
//        }
//        if (b_queen != null) {
//            graphics.drawImage(b_queen, 200, 80, this);
//        }
//        if (b_bishop != null) {
//            graphics.drawImage(b_bishop, 300, 80, this);
//        }
//        if (b_knight != null) {
//            graphics.drawImage(b_knight, 400, 80, this);
//        }
//        if (b_rook != null) {
//            graphics.drawImage(b_rook, 500, 80, this);
//        }
//        if (b_pawn != null) {
//            graphics.drawImage(b_pawn, 600, 80, this);
//        }
    }

}
