/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibb.hinzjc.model;

import java.util.Scanner;

/**
 *
 * @author jan
 */
public class GameMenu implements MenuIf{

    public GameMenu() {
        drawWelcomeMessage();
        drawMenuItems();
    }

        
    @Override
    public void drawWelcomeMessage() {
        System.out.printf("Willkommen zu Jan-Christian's Tic Tac Toe!%n------------------------------------------%n%n");
    }

    @Override
    public void drawMenuItems() {
        
        System.out.printf("%S%n%n[N]eues spiel%n%n[E]nde%n%n", MenuIf.MENU_HEADLINE);
        
        
        
        while(true){
            
            Scanner keyboardInput = new Scanner(System.in);
            char c = keyboardInput.next().trim().toLowerCase().charAt(0);
            
            if(c=='n'){
                
                Game myGame = new Game(); //Constructor of Game-class does the job
            }
            
            if(c=='e'){
                
                System.out.printf("%n%nUnd tschüss!%n%n");
                break;
            }
            
            System.out.printf("%S%n%n[N]eues spiel%n%n[E]nde%n%n", MenuIf.MENU_HEADLINE);
        }
    }
}