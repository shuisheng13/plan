package study.plan;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TrankFrame  extends Frame {
    final static  int GAME_WEIGHT = 800;
    final static  int GAME_HEIGHT= 600;
    Trank myTank = new Trank(200,200,Dir.UP,this);
    List<Trank> dTranks = new ArrayList<>();
    List<Bullet> list = new ArrayList<>();
    public TrankFrame(){
        setSize(GAME_WEIGHT,GAME_HEIGHT);
        setResizable(false); //控制其不能拖动大小
        setTitle("trank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WEIGHT, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WEIGHT, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }



    @Override
    public void paint(Graphics g){
        /***
         * 把画坦克的事情交给坦克自己去实现
         */
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量 "+
                list.size(),20,60);
        g.drawString("敌方坦克的数量 "+
                dTranks.size(),10,100);
        g.setColor(c);


        myTank.paint(g);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).paint(g);
        }
        for (int i = 0; i < dTranks.size(); i++) {
            dTranks.get(i).paint(g);
        }

        /***
         * 碰撞检测 用于打死敌方坦克
         */
        for (int i = 0; i < list.size(); i++) {
            Bullet b = list.get(i);
            for (int j = 0; j <dTranks.size()  ; j++) {
                b.collideWith(dTranks.get(j));
            }
        }

//        有内存泄漏问题
//        for(Bullet b:list){
//            b.paint(g);
//        }

    }

    /***
     * 创建匿名内部类 用于监听键盘事件
     * 一个类只被他的外部类使用的情况 创建匿名
     * 内部类
     */

    class MyKeyListener extends KeyAdapter{
        //四个方向键
        boolean BL = false;
        boolean BR = false;
        boolean BU = false;
        boolean BD = false;
        @Override
        //键盘按下事件
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    BL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR=true;
                    break;

                case KeyEvent.VK_UP:
                    BU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD=true;
                    break;
                default:
                    break;
            }
            setMainDir();
        }
        //键盘抬起事件
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    BL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR=false;
                    break;
                case KeyEvent.VK_UP:
                    BU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD=false;
                    break;
                /***
                 * 开火 监听CTRL抬起事件
                 * 这里开火放在坦克类中是为类以后应对不同开火发射子弹策略
                 */
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;

                default:
                    break;
            }
            setMainDir();
        }

        private void setMainDir() {
            if(!BL&&!BR&&!BU&&!BD) myTank.setMoveing(false);
            else{
                if(BL) myTank.setDir(Dir.LEFT);
                if(BR) myTank.setDir(Dir.RIGHT);
                if(BU) myTank.setDir(Dir.UP);
                if(BD) myTank.setDir(Dir.DOWN);
                myTank.setMoveing(true);
            }
        }
    }
}
