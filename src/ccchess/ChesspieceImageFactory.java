/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccchess;

import image.ResourceTools;
import java.awt.image.BufferedImage;

/**
 *
 * @author Owner
 */
public class ChesspieceImageFactory {

    public static BufferedImage getImage(Side side, ChesspieceType type) {
        BufferedImage chessmen = (BufferedImage) ResourceTools.loadImageFromResource("chessres/Chessmen.png");

//        White
        if (side == Side.WHITE) {
            if (type == ChesspieceType.KING) {
                return chessmen.getSubimage(17, 15, 38, 38);
            } else if (type == ChesspieceType.QUEEN) {
                return chessmen.getSubimage(77, 14, 42, 39);
            } else if (type == ChesspieceType.BISHOP) {
                return chessmen.getSubimage(203, 15, 38, 37);
            } else if (type == ChesspieceType.KNIGHT) {
                return chessmen.getSubimage(265, 15, 38, 37);
            } else if (type == ChesspieceType.ROOK) {
                return chessmen.getSubimage(143, 16, 33, 37);
            } else if (type == ChesspieceType.PAWN) {
                return chessmen.getSubimage(332, 15, 28, 37);
            }
        }
        
//        Black
        if (side == Side.BLACK) {
            if (type == ChesspieceType.KING) {
                return chessmen.getSubimage(17, 75, 37, 37);
            } else if (type == ChesspieceType.QUEEN) {
                return chessmen.getSubimage(77, 74, 41, 38);
            } else if (type == ChesspieceType.BISHOP) {
                return chessmen.getSubimage(203, 75, 37, 36);
            } else if (type == ChesspieceType.KNIGHT) {
                return chessmen.getSubimage(265, 75, 37, 36);
            } else if (type == ChesspieceType.ROOK) {
                return chessmen.getSubimage(143, 76, 32, 36);
            } else if (type == ChesspieceType.PAWN) {
                return chessmen.getSubimage(332, 75, 27, 36);
            }
        }

        return chessmen.getSubimage(17, 15, 37, 37);
    }
}
