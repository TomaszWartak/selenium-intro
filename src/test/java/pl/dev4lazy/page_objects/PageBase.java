package pl.dev4lazy.page_objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.dev4lazy.driver_manager.DriverUtils;

public class PageBase {

    protected String pageUrl = "";

//  todo      protected Logger logger = LogManager.getRootLogger();
    protected Logger logger = LogManager.getLogger( this.getClass() );

    public void navigateTo() {
        DriverUtils.navigateToPage( pageUrl );
    }
}
