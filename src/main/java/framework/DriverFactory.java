package framework;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    protected static AndroidDriver<MobileElement> createDriver(){
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability(MobileCapabilityType.DEVICE_NAME , "emulator-5544");
        config.setCapability(MobileCapabilityType.UDID , "emulator-5554");
        config.setCapability(MobileCapabilityType.AUTOMATION_NAME , "UiAutomator2");
        config.setCapability(MobileCapabilityType.PLATFORM_NAME , "Android");
        config.setCapability("appPackage" ,  "");
        config.setCapability("appActivity" , "");
        config.setCapability("autoGrantPermissions" , true);
        URL connectionUrl =null ;

        try {
            connectionUrl = new URL("http://127.0.0.1:4723/wd/hub");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return new AndroidDriver<>(connectionUrl , config);
    }
}
