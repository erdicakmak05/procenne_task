package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DemoRequestPage;
import pages.Homepage;
import utils.ConfigReader;
import utils.Driver;
import utils.Methods;

public class DemoRequestFonksiyonStepDefinitions {

    Homepage homepage = new Homepage();

    DemoRequestPage demoRequestPage = new DemoRequestPage();

    Faker faker = new Faker();

    @Given("Kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @Given("Kullanici Demo Request butonuna tiklar")
    public void kullanici_demo_request_butonuna_tiklar() {
        homepage.demoRequestPageButton.click();
    }

    @And("Kullanici demo-request sayfasinda oldugunu test eder")
    public void kullaniciDemoRequestSayfasindaOldugunuTestEder() {
        String expectedDemoRequestPageUrl = "https://procenne.com/demo-request/";
        String actualDemoRequestPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedDemoRequestPageUrl,actualDemoRequestPageUrl);
    }

    @Given("Kullanici Name textbox'ini geçerli bilgi girer")
    public void kullanici_name_textbox_ini_gecerli_bilgi_girer() {
        demoRequestPage.nameTextbox.sendKeys(faker.name().firstName());
    }

    @Given("Kullanici Surname textbox'ini geçerli bilgi girer")
    public void kullanici_surname_textbox_ini_gecerli_bilgi_girer() {
        demoRequestPage.surnameTextbox.sendKeys(faker.name().lastName());
    }

    @Given("Kullanici Email textbox'ini geçerli bilgi girer")
    public void kullanici_email_textbox_ini_gecerli_bilgi_girer() {
        demoRequestPage.emailTextbox.sendKeys(faker.internet().emailAddress());
    }

    @Given("Kullanici Product dropdown menüsünden bir ürün seçer")
    public void kullanici_product_dropdown_menusunden_bir_urun_secer() {
        Select select = new Select(demoRequestPage.productDropdownButton);
        select.selectByIndex(1);
    }

    @Given("Kullanici Institution textbox'ini geçerli bilgi girer")
    public void kullanici_institution_textbox_ini_gecerli_bilgi_girer() {
        demoRequestPage.institutionTextbox.sendKeys(faker.company().name());
    }

    @Given("Kullanici Title textbox'ini geçerli bilgi girer")
    public void kullanici_title_textbox_ini_gecerli_bilgi_girer() {
        demoRequestPage.titleTextbox.sendKeys(faker.lorem().word());
    }

    @Given("Kullanici Phone textbox'ini geçerli bilgi girer")
    public void kullanici_phone_textbox_ini_gecerli_bilgi_girer() {
        demoRequestPage.phoneTextbox.sendKeys(faker.phoneNumber().phoneNumber());
    }

    @Given("Kullanici Message textbox'ini geçerli bilgi girer")
    public void kullanici_message_textbox_ini_gecerli_bilgi_girer() {
        demoRequestPage.messageTextbox.sendKeys("MERHABA TEST TAKIMI");
        Actions actions = new Actions(Driver.getDriver());
        Methods.pageScroll(150);
        Methods.waitFor(2);
    }

    @Given("Kullanici KVKK onayi için checkbox'i seçer")
    public void kullanici_kvkk_onayi_icin_checkbox_i_secer() {
        demoRequestPage.kvkkRadioButton.click();
    }

    @Given("Kullanici Kampanyalar için mail onayi checkbox'ini seçer")
    public void kullanici_kampanyalar_icin_mail_onayi_checkbox_ini_secer() {
        Actions actions = new Actions(Driver.getDriver());
        Methods.pageScroll(170);

        Methods.waitFor(2);
        demoRequestPage.campaingRadioButton.click();
    }
    @Given("Kullanici Captcha onayini yapar")
    public void kullanici_captcha_onayini_yapar() {
        Assert.assertTrue(false);
    }

