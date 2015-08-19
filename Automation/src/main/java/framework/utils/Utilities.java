package framework.utils;

import javax.swing.plaf.TableHeaderUI;

/**
 * Created by zao on 8/19/15.
 */
public class Utilities {
    public static void waitTime(long timeToWait){
        try{
            Thread.sleep(1000*timeToWait);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
