package utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WindowsDriver winDriver = null;

    public static WindowsDriver setup()  {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", ConfigReader.getProperty("app"));
            capabilities.setCapability("platforName", ConfigReader.getProperty("platforName"));
            capabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
        try {
            winDriver = new WindowsDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        winDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return winDriver;
    }


    public void tearDown(){
        winDriver.quit();
    }

    }




