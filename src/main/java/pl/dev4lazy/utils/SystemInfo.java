package pl.dev4lazy.utils;

public class SystemInfo {

    public static final String MAC_OS_ID = "MAC";
    public static final String WIN_OS_ID = "WIN";
    public static final String OTHER_OS_ID = "OTHER";

    private SystemInfo() {
        throw new IllegalStateException("Utility class");
    }

    public static String getOSId() {
        String osName = System.getProperty("os.name");
        if (osName.toUpperCase().contains( "MAC" )) {
            return MAC_OS_ID;
        } else if (osName.toUpperCase().contains( "WINDOWS" )) {
            return WIN_OS_ID;
        } else return OTHER_OS_ID;
    }

}
