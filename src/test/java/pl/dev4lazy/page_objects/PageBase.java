package pl.dev4lazy.page_objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.dev4lazy.driver_manager.DriverUtils;

public class PageBase {

    protected String pageUrl = "";

    protected Logger logger = LogManager.getRootLogger();

    public void navigateTo() {
        DriverUtils.navigateToPage( pageUrl );
    }
}
