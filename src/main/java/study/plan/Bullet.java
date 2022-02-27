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
    private static boolean isLiving = true;
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
        if(!isLiving){
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
//            if(this.x<0||this.y<0||this.x>this.tf.GAME_WEIGHT||this.y>this.tf.HEIGHT){
//             this.isLiving=false;
//        }
    }


    /***
     * 遗留BUG
     * 第一批子弹消失后  后续的子弹打不出去
     *
     *
     */
}
