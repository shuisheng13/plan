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
    public int HEIGHT = ResouceMrg.trankL.getHeight();
    public int WIDTH = ResouceMrg.trankL.getWidth();

    private final static  int speed =30;
    private Dir dir = Dir.UP; //默认向下方向
    private boolean moveing = false;
    private TrankFrame tf = null;
    private boolean isLiving =true;

    public Trank(int x, int y, Dir dir,TrankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {

        if(!this.isLiving) this.tf.dTranks.remove(this);

        switch (dir){
            case LEFT:
                g.drawImage(ResouceMrg.trankL,x,y,null);
            case RIGHT:
                g.drawImage(ResouceMrg.trankR,x,y,null);
            case UP:
                g.drawImage(ResouceMrg.trankU,x,y,null);
            case DOWN:
                g.drawImage(ResouceMrg.trankD,x,y,null);
        }
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        int bx = x +this.HEIGHT/2+ Bullet.HIGHT/2;
        int by = y +this.WIDTH/2 +Bullet.WIDTH/2;
        tf.list.add(new Bullet(bx,by,this.dir,this.tf));
    }

    public void die() {
        this.isLiving = false;
    }
}