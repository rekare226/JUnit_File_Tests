package testS.K07_ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C03_WebElementScreenShot extends TestBase_Each {

    @Test
    public void test01() throws IOException {

  //Testotomasyonu anasayfaya gidelim
  driver.get("https://www.testotomasyonu.com");

  //Account linkine tiklayin
driver.findElement(By.xpath("(//*[@class='menu-icon-text'])[1]"))
        .click();

        //Kullanici adi olarak alican@gmail.com girin
        WebElement kullaniciAdiElementi=driver.findElement(By.xpath("//*[@placeholder='Your email address...']"));
        kullaniciAdiElementi.sendKeys("alican@gmail.com");

       //password 12345 girin
        WebElement passwordElementi=driver.findElement(By.xpath("//*[@placeholder='Your Password...']"));
        passwordElementi.sendKeys("12345");


       //sign in butonuna basarak sisteme giris yapin


        driver.findElement(By.xpath("//*[@class='submitbtn btn-lg']")).click();


     //giris yapilabildigini test etmek icin
     //Logout butonunun gorunur oldugunu test edin
     WebElement logoutYazisiElementi=driver.findElement(By.xpath("//span[.='Logout']"));
        Assertions.assertTrue(logoutYazisiElementi.isDisplayed());
        ReusableMethods.bekle(1);


  //Logout butonunun fotografinı cekin


  //1. adim screenshot alacagimiz webelementi locate edip kaydedelim
  //                   biz yukarda Logout butonunu locate ettik


  //2.adim resmi kaydedeceğimiz File'i olusturalim
        String dosyaYolu="target/secreenshot/webElementResmi.jpeg";
        File webElementResim=new File(dosyaYolu);


  //3.adim webElement'i kullanarak screeenshot'i alip geçici bir dosya olarak kaydedelim
        File geciciDosya=logoutYazisiElementi.getScreenshotAs(OutputType.FILE);

//4. adim gecici dosyayi asil dosyaya kopyalayalım
        FileUtils.copyFile(geciciDosya,webElementResim);

//logout butonuna basarak sistemden cikis yapin

    logoutYazisiElementi.click();





    }



}
