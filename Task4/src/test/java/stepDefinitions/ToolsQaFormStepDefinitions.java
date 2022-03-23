package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.ToolsqaPracticePage;
import utils.ConfigReader;
import utils.Driver;

public class ToolsQaFormStepDefinitions {

    ToolsqaPracticePage toolsqaPracticePage = new ToolsqaPracticePage();
    Faker faker = new Faker();
    Select select;
    Actions actions = new Actions(Driver.getDriver());

    @Given("Kullanici {string}'e gider")
    public void kullaniciEGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
        toolsqaPracticePage.exitAdsButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Given("Kullanici Name textbox'ini girer")
    public void kullanici_name_textbox_ini_girer() {
        toolsqaPracticePage.firstnameTextbox.sendKeys(faker.name().firstName());
        toolsqaPracticePage.lastnameTextbox.sendKeys(faker.name().lastName());
    }

    @Given("Kullanici eposta adresini girer")
    public void kullanici_eposta_adresini_girer() {
        toolsqaPracticePage.emailTextbox.sendKeys(faker.internet().emailAddress());
    }

    @Given("Kullanici cinsiyet'ini secer")
    public void kullanici_cinsiyet_ini_secer() {
        toolsqaPracticePage.genderRadiobutton.click();
    }

    @Given("Kullanici telefon numarasini girer")
    public void kullanici_telefon_numarasini_girer() {
        toolsqaPracticePage.phoneNumberTextbox.sendKeys("5658433533");
    }

    @Given("Kullanici dogum tarihini secer")
    public void kullanici_dogum_tarihini_secer() {
        toolsqaPracticePage.birthBox.click();
        select = new Select(toolsqaPracticePage.monthBox);
        select.selectByIndex(5);
        select = new Select(toolsqaPracticePage.yearBox);
        select.selectByValue("1990");
        toolsqaPracticePage.birhdayBox.click();
    }

    @Given("Kullanici subjects textbox'ini girer")
    public void kullanici_subjects_textbox_ini_girer() {
        toolsqaPracticePage.subjectTextbox.sendKeys("English");
        toolsqaPracticePage.subjectTextbox.sendKeys(Keys.ARROW_DOWN);
        toolsqaPracticePage.subjectTextbox.sendKeys(Keys.ENTER);
    }

    @Given("Kullanici hobi checkbox'ini secer")
    public void kullanici_hobi_checkbox_ini_secer() {
        toolsqaPracticePage.hobbiesCheckbox.click();
    }

    @Given("Kullanici resim ekler")
    public void kullanici_resim_ekler() {
        String imagePath =  System.getProperty("user.dir")+"\\src\\test\\profil.jpg";
        System.out.println(imagePath);
        toolsqaPracticePage.uploadPictureElement.sendKeys(imagePath);

    }

    @Given("Kullanici adress textbox'ini doldurur")
    public void kullanici_adress_textbox_ini_doldurur() throws InterruptedException {
        toolsqaPracticePage.adressTextbox.sendKeys(faker.address().fullAddress());
        Thread.sleep(2000);
    }

    @Given("Kullanici eyalet secer")
    public void kullanici_eyalet_secer() {
        actions.click(toolsqaPracticePage.stateDropdown).sendKeys("NCR").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Given("Kullanici sehir secer")
    public void kullanici_sehir_secer() {
        actions.click(toolsqaPracticePage.cityDropdown).sendKeys("Delhi").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Given("Kullanici submit butonuna tiklar")
    public void kullanici_submit_butonuna_tiklar() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.body.style.zoom = '0.75'");
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", toolsqaPracticePage.submitButton);
    }

    @Then("Kullanici basarili olarak kayit gonderdigini test eder")
    public void kullanici_basarili_olarak_kayit_gonderdigini_test_eder() throws InterruptedException {
        Thread.sleep(3000);
        String expectedTitle = "Thanks for submitting the form";
        String actuelTitle = toolsqaPracticePage.formTitle.getText();
        Assert.assertEquals(expectedTitle,actuelTitle);
        Assert.assertTrue(toolsqaPracticePage.kayitEkrani.isDisplayed());
    }

    @Then("Kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
       Driver.closeDriver();
    }


    @And("Kullanici Name Surname textbox'ini bos birakir")
    public void kullaniciNameSurnameTextboxIniBosBirakir() {
        //pass
    }

    @And("Kullanici cinsiyet bolumunde secim yapmaz")
    public void kullaniciCinsiyetBolumundeSecimYapmaz() {
        //pass
    }

    @Then("Kullanici eksik bilgiler ile kayit gonderilemedigini test eder")
    public void kullaniciEksikBilgilerIleKayitGonderilemediginiTestEder() {
        try {
            Assert.assertFalse(toolsqaPracticePage.kayitEkrani.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }

    }

    @And("Kullanici gecersiz email adresi girer")
    public void kullaniciGecersizEmailAdresiGirer() {

        toolsqaPracticePage.emailTextbox.sendKeys(ConfigReader.getProperty("InvalidEmail"));
    }
}
