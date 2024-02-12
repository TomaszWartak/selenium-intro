package pl.dev4lazy.utils;

public class SystemInfo {

    public final static String MAC_OS_ID = "MAC";
    public final static String WIN_OS_ID = "WIN";
    public final static String OTHER_OS_ID = "OTHER";

    public static String getOSId() {
        String osName = System.getProperty("os.name");
        if (osName.toUpperCase().contains( "MAC" )) {
            return MAC_OS_ID;
        } else if (osName.toUpperCase().contains( "WINDOWS" )) {
            return WIN_OS_ID;
        } else return OTHER_OS_ID;
    }

}
