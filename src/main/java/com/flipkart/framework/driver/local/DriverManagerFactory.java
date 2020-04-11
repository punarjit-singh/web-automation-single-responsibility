package com.flipkart.framework.driver.local;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType driverType) {

        DriverManager driverManager;

        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                System.out.println("FirefoxDriverManager not implemented");
                driverManager = null;
                break;
            case IE:
                System.out.println("IeDriverManager not implemented");
                driverManager = null;
                break;
            case SAFARI:
                System.out.println("SafariDriverManager not implemented");
                driverManager = null;
                break;
            default:
                driverManager = null;
                break;
        }

        return driverManager;
    }
}
