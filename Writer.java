import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Writer {
    public static void write(Category category, ArrayList<CustomImage> images, String extension, String imageName) {
	try {
	    for(int i = 0; i < images.size(); i++) {
		System.out.println("Writing image " + i);
		File folder = new File(images.get(i).getFolder());
		if(!folder.exists()) {
		    try {
			folder.mkdirs();
		    } catch (SecurityException se) {
			System.out.println("Error creating directories: " + se.getMessage());
		    }
		}
		String filename = images.get(i).getFolder() + imageName;
		System.out.println("image: " + filename + " " + extension + " writing ...");
		ImageIO.write(images.get(i).getImage(), extension, new File(filename));
	    }
	} catch (IOException e) {
	    System.out.println("Error writing image: " + e.getMessage());
	}
    }
}
