package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ToolsqaPracticePage {

    public ToolsqaPracticePage () {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstnameTextbox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastnameTextbox;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    public WebElement genderRadiobutton;

    @FindBy(xpath = "//input[@id='userNumber']")
    public WebElement phoneNumberTextbox;

    @FindBy (xpath = "//input[@id='dateOfBirthInput']")
    public WebElement birthBox;

    @FindBy (className = "react-datepicker__month-select")
    public WebElement monthBox;

    @FindBy (className = "react-datepicker__year-select")
    public WebElement yearBox;

    @FindBy (xpath = "//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]")
    public WebElement birhdayBox;

    @FindBy (id = "subjectsInput")
    public WebElement subjectTextbox;

    @FindBy (xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement hobbiesCheckbox;

    @FindBy (xpath = "//input[@id='uploadPicture']")
    public WebElement uploadPictureElement;

    @FindBy (xpath = "//textarea[@id='currentAddress']")
    public WebElement adressTextbox;

    @FindBy (xpath = "//div[@class=' css-1hwfws3']")
    public WebElement stateDropdown;

    @FindBy (xpath = "//div[@id='city']")
    public WebElement cityDropdown;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement submitButton;

    @FindBy (id = "close-fixedban")
    public WebElement exitAdsButton;

    @FindBy (className = "modal-header")
    public WebElement formTitle;

    @FindBy (className = "modal-content")
    public WebElement kayitEkrani;

}
