/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ccchess;

import java.awt.Point;

/**
 *
 * @author Owner
 */
public class StandardFormLocation {
    
    public StandardFormLocation(Character column, int row){
        this.column = column;
        this.row = row;
    }
    
    
    private Character column = 'a';
    private int row = 0;
    public static int MIN_ROW = 1;
    public static int MAX_ROW = 8;

    public Point getGridLocation(){
        Point location = new Point(0, 0);
        
        //Columns
        if (this.column == 'a') {
            location.x = 0;
        } else if (this.column == 'b') {
            location.x = 1;
        } else if (this.column == 'c') {
            location.x = 2;
        } else if (this.column == 'd') {
            location.x = 3;
        } else if (this.column == 'e') {
            location.x = 4;
        } else if (this.column == 'f') {
            location.x = 5;
        } else if (this.column == 'g') {
            location.x = 6;
        } else if (this.column == 'h') {
            location.x = 7;
        }
        
        //Rows
        if (this.row == 1) {
            location.y = 7;
        } else if (this.row == 2) {
            location.y = 6;
        } else if (this.row == 3) {
            location.y = 5;
        } else if (this.row == 4) {
            location.y = 4;
        } else if (this.row == 5) {
            location.y = 3;
        } else if (this.row == 6) {
            location.y = 2;
        } else if (this.row == 7) {
            location.y = 1;
        } else if (this.row == 8) {
            location.y = 0;
        }
        
        return location;
        
    }
    
    /**
     * @return the column
     */
    public Character getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(Character column) {
        this.column = column;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        if (row < MIN_ROW) {
           this.row = MIN_ROW; 
        } else if (row > MAX_ROW){
            this.row = MAX_ROW;
        } else {
            this.row = row;            
        }
    }
}
