package study.plan;

import java.awt.*;

/***
 * 子弹类
 */
public class Bullet {
    private int x,y; //位置
    private Dir dir; //方向
    public static int HIGHT  = ResouceMrg.bulletL.getHeight(); //高 固定 不需要传
    public static int WIDTH=ResouceMrg.bulletL.getWidth(); //宽 固定 不需要传
    private static final int  speed = 30; //速度
    private  boolean isLiving = true;
    TrankFrame tf = null;
    public Bullet(int x, int y, Dir dir,TrankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    //画子弹的方法
    public void paint(Graphics g) {
        System.out.println("子弹isLivine "+isLiving);
        if(!this.isLiving){
            tf.list.remove(this);
        }
            Color c = g.getColor();
            g.setColor(Color.red);
            g.fillOval(x,y,WIDTH,HIGHT);
            g.setColor(c);
            move();
    }

    public void move() {
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
            default:
                 break;
                }
            if(this.x<0||this.y<0||this.x>this.tf.GAME_WEIGHT||this.y>this.tf.GAME_HEIGHT){
             this.isLiving=false;
        }
    }

    public void collideWith(Trank trank) {
        Rectangle r1 = new Rectangle(this.x,this.y,Bullet.WIDTH,Bullet.HIGHT);
        Rectangle r2 = new Rectangle(trank.getX(),trank.getY(),trank.WIDTH,trank.HEIGHT);
        if(r1.intersects(r2)){
            /***
             * 相交
             */
            trank.die();
            this.die();
        }

    }

    private void die() {
        this.isLiving = false;
    }
    /***
     * 遗留BUG
     * 第一批子弹消失后  后续的子弹打不出去
     *
     *
     */
}
