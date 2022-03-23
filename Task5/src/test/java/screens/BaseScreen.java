package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BaseScreen {
    public BaseScreen (){
        PageFactory.initElements(Driver.setup(),this);
    }

    @FindBy(xpath = "//Button[@ClassName='Button']")
    public WebElement acilisOkButton;



    @FindBy(xpath = "//RadioButton[@Name='AES-128']")
    public WebElement aes128RadioButton;

    @FindBy(xpath = "//RadioButton[@Name='CBC']")
    public WebElement cbcRadioButton;

    @FindBy(xpath = "//RadioButton[@Name='ASCII']")
    public WebElement asciiRadioButton;

    @FindBy(xpath = "//Edit[@ClassName='Edit']")
    public WebElement keyTextbox;

    @FindBy(xpath = "//Document[@ClassName='Edit']")
    public WebElement dataTextbox;

    @FindBy(xpath = "//Edit[@ClassName='Edit'][@Name='IV:']")
    public WebElement ivTextbox;

    @FindBy(xpath = "(//Pane[@Name='panel'][starts-with(@AutomationId,'-')]/Button[starts-with(@AutomationId,'-')])[2]")
    public WebElement encryptData;
























}
