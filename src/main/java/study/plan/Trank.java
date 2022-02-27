package study.plan;

import java.awt.*;
import java.util.ArrayList;

/***
 * 坦克的父类
 * 封装一些公共属性方法
 */
public class Trank {
    private int  x ;
    private int y;
    private final static  int speed =30;
    private Dir dir = Dir.UP; //默认向下方向
    private boolean moveing = false;
    private TrankFrame tf = null;

    public Trank(int x, int y, Dir dir,TrankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    public void move(){
        if(!moveing) return;  //静止状态不移动
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
    }

        public Dir getDir () {
            return dir;
        }

        public void setDir (Dir dir){
            this.dir = dir;
        }

    public boolean isMoveing() {
        return moveing;
    }

    public void setMoveing(boolean moveing) {
        this.moveing = moveing;
    }

    /***
     * 基础版开火 创建一颗方向形同的子弹 V1
     * 只有TrankFrame 能够画图
     * 坦克开火时想画出子弹 就必须持有TrankFarme的引用
     *
     *
     */
    public void fire() {
        tf.list.add(new Bullet(x,y,this.dir,this.tf));
    }
}