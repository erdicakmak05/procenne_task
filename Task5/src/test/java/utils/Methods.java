package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Methods {

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void hardDeleteButton(WebElement element, int silinecekKarakterSayisi){
        Actions actions = new Actions(Driver.winDriver);
        for (int i = 1; i <= silinecekKarakterSayisi; i++) {
            actions.sendKeys(Keys.BACK_SPACE).perform();
        }
    }


    public static void txtDosyasinaYazdir(String encryptData){
        try {
            File file = new File("src/test/resources/Encrypt-Data.txt");

            if (file.createNewFile()) {
                System.out.println("Dosya Oluşturuldu");
            }
            else {
                System.out.println("Dosya Zaten var!");
            }
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            String code = encryptData.substring(encryptData.length()-64);
            bWriter.write(code);
            bWriter.close();
        }

        catch (IOException e) {
            System.err.println(e);
        }
    }
}
