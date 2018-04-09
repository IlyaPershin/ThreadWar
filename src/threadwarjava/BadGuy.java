/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwarjava;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Илья
 */
class BadGuy extends Thread {
    
    int y;
    
    public BadGuy(int _y){
        this.y = _y;
    }
    
    @Override
    public void run(){
        int dir, x, goal;
        if (y%2==0){
            x = 8;
            dir = 8;
            goal = 800 - 8;
        } else {
            x = 800 - 16;
            dir = -8;
            goal = 0;
        }
        y = y * 8 + 24;
        
        while (x!= goal) {
            boolean hitme = false;
            
            for (int i = 0; i<12; i++){
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BadGuy.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (!ThreadWarJava.gw.isFree(x, y)){
                    hitme = true;
                    break;
                }
            }
            
            ThreadWarJava.gw.removeLabel(x - dir, y);
            if (hitme){
                ThreadWarJava.hit.incrementAndGet();
                ThreadWarJava.score();
                break;
            } else {
                ThreadWarJava.gw.addLabel(x, y, ThreadWarJava.badchar[(x/10)%4]);
            }
            x += dir;
        }
        if (x == goal){
            ThreadWarJava.gw.removeLabel(x - dir, y);
            ThreadWarJava.miss.incrementAndGet();
            ThreadWarJava.score();
        }
    }
}
