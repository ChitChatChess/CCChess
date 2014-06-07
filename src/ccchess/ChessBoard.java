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
import images.ResourceTools;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
class ChessBoard extends Environment {

    StandardBoard board;
    private ArrayList<Chesspiece> chesspieces;
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
//        Chesspiece test = new Chesspiece('e', 1, Side.WHITE, ChesspieceType.KING, board, board);
//        test.setSelected(true);
//        this.getActors().add(test);
        chesspieces = new ArrayList<>();

        chesspieces.add(new Chesspiece('e', 1, Side.WHITE, ChesspieceType.KING, board, board));
        chesspieces.add(new Chesspiece('d', 1, Side.WHITE, ChesspieceType.QUEEN, board, board));
        chesspieces.add(new Chesspiece('c', 1, Side.WHITE, ChesspieceType.BISHOP, board, board));
        chesspieces.add(new Chesspiece('f', 1, Side.WHITE, ChesspieceType.BISHOP, board, board));
        chesspieces.add(new Chesspiece('b', 1, Side.WHITE, ChesspieceType.KNIGHT, board, board));
        chesspieces.add(new Chesspiece('g', 1, Side.WHITE, ChesspieceType.KNIGHT, board, board));
        chesspieces.add(new Chesspiece('a', 1, Side.WHITE, ChesspieceType.ROOK, board, board));
        chesspieces.add(new Chesspiece('h', 1, Side.WHITE, ChesspieceType.ROOK, board, board));
        chesspieces.add(new Chesspiece('a', 2, Side.WHITE, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('b', 2, Side.WHITE, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('c', 2, Side.WHITE, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('d', 2, Side.WHITE, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('e', 2, Side.WHITE, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('f', 2, Side.WHITE, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('g', 2, Side.WHITE, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('h', 2, Side.WHITE, ChesspieceType.PAWN, board, board));

        chesspieces.add(new Chesspiece('e', 8, Side.BLACK, ChesspieceType.KING, board, board));
        chesspieces.add(new Chesspiece('d', 8, Side.BLACK, ChesspieceType.QUEEN, board, board));
        chesspieces.add(new Chesspiece('c', 8, Side.BLACK, ChesspieceType.BISHOP, board, board));
        chesspieces.add(new Chesspiece('f', 8, Side.BLACK, ChesspieceType.BISHOP, board, board));
        chesspieces.add(new Chesspiece('b', 8, Side.BLACK, ChesspieceType.KNIGHT, board, board));
        chesspieces.add(new Chesspiece('g', 8, Side.BLACK, ChesspieceType.KNIGHT, board, board));
        chesspieces.add(new Chesspiece('a', 8, Side.BLACK, ChesspieceType.ROOK, board, board));
        chesspieces.add(new Chesspiece('h', 8, Side.BLACK, ChesspieceType.ROOK, board, board));
        chesspieces.add(new Chesspiece('a', 7, Side.BLACK, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('b', 7, Side.BLACK, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('c', 7, Side.BLACK, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('d', 7, Side.BLACK, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('e', 7, Side.BLACK, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('f', 7, Side.BLACK, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('g', 7, Side.BLACK, ChesspieceType.PAWN, board, board));
        chesspieces.add(new Chesspiece('h', 7, Side.BLACK, ChesspieceType.PAWN, board, board));

        this.getActors().addAll(chesspieces);

        image = (BufferedImage) ResourceTools.loadImageFromResource("chessres/Chessmen.png");

//        White
        w_king = ChesspieceImageFactory.getImage(Side.WHITE, ChesspieceType.KING);
        w_queen = ChesspieceImageFactory.getImage(Side.WHITE, ChesspieceType.QUEEN);
        w_bishop = ChesspieceImageFactory.getImage(Side.WHITE, ChesspieceType.BISHOP);
        w_knight = ChesspieceImageFactory.getImage(Side.WHITE, ChesspieceType.KNIGHT);
        w_rook = ChesspieceImageFactory.getImage(Side.WHITE, ChesspieceType.ROOK);
        w_pawn = ChesspieceImageFactory.getImage(Side.WHITE, ChesspieceType.PAWN);

//        Black
        b_king = ChesspieceImageFactory.getImage(Side.BLACK, ChesspieceType.KING);
        b_queen = ChesspieceImageFactory.getImage(Side.BLACK, ChesspieceType.QUEEN);
        b_bishop = ChesspieceImageFactory.getImage(Side.BLACK, ChesspieceType.BISHOP);
        b_knight = ChesspieceImageFactory.getImage(Side.BLACK, ChesspieceType.KNIGHT);
        b_rook = ChesspieceImageFactory.getImage(Side.BLACK, ChesspieceType.ROOK);
        b_pawn = ChesspieceImageFactory.getImage(Side.BLACK, ChesspieceType.PAWN);
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
        for (Chesspiece chesspiece : chesspieces) {
            if (chesspiece.contains(e.getPoint())) {
                //make all chesspieces deselected
                deselectAllPieces();

                chesspiece.setSelected(true);
                containsPiece = true;
                break;
            }
        }

        if (!containsPiece) {
            Point cell = this.board.getCellLocationFromSystemCoordinate(e.getPoint());
            System.out.println(cell);
            Chesspiece selectedChesspiece = getSelected();

            if (selectedChesspiece != null) {

                if (isMoveValid(selectedChesspiece, selectedChesspiece.getStandardFormLocation(), StandardFormLocation.getStandardFormLocation(cell.x, cell.y))) {
                    selectedChesspiece.setStandardFormLocation(StandardFormLocation.getStandardFormLocation(cell.x, cell.y));
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
                deselectAllPieces();
            }
        }
    }

    private Chesspiece getSelected() {
        for (Chesspiece chesspiece : chesspieces) {
            if (chesspiece.isSelected()) {
                return chesspiece;
            }
        }
        return null;
    }

    private void deselectAllPieces() {
        for (Chesspiece chesspiece : chesspieces) {
            chesspiece.setSelected(false);
        }
    }

    private Chesspiece getOccupant(StandardFormLocation location) {
        for (Chesspiece piece : chesspieces) {
            if (piece.getStandardFormLocation().equals(location)) {
                return piece;
            }
        }

        return null;
    }

    public boolean isMoveValid(Chesspiece chesspiece, StandardFormLocation currentSFLoc, StandardFormLocation proposedSFLoc) {
        //if space occupied by piece of same Side, then return false
        for (Chesspiece other : chesspieces) {
            if (other.getStandardFormLocation().equals(proposedSFLoc)) {
                //if colors match, not allowed
                if (chesspiece.getSide().equals(other.getSide())) {
                    System.out.println("Occupied by same colour!");
                    return false;
                }
            }
        }

        int xDiff = currentSFLoc.getGridLocation().x - proposedSFLoc.getGridLocation().x;
        int yDiff = currentSFLoc.getGridLocation().y - proposedSFLoc.getGridLocation().y;
        Chesspiece enemy = getOccupant(proposedSFLoc);

        switch (chesspiece.getType()) {
            case PAWN: //stuff
                //if pawn is white
                //   and row is 2 the can move +1 or +2

                if (chesspiece.getSide().equals(Side.WHITE)) {
                    if (currentSFLoc.getRow() == 2) {
                        return (((yDiff == 1) || (yDiff == 2)) && (xDiff == 0));
                    } else if ((yDiff == 1) && (Math.abs(xDiff) == 1)) {
                        if ((enemy != null) && (enemy.getSide() == Side.BLACK)) {
//                            remove enemy
                            enemy.setCaptured(true);
                            return true;
                        }
                    } else {
                        return ((yDiff == 1) && (xDiff == 0));

                        //if there is a piece in front of the piece diagonally, validate move and remove that piece
                        //if |xdifference between two pieces| = 1, ydifference between two pieces = 1
                    }
                } else if (chesspiece.getSide().equals(Side.BLACK)) {
                    if (currentSFLoc.getRow() == 7) {
                        return (((yDiff == -1) || (yDiff == -2)) && (xDiff == 0));
                    } else if ((yDiff == -1) && (Math.abs(xDiff) == 1)) {
                        if ((enemy != null) && (enemy.getSide() == Side.WHITE)) {
//                            remove enemy
                            enemy.setCaptured(true);
                            return true;
                        }
                    } else {
                        return ((yDiff == -1) && (xDiff == 0));
                    }
                }

            case ROOK:
                //if the path between the proposed location and the original 
                //location is a straight horizontal or vertical line, then validate move
                if (chesspiece.getSide().equals(Side.WHITE)) {
                    if ((xDiff == 0) || (yDiff == 0)) {
                        if ((enemy != null) && (enemy.getSide() == Side.BLACK)) {
//                            remove enemy
                            enemy.setCaptured(true);
                            return true;
                        }
                    }
                } else {
                    if (chesspiece.getSide().equals(Side.BLACK)) {
                        if ((xDiff == 0) || (yDiff == 0)) {
                            if ((enemy != null) && (enemy.getSide() == Side.WHITE)) {
//                            remove enemy
                                enemy.setCaptured(true);
                                return true;
                            }
                        }
                    }
                }
                return ((xDiff == 0) || (yDiff == 0));

            case KNIGHT:
                //if it moves two squares vertically and one square horizontally, or, two squares horizontally and one sqaure vertically, validate move
                if (chesspiece.getSide().equals(Side.WHITE)) {
                    if (((Math.abs(xDiff) == 1) && (Math.abs(yDiff) == 2))
                            || ((Math.abs(xDiff) == 2) && (Math.abs(yDiff) == 1))) {
                        if ((enemy != null) && (enemy.getSide() == Side.BLACK)) {
//                            remove enemy
                            enemy.setCaptured(true);
                            return true;
                        }
                    }
                } else {
                    if (chesspiece.getSide().equals(Side.BLACK)) {
                        if (((Math.abs(xDiff) == 1) && (Math.abs(yDiff) == 2))
                                || ((Math.abs(xDiff) == 2) && (Math.abs(yDiff) == 1))) {
                            if ((enemy != null) && (enemy.getSide() == Side.WHITE)) {
//                            remove enemy
                                enemy.setCaptured(true);
                                return true;
                            }
                        }
                    }
                }
                return (((Math.abs(xDiff) == 1) && (Math.abs(yDiff) == 2))
                        || ((Math.abs(xDiff) == 2) && (Math.abs(yDiff) == 1)));

            case BISHOP: //stuff
                //if the path between the proposed location and the original 
                //location is a straight diagonal(45 degrees) line, then validate move
                if (chesspiece.getSide().equals(Side.WHITE)) {
                    if (Math.abs(xDiff) == Math.abs(yDiff)) {
                        if ((enemy != null) && (enemy.getSide() == Side.BLACK)) {
//                            remove enemy
                            enemy.setCaptured(true);
                            return true;
                        }
                    }
                } else {
                    if (chesspiece.getSide().equals(Side.BLACK)) {
                        if (Math.abs(xDiff) == Math.abs(yDiff)) {
                            if ((enemy != null) && (enemy.getSide() == Side.WHITE)) {
//                            remove enemy
                                enemy.setCaptured(true);
                                return true;
                            }
                        }
                    }
                }
                return (Math.abs(xDiff) == Math.abs(yDiff));

            case KING: //stuff
                //If the proposed position is directly left, right, above, below, 
                //or diagonal to the original location, then move the piece
                if (chesspiece.getSide().equals(Side.WHITE)) {
                    if ((Math.abs(xDiff) <= 1) && (Math.abs(yDiff) <= 1)) {
                        if ((enemy != null) && (enemy.getSide() == Side.BLACK)) {
//                            remove enemy
                            enemy.setCaptured(true);
                            return true;
                        }
                    }
                } else {
                    if (chesspiece.getSide().equals(Side.BLACK)) {
                        if ((Math.abs(xDiff) <= 1) && (Math.abs(yDiff) <= 1)) {
                            if ((enemy != null) && (enemy.getSide() == Side.WHITE)) {
//                            remove enemy
                                enemy.setCaptured(true);
                                return true;
                            }
                        }
                    }
                }
                return ((Math.abs(xDiff) <= 1) && (Math.abs(yDiff) <= 1));

            case QUEEN: //stuff
                if (chesspiece.getSide().equals(Side.WHITE)) {
                    if ((Math.abs(xDiff) == Math.abs(yDiff)) || (xDiff == 0) || (yDiff == 0)) {
                        if ((enemy != null) && (enemy.getSide() == Side.BLACK)) {
//                            remove enemy
                            enemy.setCaptured(true);
                            return true;
                        }
                    }
                } else {
                    if (chesspiece.getSide().equals(Side.BLACK)) {
                        if ((Math.abs(xDiff) == Math.abs(yDiff)) || (xDiff == 0) || (yDiff == 0)) {
                            if ((enemy != null) && (enemy.getSide() == Side.WHITE)) {
//                            remove enemy
                                enemy.setCaptured(true);
                                return true;
                            }
                        }
                    }
                }
                return ((Math.abs(xDiff) == Math.abs(yDiff)) || (xDiff == 0) || (yDiff == 0));
        }
        return true;
    }

    @Override
    public void paintEnvironment(Graphics graphics
    ) {
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
