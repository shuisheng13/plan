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

            for (int i = 0; i < 10; i++) {
                trankFrame.dTranks.add(new Trank(i*30,i*50,Dir.UP,trankFrame));
            }
        while (true){
            Thread.sleep(100);
            trankFrame.repaint();

        }
    }



}
