import java.awt.image.BufferedImage;
public class CustomImage {
    private BufferedImage image;
    private String folder;

    public CustomImage(BufferedImage image, String folder) {
	this.image = image;
	this.folder = folder;
    }

    public BufferedImage getImage() {
	return image;
    }

    public String getFolder() {
	return folder;
    }
}
