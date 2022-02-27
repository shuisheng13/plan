package study.plan;


import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void readImage() throws IOException {

        BufferedImage bf = ImageIO.read(AppTest.class.getClassLoader()
                .getResourceAsStream("/images/0.gif"));

        assertNotNull(bf);
    }
}
