/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibb.hinz.model;

/**
 *
 * @author Jan-Christian Hinz
 */


/**
 * The Cell class models each individual cell of the game board.
*/ 
public class Cell {
    // A lack of any modifier, sets package-private. Access from the same package only
    ChipState content;  // content of this cell of type ChipState.
                        // can take the value of ChipState.O, ChipState.EMPTY, ChipState.X
    int row, column;       

    
    
    /**
    * Explicitly implemented default-constructor
    */
    public Cell() {
        
    }

    
   
    /**
     * Explicitly implemented, parameterized constructor, 
     * initialize this cell with GameState.EMPTY, through method clearCell();
    */
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        clearCell();  //clear content
    }
    
  
    
    /**
     * Clear the cell content (set to EMPTY)
    */
    public void clearCell() {
        content = ChipState.EMPTY; //content, which is of type ChipState, gets set to EMPTY
    }
 
    
    
    /**
     * Draws the X, O or an empty space, in the 
     */
    public void drawCell() {
        switch (content) {
            case X:     System.out.print(" X "); break;
            case O:     System.out.print(" O "); break;
            case EMPTY: System.out.print("   "); break;
        }
    }
}
