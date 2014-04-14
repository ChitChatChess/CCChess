/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ccchess;

import environment.ApplicationStarter;
import java.awt.Dimension;

/**
 *
 * @author Owner
 */
public class CCChess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
        
    }

    private static void start() {
        ApplicationStarter.run(new String[0], "CCChess", new Dimension(980, 1000), new ChessBoard());
    }
    
}
