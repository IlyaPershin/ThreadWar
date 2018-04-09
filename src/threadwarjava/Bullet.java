/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwarjava;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Илья
 */
public class Bullet extends Thread {
    
    int x;
    int y;
    
    public Bullet (int _x, int _y){
        this.y = _y;
        this.x = _x;
    }
    
    @Override
    public void run() {
        if (false) return;//if (getat(x, y) == '*') return;
        if (!ThreadWarJava.bulletsem.tryAcquire()) return;
        
        while(y >= 0) {
            //if (ThreadWarJava.gw.isFree(x, y)) {
                ThreadWarJava.gw.addLabel(x, y, '*');
            //} else {
            //    ThreadWarJava.hit.incrementAndGet();
            //    ThreadWarJava.gw.removeLabel(x, y);
            //    break;
            //}
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
            ThreadWarJava.gw.removeLabel(x, y);
            y-=8;
        }
        ThreadWarJava.bulletsem.release();
    }
}
