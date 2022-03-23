package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DemoRequestPage {

    public DemoRequestPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement nameTextbox;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement surnameTextbox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement institutionTextbox;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleTextbox;

    @FindBy(xpath = "//input[@id='telephone']")
    public WebElement phoneTextbox;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement messageTextbox;

    @FindBy(xpath = "//select[@id='konu']")
    public WebElement productDropdownButton;

    @FindBy(xpath = "//input[@id='kvkk']")
    public WebElement kvkkRadioButton;

    @FindBy(xpath = "//input[@id='campaing']")
    public WebElement campaingRadioButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sendButton;

    @FindBy(xpath = "//label[@for='campaing']")
    public WebElement ticariIzinSayfasiLink;

    @FindBy(xpath = "//div[@class='col-6']")
    public WebElement getTicariIzinSayfasiYaziTitle;

    @FindBy(xpath = "//label[@for='kvkk']")
    public WebElement kvkkSayfasiLink;

    @FindBy(xpath = "//div[@class='col-6']")
    public WebElement kvkkSayfasiYaziTitle;

}
