/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibb.hinz.model;

import java.util.Scanner;

/**
 *
 * @author Jan-Christian Hinz
 */



public class Game {
    private Board board;           
    private LogicState currentState; //current state of the game 
    private ChipState currentPlayer; //current player
    
    //private static Scanner input = new Scanner(System.in); 

    
   /**
    * Explicitly implemented default-constructor
    */
    public Game() {
        board = new Board();  //Set up the game-board

        initGame(); //Of class Board. Initializes the game-board and current gamestatus
      
        //Play the game once. Players X and O move alternately.
        do {
            
            playerMove(currentPlayer);   // update the content, currentRow and currentCol
            board.drawBoard();           // Draw the board to the console
            updateGame(currentPlayer);   // update currentState
            
            //Print message if game-over
            if (currentState == LogicState.X_WINS) {
            
                    System.out.printf("%n%nX hat gewonnen!%n%n");
            } else if (currentState == LogicState.O_WINS) {
            
                    System.out.printf("%n%nO hat gewonnen!%n%n");
            } else if (currentState == LogicState.DRAW) {
            
                    System.out.printf("%n%nEs steht unentschieden =(%n%n");
            }
            
            // Switch the player for the next move. If currentPlayer == Chipstate.X set it to Chiptstate.O
            currentPlayer = (currentPlayer == ChipState.X) ? ChipState.O : ChipState.X;
      
        } while (currentState == LogicState.PLAYING);  //Repeat until decision (win, draw) 
    }
   
   
    /**
     * Initialize the game-board contents and the current states
    */
    public void initGame() {
        board.initiate();  // clear the board contents
        currentPlayer = ChipState.O;       //O always plays first
        currentState = LogicState.PLAYING; //Game is in progress
    }
 
    
    /**
     * The player with his chip makes one move, with input validation.
     * Update Cell's content, Board's currentRow and currentCol.
    */
    public void playerMove(ChipState chip) {
        boolean validInput = false;  //Set false before actual validation
        do {
            
            
            if (chip == ChipState.O) {//If Player O moves, print corresponding text, else X
                
                System.out.print("O am Zug: Erst Zeile, dann Spalte eingeben: ");
            } else {
                
                System.out.print("X am Zug: Erst Zeile, dann Spalte eingeben: ");
            }
           
            Scanner input = new Scanner(System.in); 
            int row = input.nextInt() - 1;  //Input for the row of the current move
            int column = input.nextInt() - 1; // same for the column, -1 for correct index
            
            //If tried to place the chip in right dimensions AND the specific cell is empty, proceed 
            if (row >= 0 && row < board.getROWS() && column >= 0 && column < board.getCOLUMNS()
                && board.cells[row][column].content == ChipState.EMPTY) {
                
                board.cells[row][column].content = chip; //If true, set the cell to ChipState.X or .O 
                board.currentRow = row;         //Set current position
                board.currentColumn = column;
                
                validInput = true;  //In this iteration, the input was valid
            } else {
                System.out.println("Ungültige Eingabe"); // =( u failed.. miserably.
            }
            
        } while (!validInput);   //Repeat unless input is valid
   }
 
    
    /*
    *
    * Update the currentState after the player with the chip took his move
    */
    public void updateGame(ChipState chip) {            //Damn it Ponch, chip, not CHiPs
        
        if (board.hasWon(chip)) {  //Check if a win was detected    
            //If chip==ChipState.X, set currentState to LogicState.X_WINS else O_WINS
            currentState = (chip == ChipState.X) ? LogicState.X_WINS : LogicState.O_WINS; 
        
        } else if (board.isDraw()) {  //Check for draw
            //If so, set the condition of the game to LogicState.DRAW
            currentState = LogicState.DRAW;
        }
        // Otherwise, no change to current state (remains GameState.PLAYING).
    }
 
}
