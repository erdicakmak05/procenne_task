package testSteps;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.BaseScreen;
import utils.ConfigReader;
import utils.Driver;
import utils.Methods;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class TestRunner {
    /**
     * Encrypt-Data.txt dosyası gelen mailde bulunmadığı için girilen bilgiler ile gelen şifreli değer
     * expectedData.txt dosyasına yazılmıştır.
     *
     * Otomasyon işlemlerini tamamladıktanda sonra /resources klosörünün altında Encrypt-Data.txt dosyası oluşturmaktadır.
     *
     * expectedData.txt ile Encrypt-Data.txt Assert edilmiştir.
     */

    BaseScreen baseScreen = new BaseScreen();


    @Test
    public void testStep01() throws IOException {
        WebDriverWait wait = new WebDriverWait(Driver.winDriver,40);
        wait.until(ExpectedConditions.visibilityOf(baseScreen.acilisOkButton)).click();

        baseScreen.aes128RadioButton.click();
        baseScreen.cbcRadioButton.click();
        baseScreen.asciiRadioButton.click();

       baseScreen.keyTextbox.clear();
       baseScreen.keyTextbox.sendKeys(ConfigReader.getProperty("KEY"));

       baseScreen.dataTextbox.click();
       Methods.hardDeleteButton(baseScreen.dataTextbox,51);
       baseScreen.dataTextbox.sendKeys("Merhaba Test Takımı");

       baseScreen.ivTextbox.clear();
       baseScreen.ivTextbox.sendKeys(ConfigReader.getProperty("IV"));

       baseScreen.encryptData.click();
       Methods.waitFor(2);

       String encryptedData = Driver.winDriver.findElementByAccessibilityId("-31976").getText();
       //System.out.println(encryptedData);
       Methods.waitFor(1);
       Methods.txtDosyasinaYazdir(encryptedData);

       try {
           assertEquals("Txt file içeriği eşleşmedi",
                   FileUtils.readFileToString(new File("src/test/resources/expectedData.txt"), "utf-8"),
                   FileUtils.readFileToString(new File("src/test/resources/Encrypt-Data.txt"), "utf-8"));
           System.out.println("Başarılı");
       }catch (AssertionError e){
           e.printStackTrace();
           Assert.assertTrue(false);
       }



        Driver.winDriver.quit();

    }
}
