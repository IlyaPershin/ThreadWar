/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwarjava;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Илья
 */
public class GameOverWindow extends Frame {
    
    public GameOverWindow(String title) { 
    super(title); 
    
    this.setTitle("The War Of Threads");
    this.setSize(300,200);
    Label text = new Label("Game over!");
    text.setBounds(150,50,100,100);
    this.add(text);
    this.show();
    this.setVisible(true);
    
//    WindowAdapter wa = new WindowAdapter(){
//        public void windowClosing(WindowEvent we){
//            System.exit(0);
//        }
//     }; 
//    this.addWindowListener(wa);  
    }
}
