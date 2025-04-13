package testS.K02_synchronizationWaits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitWait {

    WebDriver driver;

 @Test
 public void implicityWaitTesti(){
 driver=new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     //1- https://the-internet.herokuapp.com/dynamic_controls adresine gidin
     driver.get("https://the-internet.herokuapp.com/dynamic_controls");

     //2-Remove butonuna basin
     driver.findElement(By.xpath("//button[.='Remove']")).click();

     //3-"It's gone!" mesajinin goruntulendigini dogrulayın

     WebElement itsGoneYazisiElementi=driver.findElement(By.xpath("//*[@id='message']"));
     Assertions.assertTrue(itsGoneYazisiElementi.isDisplayed());

     //4-Add butonuna basin
     driver.findElement(By.xpath("//*[.='Add']"))
             .click();


     //5.It's back mesajinin gorundugunu test edin

     WebElement itsBackElementiYazisi= driver.findElement(By.xpath("//*[.='Add']"));
     Assertions.assertTrue(itsBackElementiYazisi.isDisplayed());


driver.quit();

 }

 @Test
    public void explicitWaitTesti(){
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

     //1- https://the-internet.herokuapp.com/dynamic_controls adresine gidin
     driver.get("https://the-internet.herokuapp.com/dynamic_controls");

     //2-Remove butonuna basin
     driver.findElement(By.xpath("//button[.='Remove']")).click();

     //3-"It's gone!" mesajinin goruntulendigini dogrulayın
     //    WebElement itsGoneYazisiElementi=driver.findElement(By.xpath("//*[@id='message']"));
     //     Assertions.assertTrue(itsGoneYazisiElementi.isDisplayed());

     //1. adım wait objesi olustur
     WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
     //2. ve 3. adım :bekleme yapmadan locate etmek mumkun olmadıgından
     // bekleme ve locate tek adimda yapacagız

     WebElement itsGoneYazisiElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
     Assertions.assertTrue(itsGoneYazisiElementi.isDisplayed());


     //4-Add butonuna basin
     driver.findElement(By.xpath("//*[.='Add']"))
             .click();


     //5-It's back mesajının gorundugunu test edin
     WebElement itsBackYazisiElementi=
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));


     driver.quit();

 }



}
