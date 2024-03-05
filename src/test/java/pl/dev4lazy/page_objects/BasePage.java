package pl.dev4lazy.page_objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.driver_manager.DriverUtils;

public abstract class BasePage {

    protected String pageUrl = "";

    protected Logger logger = LogManager.getLogger( this.getClass() );

    public BasePage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void navigateTo() {
        DriverUtils.navigateToPage( pageUrl );
    }
/* todo usuń

    public void logInfoWithEmptyLineBefore( String logText ) {
        logger.info("");
        logger.info( logText );
    }
*/

}
