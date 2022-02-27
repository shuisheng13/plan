package study.plan;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import study.plan.TrankFrame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Hello world!
 *
 */
public class Main
{
        public static void main( String[] args ) throws InterruptedException {

        //窗口类
        TrankFrame trankFrame = new TrankFrame();
        while (true){
            Thread.sleep(100);
            trankFrame.repaint();

        }
    }



}
