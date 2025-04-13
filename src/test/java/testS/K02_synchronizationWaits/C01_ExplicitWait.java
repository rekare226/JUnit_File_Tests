package testS.K02_synchronizationWaits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.time.Duration;

public class C01_ExplicitWait{

    WebDriver driver;
    @Test
    public void implicitlyWaitTesti(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2.Textbox'in etkin olmadigini (enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());



        //3.Enable butonuna tiklayin
        driver.findElement(By.xpath("//*[.='Enable']")).click();
       //textbox etkin olana kadar bekleyin
        ReusableMethods.bekle(3);
        Assertions.assertTrue(textBox.isEnabled());

        //4.Textbox'in etkin oldugunu(enabled) dogrulayin


        //5."It's enabled!" mesajının goruntulendigini dogrulayın
        ReusableMethods.bekle(2);
        WebElement itsEnabledYazisi=driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertTrue(itsEnabledYazisi.isDisplayed());



        ReusableMethods.bekle(2);
        driver.quit();


    }

    @Test
    public void explicitWaitTesti(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
   //1- https://the-internet.herokuapp.com/dynamic_controls adresine gidin
   driver.get("https://the-internet.herokuapp.com/dynamic_controls");

   //2-Texbox'in etkin olmadıgını (enabled)dogrulayın
         WebElement textBoxYaziElementi=driver.findElement(By.xpath("//input[@type='text']"));

         Assertions.assertFalse(textBoxYaziElementi.isEnabled());

   //3-Enable butonuna tiklayin
        driver.findElement(By.xpath("//*[.='Enable']"))
                .click();

   //ve textbox etkin oluncaya kadar bekleyin
        // explicitlyWait ile bekleyelim

   //1. adim bir wait objesi olustur

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   //2. adim MUMKUNSE beklenecek objeyi locate edip bir webelement olarak kaydedin
   //textbox'i locate edebiliyoruz ve yukarıda locate edip kaydettik


      //3.adim wait objesine neyi bekleyeceğini söyleyin

       wait.until(ExpectedConditions.elementToBeClickable(textBoxYaziElementi));

       //4-Textbox un etkin oldugunu dogrulayın
        Assertions.assertTrue(textBoxYaziElementi.isEnabled());

        //5."It's enabled!" mesajının goruntulendigini dogrulayın
        ReusableMethods.bekle(2);
        WebElement itsEnabledYazisi=driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertTrue(itsEnabledYazisi.isDisplayed());

        driver.quit();


    }




}
