import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;

public class Resizer {

    public static BufferedImage resize(BufferedImage image, int size) {
	try {
	    int s = getSize(size);
	    BufferedImage newImg = new BufferedImage(HDPI_SIZE, HDPI_SIZE, type);
	    Graphics2D g = newImg.createGraphics();
	    g.drawImage(image, 0, 0, s, s, null);
	    g.dispose();
	    return newImg;
	} catch (IOException e) {
	    System.out.println("Error resizing image: " + e.getMessage());
	}
    }

    // FIX
    private static getSize(int s) {
	switch(s) {
	case ImageSize.LDPI:
	    return 0;
	}
    }
}
