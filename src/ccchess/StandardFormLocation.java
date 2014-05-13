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
        return getGridLocation(column, row);
    }
        
    public static Point getGridLocation(Character column, int row){
        Point location = new Point(0, 0);
        
        //Columns
        if (column == 'a') {
            location.x = 0;
        } else if (column == 'b') {
            location.x = 1;
        } else if (column == 'c') {
            location.x = 2;
        } else if (column == 'd') {
            location.x = 3;
        } else if (column == 'e') {
            location.x = 4;
        } else if (column == 'f') {
            location.x = 5;
        } else if (column == 'g') {
            location.x = 6;
        } else if (column == 'h') {
            location.x = 7;
        }
        
        //Rows
        if (row == 1) {
            location.y = 7;
        } else if (row == 2) {
            location.y = 6;
        } else if (row == 3) {
            location.y = 5;
        } else if (row == 4) {
            location.y = 4;
        } else if (row == 5) {
            location.y = 3;
        } else if (row == 6) {
            location.y = 2;
        } else if (row == 7) {
            location.y = 1;
        } else if (row == 8) {
            location.y = 0;
        }
        
        return location;        
    }

    public static StandardFormLocation getStandardFormLocation(int column, int row){
        StandardFormLocation sfLocation = new StandardFormLocation('a', 0);
        
        //Columns
        if (column == 0) {
            sfLocation.column = 'a';
        } else if (column == 1) {
            sfLocation.column = 'b';
        } else if (column == 2) {
            sfLocation.column = 'c';
        } else if (column == 3) {
            sfLocation.column = 'd';
        } else if (column == 4) {
            sfLocation.column = 'e';
        } else if (column == 5) {
            sfLocation.column = 'f';
        } else if (column == 6) {
            sfLocation.column = 'g';
        } else if (column == 7) {
            sfLocation.column = 'h';
        }
        
        //Rows
        if (row == 7) {
            sfLocation.row = 1;
        } else if (row == 6) {
            sfLocation.row = 2;
        } else if (row == 5) {
            sfLocation.row = 3;
        } else if (row == 4) {
            sfLocation.row = 4;
        } else if (row == 3) {
            sfLocation.row = 5;
        } else if (row == 2) {
            sfLocation.row = 6;
        } else if (row == 1) {
            sfLocation.row = 7;
        } else if (row == 0) {
            sfLocation.row = 8;
        }
        
        return sfLocation;        
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
