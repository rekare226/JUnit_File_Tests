package testS.K07_ScreenShots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Locale;

public class C02_MethodleGetScreenShot extends TestBase_Each {
    @Test
    public void test01(){
        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //phone icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        // arama sonucunda urun bulunabildigini test edin
        String unexpectedUrunSonuc="0 Products Found";
        String actualUrunSonuc=driver.findElement(By.className("product-count-text")).getText();
        Assertions.assertNotEquals(unexpectedUrunSonuc,actualUrunSonuc);
        ReusableMethods.bekle(2);
        //tum sayfa screenshot alin
        ReusableMethods.tumSayfaResimCek(driver);
        //her seferinde verdiğimiz isim olan tumSayfaResmi.jpeg olarak resmi kaydeder.
        //onceki cekilenler silinmiş olur

        ReusableMethods.tumSayfaResimCek(driver,"aramaTesti14Nisan");

        //ilk urunu tiklayın
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        //acilan sayfadaki urun isminde case sensetive olmadan "phone" bulundugunu test edin
        WebElement ilkUrunIsimElementi=driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String expectedPhoneYazısı="phone";
        String actualPhoneYazısı=ilkUrunIsimElementi.getText();

        Assertions.assertTrue(actualPhoneYazısı.toLowerCase().contains(expectedPhoneYazısı));
        ReusableMethods.bekle(1);















    }











  //acilan sayfadaki urun isminde case sensetive olmadan "phone" bulundugunu test edin


  //sayfanın fotografını cekin





}
