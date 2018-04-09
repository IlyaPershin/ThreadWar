/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadwarjava;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Мария
 */
public class ThreadWarJava {

static AtomicInteger hit=new AtomicInteger(0);
static AtomicInteger miss=new AtomicInteger(0);
static char badchar[] = {'-','\\','|','/'};
static Random rand=new Random();

static int x = 800/2;
static int y = 476;
static GameWindow gw;
static Thread mainThread;

static Semaphore bulletsem=new Semaphore(3,true);
static ReentrantLock screenLock = new ReentrantLock();
static ReentrantLock gameOver = new ReentrantLock();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        gw = new GameWindow("ThreadWar Попаданий:" + hit + " Промахов:" + miss);
        gw.addLabel(x, y, '|');
        BadGuys bg = new BadGuys();
        bg.start();
        
    }
        //InitializeWindow();
//        Thread me=currentThread();
//        mainThread=me;
//        score();
//        int y = 499;
//	int x = 400;
//        badguys();
//        writeat(x, y, '|'); // нарисовать пушку
//        int c,ct;
//        c = getakey(ct);   // получить символ
//        switch (c)
//            {
//		case KeyEvent.VK_SPACE:
////			static COORD xy;
////			xy.X = x;
////			xy.Y = y;
//			//_beginthread(bullet, 0, (void *)&xy);
//                        bullet(x,y);
//			Thread.sleep(100); // дать пуле время улететь на некоторое расстояние
//			break;
//		case KeyEvent.VK_LEFT:  // команда "влево!"
//			//SetEvent(startevt);    // поток badguys работает 
//			writeat(x, y, ' ');      // убрать с экрана пушку 
//			while (ct--)        // переместиться
//				if (x!=0) x--;
//			break;
//		case KeyEvent.VK_RIGHT: // команда "вправо!"; логика та же
//			//SetEvent(startevt);
//			writeat(x, y, ' ');
//			while (ct--)
//				if (x != info.dwSize.X - 1) x++;
//			break;
//		}
    

    static void score()
    {
        gw.setTitle("ThreadWar Попаданий:" + hit + " Промахов:" + miss);
	if (miss.intValue() >= 30)
	{
            gw.setTitle("You are loozer");
            //EnterCriticalSection(&gameover);
            mainThread.interrupt();//SuspendThread(mainthread);
            GameOver();
            //mainThread.suspend();
            //MessageBox(NULL, L"Игра окончена!", L"Thread War", MB_OK | MB_SETFOREGROUND);
            //exit(0); // не выходит из критической секции
	}
    }    

    private static void GameOver(){
        gameOver.lock();
        GameOverWindow gow = new GameOverWindow("");
    }
    
    void badguys() throws InterruptedException
    {
        wait(15000); //waitForSingleObject
	// создаем случайного врага
	while (true)
	{
            if (rand.nextInt(100)<(hit.intValue() + miss.intValue()) / 25 + 20)
            {
                BadGuy bg = new BadGuy(rand.nextInt(180) + 20);
                bg.start();
            }
		Thread.sleep(1000); // каждую секунду
	}
    }
    
    static void Left(){
        if (x > 8){
            gw.removeLabel(x, y);
            x-=8;
            gw.addLabel(x, y, '|');
        }
    }
    
    static void Right(){
        if (x < 800 - 16){
            gw.removeLabel(x, y);
            x+=8;
            gw.addLabel(x, y, '|');
        }
    }
    
    static void Fire(){
        Bullet b = new Bullet(x, y - 8);
        b.start();
    }

    //void bullet(int x,int y) throws InterruptedException
    //{
    //        if (getat(x, y) == '*') return; // здесь уже есть пуля	
    //        
    //        if (!bulletsem.tryAcquire()) return;// если семафор равен 0, выстрела не происходит
    //									   
    //
    //	while (y!=0)
    //	{
    //		writeat(x, y, '*'); // отобразить пулю
    //		Thread.sleep(100);
    //		writeat(x, y, ' ');    // стереть пулю
    //                y--;
    //	}
    //	// выстрел сделан.- добавить 1 к семафору
    //        bulletsem.release(1);
    //}
    
    //int getat(int x, int y)
    //{
    //    	char c=' ';
    //
    //        //DWORD res;
    //	//COORD org = { x,y };
    //	// Блокировать доступ к консоли до тех пор, пока процедура не будет выполнена
    //	//WaitForSingleObject(screenlock, INFINITE);
    //	//ReadConsoleOutputCharacter(conout, &c, 1, org, &res);
    //	//ReleaseMutex(screenlock); // unlock
    //        
    //	return c;
    //}

    //void writeat(int x, int y, char c)
    //{
    //        // Блокировать вывод на экран при помощи мьютекса
    ////	WaitForSingleObject(screenlock, INFINITE);
    ////	COORD pos = { x,y };
    ////	DWORD res;
    ////	WriteConsoleOutputCharacter(conout, &c, 1, pos, &res);
    ////	ReleaseMutex(screenlock);
    //}
}