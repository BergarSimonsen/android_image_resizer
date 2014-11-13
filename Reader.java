import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Reader {
    public static BufferedImage readImage(String imageName) {
	try {
	    return ImageIO.read(new File(imageName));
	} catch (IOException e) {
	    System.out.println("Error reading image: " + e.getMessage());
	}
	return null;
    }
}
