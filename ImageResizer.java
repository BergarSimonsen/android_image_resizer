import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class ImageResizer {
    private String filename;
    private String extension;
    private int imageType;
    private BufferedImage image;

    private boolean launcher;
    private boolean actionBar;
    private boolean contextual;
    private boolean notification;
    private boolean custom;

    private ArrayList<String> params;
    private ArrayList<CustomImage> returnImages;

    private int customMdpi;
    private int customHdpi;
    private int customXhdpi;
    private int customXxhdpi;
    private int customXxxhdpi;

    public ImageResizer() {

    }

    public void initialize(String imageName, ArrayList<String> params, String[] sizes) {
	this.returnImages = new ArrayList<CustomImage>();
	this.filename = imageName;
	this.image = Reader.readImage(filename);
	this.imageType = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
	this.extension = getExtension(filename);
	this.params = params;
	parseParams(params);
	setCustomSizes(sizes);
    }

    private void setCustomSizes(String[] s) {
	if(custom) {
	    this.customMdpi = Integer.parseInt(s[0].trim());
	    this.customHdpi = Integer.parseInt(s[1].trim());
	    this.customXhdpi = Integer.parseInt(s[2].trim());
	    this.customXxhdpi = Integer.parseInt(s[3].trim());
	    this.customXxxhdpi = Integer.parseInt(s[4].trim());

	    System.out.println("-" + customMdpi);
	    System.out.println("-" + customHdpi);
	    System.out.println("-" + customXhdpi);
	    System.out.println("-" + customXxhdpi);
	    System.out.println("-" + customXxxhdpi);
	}
    }

    public static void main(String[] args) {
	ImageResizer ir = new ImageResizer();

	scanArgs(args, ir);
	ir.execute();
    }

    private static void scanArgs(String[] args, ImageResizer ir) {
	String fname = null;
	String[] prms = null;
	String[] sizes = null;
	ArrayList<String> params = new ArrayList<String>();

	if(args.length == 0) {
	    exitError();
	} else if(args.length == 1) {
	    if(args[0].equals("--help")) 
		printHelp();
	    else {
		prms = new String[0];
		fname = args[0];
	    }
	} else {
	    fname = args[args.length - 1];
	    for(int i = 0; i < args.length - 1; i++) {
		if(args[i].startsWith("-") && !args[i].equals("--help")) {
		    if(args[i].length() > 2) {
			prms = args[i].split("");
		    } else {
			params.add(args[i].substring(1));
		    }
		    if(prms != null) {
			for(int j = 0; j < prms.length; j++)
			    params.add(prms[j]);
		    }
		    
		} else if(args[i].startsWith("<")) {
		    String x = args[i].substring(1, args[i].length() - 1);;
		    sizes = x.split(",");
		    for(String sx : sizes)
			System.out.println(sx);
		}
	    }
	}
	ir.initialize(fname, params, sizes);
    }

    private void execute() {
	Category c;
	if(launcher) {
	    c = new LauncherCategory();
	    handleResizeAndWrite(image, c);
	}
	if(actionBar) {
	    c = new ActionBarCategory();
	    handleResizeAndWrite(image, c);
	}
	if(contextual) {
	    c = new ContextualCategory();
	    handleResizeAndWrite(image, c);
	}
	if(notification) {
	    c = new NotificationCategory();
	    handleResizeAndWrite(image, c);
	}
	if(custom) {
	    CustomCategory cg = new CustomCategory();
	    cg.init(customMdpi, customHdpi, customXhdpi, customXxhdpi, customXxxhdpi);
	    handleResizeAndWrite(image, cg);
	}
    }

    private void handleResizeAndWrite(BufferedImage i, Category c) {
	System.out.println("Resizing " + c.getType().toString() + " ...");
	returnImages.addAll(Resizer.resize(i, c, imageType));
	System.out.println("Writing " + c.getType().toString() + " ...");
	Writer.write(c, returnImages, extension, filename);
	returnImages.clear();
	System.out.println("Done with " + c.getType().toString());
    }

    private static void printHelp() {
	String s = "Usage: <prog> [params <size>] [image name]. Use <prog> --help for instructions.\n";
	s += "Arguments:\n";
	s += "-l - generate images for launcher icons.\n";
	s += "-a - generate images for action bar icons.\n";
	s += "-c - generate images for contextual / small icons.\n";
	s += "-n - generate images for notification icons.\n";
	s += "-C - <int, int, int, int, int> generate images for custom icon. <int, int, int, int, int> are the sizes for mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi respectively. All sizes are required.\n";
	System.out.println(s);
	System.exit(0);
    }

    private static void exitError() {
	System.out.println("Usage: <prog> [params <size>] [image name]. Use <prog> --help for instructions.");
	System.exit(0);
    }

    private String getExtension(String filename) {
	String file = "";
	if(filename.contains("/")) file = filename.substring(filename.lastIndexOf("/"));
	else file = filename;
	return file.substring(file.indexOf(".") + 1);
    }

    private void parseParams(ArrayList<String> p) {
	if(p.size() == 0) {
	    launcher = true;
	    actionBar = true;
	    contextual = true;
	    notification = true;
	    custom = false;
	} else {
	    for(int i = 0; i < p.size(); i++) {
		System.out.println(String.format("arg[%d] == %s", i, p.get(i)));
		switch(p.get(i)) {
		case "l":
		    launcher = true;
		    break;
		case "a":
		    actionBar = true;
		    break;
		case "c":
		    contextual = true;
		    break;
		case "n":
		    notification = true;
		    break;
		case "C":
		    custom = true;
		    break;
		}
	    }
	}
    }
}
