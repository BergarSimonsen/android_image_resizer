import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Writer {
    public final String LDPI_FOLDER_NAME = "ldpi";
    public final String MDPI_FOLDER_NAME = "mdpi";
    public final String HDPI_FOLDER_NAME = "hdpi";
    public final String XHDPI_FOLDER_NAME = "xhdpi";

    public static void write(BufferedImage image, String extension, String imageName) {
	try {
	    ImageIO.write(image, extension, new File(imageName));
	} catch (IOException e) {
	    System.out.println("Error writing image: " + e.getMessage());
	}
    }
}