    @Given("Kullanici Send butonuna tiklar")
    public void kullanici_send_butonuna_tiklar() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0, 120);");
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        demoRequestPage.sendButton.click();
        Methods.waitFor(1);
    }

    @Given("Kullanici alert mesajinda Successful! yazdigini test eder")
    public void kullanici_alert_mesajinda_successful_yazdigini_test_eder() {
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            String actualAlertMessage = alert.getText();
            String expectedAlertMessage = "Successful!";
            Methods.waitFor(1);
            Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
        }catch (UnhandledAlertException e){
            String actualAlertMessage = e.getMessage();
            String expectedAlertMessage = "Lütfen Recaptcha yı işaretleyin";
            Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
        }
    }

    @Given("Kullanici alert ekranini onaylar.")
    public void kullanici_alert_ekranini_onaylar() {
        try {
            Driver.getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException e){
            Methods.waitFor(1);
        }
        Methods.waitFor(1);
    }

    @Given("Kullanici sayfayi kapatir.")
    public void kullanici_sayfayi_kapatir() {
       Driver.closeDriver();
    }


    @And("Kullanici Email textbox'ina geçersiz bir mail adresi girer")
    public void kullaniciEmailTextboxInaGecersizBirMailAdresiGirer() {
        demoRequestPage.emailTextbox.sendKeys(ConfigReader.getProperty("InvalidEmail"));
    }

    @And("Kullanici Email textbox'da hata mesaji aldigini test eder")
    public void kullaniciEmailTextboxDaHataMesajiAldiginiTestEder() {
        if (ConfigReader.getProperty("browser").equals("chrome")){
            String expectedMessage = "Please include an '@' in the email address. 'mailetkmail.com' is missing an '@'.";
            String actualMessage = demoRequestPage.emailTextbox.getAttribute("validationMessage");
            Assert.assertEquals("Email validation error",expectedMessage,actualMessage);
            Methods.waitFor(1);
        }else {
            String expectedMessage = "Lütfen bir e-posta adresi yazın.";
            String actualMessage = demoRequestPage.emailTextbox.getAttribute("validationMessage");
            Assert.assertEquals("Email validation error",expectedMessage,actualMessage);
            Methods.waitFor(1);
        }


    }

    @And("Kullanici Product dropdown menüsünden urun secmez")
    public void kullaniciProductDropdownMenusundenUrunSecmez() {
        //pass
    }

    @And("Kullanici lütfen listeden bir oge secin mesajı aldıgını test eder")
    public void kullaniciLutfenListedenBirOgeSecinMesajiAldiginiTestEder() {
        if (ConfigReader.getProperty("browser").equals("chrome")){
            String expectedMessage = "Please select an item in the list.";
            String actualMessage = demoRequestPage.productDropdownButton.getAttribute("validationMessage");
            Assert.assertEquals("Product validation message error",expectedMessage,actualMessage);
            Methods.waitFor(1);
        }else {
            String expectedMessage = "Lütfen listeden bir öge seçin.";
            String actualMessage = demoRequestPage.productDropdownButton.getAttribute("validationMessage");
            Assert.assertEquals("Product validation message error",expectedMessage,actualMessage);
            Methods.waitFor(1);
        }


    }

    @And("Kullanici KVKK onayi checkbox'ini secmeden devam eder")
    public void kullaniciKVKKOnayiCheckboxIniSecmedenDevamEder() {
        //pass
    }

    @And("Kullanici ilerlemek istiyorsaniz bu kutuyu doldurun mesajini aldigini test eder")
    public void kullaniciIlerlemekIstiyorsanizBuKutuyuDoldurunMesajiniAldiginiTestEder() {
        if (ConfigReader.getProperty("browser").equals("chrome")){
            String expectedMessage = "Please check this box if you want to proceed.";
            String actualMessage = demoRequestPage.kvkkRadioButton.getAttribute("validationMessage");
            Assert.assertEquals("kvkkCheckbox validation message error",expectedMessage,actualMessage);
        }else {
            String expectedMessage = "Devam etmek için lütfen bu kutuyu işaretleyin.";
            String actualMessage = demoRequestPage.kvkkRadioButton.getAttribute("validationMessage");
            Assert.assertEquals("kvkkCheckbox validation message error",expectedMessage,actualMessage);
        }

    }

    @And("Kullanici Kampanyalar için mail onayi checkbox'ini secmeden devam eder")
    public void kullaniciKampanyalarIcinMailOnayiCheckboxIniSecmedenDevamEder() {
        //pass
    }

    @And("Kullanici alert mesajinda Lutfen recaptchayi isaretleyin yazdigini test eder")
    public void kullaniciAlertMesajindaLutfenRecaptchayiIsaretleyinYazdiginiTestEder() {
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            String actualAlertMessage = alert.getText();
            String expectedAlertMessage = "Lütfen Recaptcha yı işaretleyin";
            Methods.waitFor(1);
            Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
        }catch (UnhandledAlertException e){
            String actualAlertMessage = e.getMessage();
            String expectedAlertMessage = "Lütfen Recaptcha yı işaretleyin";
            Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
        }

    }

    @And("Kullanici Ticari Elektronik ileti izni  metnine tiklar")
    public void kullaniciTicariElektronikIletiIzniMetnineTiklar() {
        Methods.pageScroll(200);
        demoRequestPage.ticariIzinSayfasiLink.click();
    }

    @And("Kullanici Ticari Elektronik ileti izni metni sayfasına gectigini test eder")
    public void kullaniciTicariElektronikIletiIzniMetniSayfasinaGectiginiTestEder() {
        String expectedUrl="https://procenne.com/tr/ticari-elektronik-ileti-izni/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("Beklenen Url bulunamadı",expectedUrl,actualUrl);
    }

    @Then("Kullanici yazi title'inin Ticari Elektronik ileti izni oldugunu test eder")
    public void kullaniciYaziTitleIninTicariElektronikIletiIzniOldugunuTestEder() {
        String expectedTitle="Ticari Elektronik İleti İzni";
        String actualTitle= demoRequestPage.getTicariIzinSayfasiYaziTitle.getText();
        Assert.assertEquals("Yazı başlıkları eşleşmedi",expectedTitle,actualTitle);
    }

    @And("Kullanici KVKK metnine tiklar")
    public void kullaniciKVKKMetnineTiklar() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0, 250);");
        Methods.waitFor(6);
        demoRequestPage.kvkkSayfasiLink.click();
    }

    @And("Kullanici KVKK metni sayfasına gectigini test eder")
    public void kullaniciKVKKMetniSayfasinaGectiginiTestEder() {
        String expectedUrl = "https://procenne.com/tr/demo-talebi-aydinlatma-metni/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("kvkk sayfasi adres current adress error",expectedUrl,actualUrl);
    }

    @Then("Kullanici yazi title'inin Demo Talebi Aydinlatma Metni oldugunu test eder")
    public void kullaniciYaziTitleIninDemoTalebiAydinlatmaMetniOldugunuTestEder() {
        String expectedTitle = "Demo Talebi Aydınlatma Metni";
        String actualTitle = demoRequestPage.kvkkSayfasiYaziTitle.getText();
    }

    @And("Kullanici Name textbox'ini {string} girer")
    public void kullaniciNameTextboxIniGirer(String girilecekName) {
        demoRequestPage.nameTextbox.sendKeys(girilecekName);
    }
}
