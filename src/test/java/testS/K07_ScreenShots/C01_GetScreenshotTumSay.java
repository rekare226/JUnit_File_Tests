package testS.K07_ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenshotTumSay extends TestBase_Each {

    @Test
    public void test01() throws IOException {

  //test otomasyonu sayfasina gidin
  driver.get("https://www.testotomasyonu.com");


  //phone icin arama yapın
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='global-search']"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);




  //arama sonucunda urun bulunabildigini test edin

WebElement aramaSonucElementi= driver.findElement(By.className("product-count-text"));
String unexpectedSonucYazisi="0 Products Found";
String actualSonucYazisi=aramaSonucElementi.getText();
Assertions.assertNotEquals(unexpectedSonucYazisi,actualSonucYazisi);
        ReusableMethods.bekle(1);


// tum sayfanin screenshot'ini alin
// 1. adim tss objesi olusturalım

        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;

//2. adim resmi kaydedeceğimiz File 'olusturalım

        String dosyaYolu="target/secreenshot/tumsayfaResmi.jpeg";
        File tumSayfaResmi=new File(dosyaYolu);

//3. adim screenshot'i alip gecici bir dosya olarak kaydedelim
         File geciciDosya=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumSayfaResmi);















    }
















}
