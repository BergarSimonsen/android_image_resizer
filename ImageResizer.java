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
	this.extension = getExtension(filename);
    }

    public static void main(String args[]) {
	if(args.length == 0) {
	    System.out.println("Usage: <prog> [params] [image name]");
	    System.exit(0);
	} else {
	    
	}
    }

    private String getExtension(String filename) {
	String file = "";
	if(filename.contains("/")) file = filename.substring(filename.lastIndexOf("/"));
	else file = filename;
	return file.substring(file.indexOf("."));
    }
}
