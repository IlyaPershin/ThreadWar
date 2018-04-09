/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwarjava;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author LocalUser
 */
public class GameWindow extends Frame {
    
    public GameWindow(String title) { 
    super(title); 
    
    this.setSize(800, 500);
    this.setName("GameFrame");
    setLayout(null);
    setVisible(true);
    addKeyListener(new MyKeyListener());
    
    WindowAdapter wa = new WindowAdapter(){
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
     }; 
    this.addWindowListener(wa);  
    }
    
    void addLabel(int x, int y, char c){
        Label label = new Label(String.valueOf(c));
        label.setName(String.valueOf(c));
        label.setBounds(x, y, 8, 8);
        ThreadWarJava.screenLock.lock();
        this.add(label);
        ThreadWarJava.screenLock.unlock();
    }

    void removeLabel(int x, int y){
        Component component = getComponentAt(x,y);
        ThreadWarJava.screenLock.lock();
        remove(component);
        ThreadWarJava.screenLock.unlock();
    }

    boolean isFree(int x, int y){
        return getComponentAt(x,y).getName().equals("GameFrame");
    }
}
