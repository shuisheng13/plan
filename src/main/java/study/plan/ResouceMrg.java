package study.plan;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/***
 * 图片工具类
 */
public class ResouceMrg {

    public static BufferedImage trankL,
    trankR,trankU,trankD,bulletL,bulletR,
    bulletU,bulletD;
    static {
        try {
            trankL = ImageIO.read(ResouceMrg.class
            .getClassLoader().getResourceAsStream("tankL.gif"));
            trankR = ImageIO.read(ResouceMrg.class
                    .getClassLoader().getResourceAsStream("tankR.gif"));
            trankU = ImageIO.read(ResouceMrg.class
                    .getClassLoader().getResourceAsStream("tankU.gif"));
            trankD = ImageIO.read(ResouceMrg.class
                    .getClassLoader().getResourceAsStream("tankD.gif"));
            bulletL = ImageIO.read(ResouceMrg.class
                    .getClassLoader().getResourceAsStream("bulletL.gif"));

            bulletR = ImageIO.read(ResouceMrg.class
                    .getClassLoader().getResourceAsStream("bulletR.gif"));
            bulletU = ImageIO.read(ResouceMrg.class
                    .getClassLoader().getResourceAsStream("bulletU.gif"));
            bulletD = ImageIO.read(ResouceMrg.class
                    .getClassLoader().getResourceAsStream("bulletD.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
