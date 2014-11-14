public class Category {
    private final String baseFolder = Config.BASE_FOLDER;
    
    private int mdpi;
    private int hdpi;
    private int xhdpi;
    private int xxhdpi;
    private int xxxhdpi;
    private Config.Type type;
    private String folder;

    public Category(int mdpi, int hdpi, int xhdpi, int xxhdpi, int xxxhdpi, Config.Type type, String folder) {
	this.mdpi = mdpi;
	this.hdpi = hdpi;
	this.xhdpi = xhdpi;
	this.xxhdpi = xxhdpi;
	this.xxxhdpi = xxhdpi;
	this.type = type;
	this.folder = baseFolder + folder;
    }

    protected void setMdpi(int s) {
	mdpi = s;
    }

    protected int getMdpi() {
	return mdpi;
    }

    protected void setHdpi(int s) {
	hdpi = s;
    }

    protected int getHdpi() {
	return hdpi;
    }

    protected void setXhdpi(int s) {
	xhdpi = s;
    }

    protected int getXhdpi() {
	return xhdpi;
    }

    protected void setXxhdpi(int s) {
	xxhdpi = s;
    }

    protected int getXxhdpi() {
	return xxhdpi;
    }

    protected void setXxxhdpi(int s) {
	xxxhdpi = s;
    }

    protected int getXxxhdpi() {
	return xxxhdpi;
    }

    protected void setType(Config.Type t) {
	type = t;
    }

    protected Config.Type getType() {
	return type;
    }

    protected void setFolder(String f) {
	folder = baseFolder + f;
    }

    protected String getFolder() {
	return folder;
    }
}
