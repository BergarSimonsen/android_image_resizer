import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.util.*;

public class Resizer {

    private static final int IMAGES = 5;

    public static ArrayList<CustomImage> resize(BufferedImage image, Category category, int type) {
	ArrayList<CustomImage> retval = new ArrayList<CustomImage>();
	BufferedImage newImg;
	Graphics2D g;
	
	for(int i = 0; i < IMAGES; i++) {
	    int s = -1;
	    String f = "";
	    if(i == 0) {
		s = category.getMdpi(); 
		f = Config.MDPI_FOLDER;
	    } else if(i == 1) {
		s = category.getHdpi(); 
		f = Config.HDPI_FOLDER;
	    } else if(i == 2) {
		s = category.getXhdpi(); 
		f = Config.XHDPI_FOLDER;
	    } else if(i == 3) {
		s = category.getXxhdpi(); 
		f = Config.XXHDPI_FOLDER;
	    } else if(i == 4) {
		s = category.getXxxhdpi(); 
		f = Config.XXXHDPI_FOLDER;
	    }
	    
	    newImg = new BufferedImage(s, s, type);
	    g = newImg.createGraphics();
	    g.drawImage(image, 0, 0, s, s, null);
	    g.dispose();
	    retval.add(new CustomImage(newImg, category.getFolder() + f));
	    System.out.println(String.format("Finished resizing %s", category.getFolder()+f));
	}
	
	return retval;
    }
}
