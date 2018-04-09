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
public class BadGuys extends Thread {
    
    public BadGuys(){ }
    
    @Override
    public void run(){
//        try {
//            wait(15000); //waitForSingleObject
//        } catch (InterruptedException ex) {
//            Logger.getLogger(BudGuys.class.getName()).log(Level.SEVERE, null, ex);
//        }
	// создаем случайного врага
	while (true)
	{
            if (ThreadWarJava.rand.nextInt(100)<(ThreadWarJava.hit.intValue() + ThreadWarJava.miss.intValue()) / 25 + 20)
            {
                BadGuy bg = new BadGuy(ThreadWarJava.rand.nextInt(20));
                bg.start();
            }
            try {
                Thread.sleep(1000); // каждую секунду
            } catch (InterruptedException ex) {
                Logger.getLogger(BadGuys.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
    }
}