package testS.K07_ScreenShots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_MethodIleScreenShot extends TestBase_Each {
    @Test
    public void test01(){

        //1-Testotomasyonu anasayfaya gidelim

        //2-//Account linkine tiklayin

        //3-Kullanici adi olarak alican@gmail.com girin

        //4-password 12345 girin

        //5-sign in butonuna basarak sisteme giris yapin

        //6-giris yapilabildigini test etmek icin
        //Logout butonunun gorunur oldugunu test edin


        //logout butonunun fotografini cekin

        //logout butonuna basarak sistemden cikis yapin

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

        ReusableMethods.webElementResimCek(logoutYazisiElementi);
        ReusableMethods.webElementResimCek(logoutYazisiElementi,"positiveLoginTesti");
        ReusableMethods.tarihliWebElementResimCek(logoutYazisiElementi);
        ReusableMethods.tarihliWebElementResimCek(logoutYazisiElementi,"positiveLoginTesti");





        logoutYazisiElementi.click();


    }











}
