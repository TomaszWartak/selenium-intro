package pl.dev4lazy.driver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

public class DriverEventListener implements WebDriverListener {

    private static Logger logger = LogManager.getLogger( DriverEventListener.class );

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        logger.info( "beforeClick of: "+element.getTagName() );
    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
        //   tutaj bez odwołania do elementu bo już może nie istnieć...
        logger.info( "afterClick..." );
    }

    @Override
    public void beforeIsDisplayed(WebElement element) {
        WebDriverListener.super.beforeIsDisplayed(element);
        logger.info( "beforeIsDisplayed of: "+element.getTagName() );
    }

    @Override
    public void afterIsDisplayed(WebElement element, boolean result) {
        WebDriverListener.super.afterIsDisplayed(element, result);
        logger.info( "afterIsDisplayed of: "+element.getTagName() );
    }

    @Override
    public void beforeClear(WebElement element) {
        WebDriverListener.super.beforeClear(element);
        logger.info( "beforeClear of: "+element.getTagName() );
    }

    @Override
    public void afterClear(WebElement element) {
        WebDriverListener.super.afterClear(element);
        logger.info( "afterClear of: "+element.getTagName() );
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
        if (keysToSend == null) {
            logger.info("beforeSendKeys (clear) of: " + element.getTagName() );
        } else {
            logger.info("beforeSendKeys of: " + element.getTagName()+", " +Arrays.toString(keysToSend));
        }
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.afterSendKeys(element, keysToSend);
        if (keysToSend == null) {
            logger.info("afterSendKeys (cleared) of: " + element.getTagName() );
        } else {
            logger.info("afterSendKeys of: " + Arrays.toString(keysToSend) );
        }
    }

}
