public class Config {

    /************************** ICON SIZES ***************************/
    // TODO: Edit mdpi to support inset
    // Launcher icons
    public static final int LAUNCHER_MDPI = 48;
    public static final int LAUNCHER_HDPI = 72;
    public static final int LAUNCHER_XHDPI = 96;
    public static final int LAUNCHER_XXHDPI = 144;
    public static final int LAUNCHER_XXXHDPI = 192;

    // Action bar icons
    public static final int ACTION_BAR_MDPI = 32;
    public static final int ACTION_BAR_HDPI = 48;
    public static final int ACTION_BAR_XHDPI = 64;
    public static final int ACTION_BAR_XXHDPI = 96;
    public static final int ACTION_BAR_XXXHDPI = 128;

    // Small / contextual icons
    public static final int CONTEXTUAL_MDPI = 16;
    public static final int CONTEXTUAL_HDPI = 24;
    public static final int CONTEXTUAL_XHDPI = 32;
    public static final int CONTEXTUAL_XXHDPI = 48;
    public static final int CONTEXTUAL_XXXHDPI = 64;

    // Notification icons
    public static final int NOTIFICATION_MDPI = 24;
    public static final int NOTIFICATION_HDPI = 36;
    public static final int NOTIFICATION_XHDPI = 48;
    public static final int NOTIFICATION_XXHDPI = 72;
    public static final int NOTIFICATION_XXXHDPI = 96;

    /************************** FOLDER AND FILE NAMES ***************************/
    public static final String BASE_FOLDER = "result/";
    public static final String LAUNCHER_FOLDER = "launcher/";
    public static final String ACTION_BAR_FOLDER = "action_bar/";
    public static final String CONTEXTUAL_FOLDER = "contextual/";
    public static final String NOTIFICATION_FOLDER = "notification/";
    public static final String CUSTOM_FOLDER = "custom/";

    public static final String MDPI_FOLDER = "mdpi/";
    public static final String HDPI_FOLDER = "hdpi/";
    public static final String XHDPI_FOLDER = "xhdpi/";
    public static final String XXHDPI_FOLDER = "xxhdpi/";
    public static final String XXXHDPI_FOLDER = "xxxhdpi/";

    public enum Type { LAUNCHER, ACTION_BAR, CONTEXTUAL, NOTIFICATION, CUSTOM }

}
