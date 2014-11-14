public class CustomCategory extends Category {
    public CustomCategory() {
	super(Config.LAUNCHER_MDPI,
	      Config.LAUNCHER_HDPI,
	      Config.LAUNCHER_XHDPI,
	      Config.LAUNCHER_XXHDPI,
	      Config.LAUNCHER_XXXHDPI,
	      Config.Type.CUSTOM,
	      Config.CUSTOM_FOLDER);
    }

    public void init(int mdpi, int hdpi, int xhdpi, int xxhdpi, int xxxhdpi) {
	super.setMdpi(mdpi);
	super.setHdpi(hdpi);
	super.setXhdpi(xhdpi);
	super.setXxhdpi(xxhdpi);
	super.setXxxhdpi(xxxhdpi);
    }
}
