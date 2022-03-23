package utils;

import org.openqa.selenium.JavascriptExecutor;

public class Methods {

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void  pageScroll(int pixel){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0, "+pixel+");");
    }
}
