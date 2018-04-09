/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwarjava;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Илья
 */
public class MyKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getExtendedKeyCode()){
            case KeyEvent.VK_RIGHT: ThreadWarJava.Right();
                break;
            case KeyEvent.VK_LEFT: ThreadWarJava.Left();
                break;
            case KeyEvent.VK_SPACE: ThreadWarJava.Fire();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
    
}
