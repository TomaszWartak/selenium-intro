package pl.dev4lazy.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import pl.dev4lazy.driver_manager.DriverEventListener;

public class WebDriverEventListenerRegistrar {

    private WebDriverEventListenerRegistrar() {
        throw new IllegalStateException("Utility class");
    }
    public synchronized static WebDriver registerWebDriverEventListener(WebDriver driver) {

        DriverEventListener driverEventListener = new DriverEventListener();

        // Utworzenie obiektu EventFiringDecorator, który to w konstruktorze przymuje stworzoną przez nas klasę DriverEventListener
        EventFiringDecorator eventFiringDecorator = new EventFiringDecorator(driverEventListener);

        // W ramach metody decorate "dekorujemy" stworzony poprzednio przez WebDrivera
        return eventFiringDecorator.decorate(driver);
    }
}
