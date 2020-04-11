package com.flipkart.framework.driver;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    public Capabilities capabilities;

    public Capabilities getCapabilities (String browser) {

        switch (browser) {
            case "chrome":
                capabilities = OptionsManager.getChromeOptions();
                break;
            case "firefox":
                capabilities = OptionsManager.getFirefoxOptions();
                break;
            default:
                capabilities = null;
                break;
        }

        return capabilities;
    }
}
