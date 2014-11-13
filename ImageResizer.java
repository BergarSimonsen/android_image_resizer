import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResizer {
    private String filename;
    private String extension;
    private int imageType;
    private BufferedImage image;

    // TODO: Change to take parameters
    public ImageResizer(String imageName) {
	this.filename = imageName;
	this.image = Reader.readImage(filename);
	this.imageType = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
	// Get extension



    }
}
