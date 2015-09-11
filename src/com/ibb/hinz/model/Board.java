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
 * The Board class, creates a board, on which the game takes place on
 */

public class Board {
    
    //Board consisting of 3x3 cells, finalized  
    private final int ROWS = 3; 
    private final int COLUMNS = 3;
 
    // A lack of any modifier, sets package-private. Access from the same package only
    Cell[][] cells;  //A board consists of ROWS x COLUMNS of Cell objects
    int currentRow, currentColumn;  // the current seed's row and column
 
    
    /**
     * Explicitly implemented default-constructor to initialize the game board
    */
    public Board() {
        cells = new Cell[ROWS][COLUMNS];        //Create array of type Cell[][], with 3x3 slots
        
        for (int row = 0; row < ROWS; ++row) {        //move through rows
            
            for (int col = 0; col < COLUMNS; ++col) { //move through colums
                
                cells[row][col] = new Cell(row, col); //Allocate element of the array
            }
        }
    }
    
    
    
    /**
     * Draws the Gameboard to the console
     */
    public void drawBoard() {   
        
        for (int row = 0; row < ROWS; ++row) {                  //move through rows
            
            for (int column = 0; column < COLUMNS; ++column) {  //move through colums
                
                cells[row][column].drawCell();                  // each cell gets drawn
                
                if (column < COLUMNS - 1){  //correct place to set the stringelement? (0,1,2)
                   
                    System.out.print("║");
                }
            }
            
            System.out.println();   //New line
            if (row < ROWS - 1) {   //correct place to set the stringelement? (0,1,2)
                
                System.out.println("═══════");
            }
        }
    }
 
    
    
    /**
     *  initialize contents of the game board
     */
    public void initiate() {
        
        for (int row = 0; row < ROWS; ++row) {        //move through rows
            
            for (int col = 0; col < COLUMNS; ++col) { //move through colums
                
                cells[row][col].clearCell();          // clear the cell content
            }
        }
    }
 
    
 
    /**
    * Main Tic Tac Toe logic.
    * Return true if the player with the current chip has won after placing at
    * currentRow, currentCol.
    */        
    public boolean hasWon(ChipState chip) {
        return (cells[currentRow][0].content == chip        //Are there 3 chips in a row?
                    && cells[currentRow][1].content == chip
                    && cells[currentRow][2].content == chip
                
                || cells[0][currentColumn].content == chip //Are there 3 chips in a column?
                    && cells[1][currentColumn].content == chip
                    && cells[2][currentColumn].content == chip
                
                || currentRow == currentColumn     //Are there 3 chips diagonal? (upper left to lower right)
                    && cells[0][0].content == chip
                    && cells[1][1].content == chip
                    && cells[2][2].content == chip
                
                || currentRow + currentColumn == 2  //Are there 3 chips diagonal (other direction)?
                    && cells[0][2].content == chip
                    && cells[1][1].content == chip
                    && cells[2][0].content == chip);
    }
 
    
    
    /**
     * Return true if all cells are filled with X or O. 
     * Since there was no win detected up to this point, it's a Draw
    */
    public boolean isDraw() {
        
        for (int row = 0; row < ROWS; ++row) {               //move through rows
            
            for (int col = 0; col < COLUMNS; ++col) {       //move through colums
                
                if (cells[row][col].content == ChipState.EMPTY) {
                    return false; // If an empty chip is found, it's not a draw. Continue game
                }
            }
        }
        return true; // no empty cell, it's a draw
   }

    
    
    //Getters for finalized attributes
    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }    
}