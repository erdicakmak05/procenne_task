package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @After
    public void after(Scenario scenario) {

        if (scenario.isFailed()) {
            scenario.log("Senaryo başarısız oldu, ekran görüntüsü alınıyor.");
            TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
            scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());

            DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();
            File tumSayfaSS = new File("target/screenShot/ss"+dateTime.format(now)+".png");
            File geciciResim=tss.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(geciciResim,tumSayfaSS);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}