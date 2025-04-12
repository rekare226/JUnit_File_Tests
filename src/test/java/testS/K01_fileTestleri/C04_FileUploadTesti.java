package testS.K01_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_FileUploadTesti extends TestBase_Each {

    @Test
    public void test01(){

    //1-https://the-internet.herokuapp.com/upload adresine gidelim
    driver.get("https://the-internet.herokuapp.com/upload");

    //2-chooseFile butonuna basalim

        ReusableMethods.bekle(2);
     WebElement dosyasecButonu=driver.findElement(By.id("file-upload"));

    //3-Proje altindaki deneme.txt dosyayi secelim


    /*
    Dosya sec butonuna bastigimizda bilgisayaramizdaki dosya yapisi çikiyor

    WebDriver ile bilgisayaraımızdaki fiziki dosya yapisina mudahale edemeyeceğimiz icin
    Selenium bize sendKeys (dosyaYolu) yapma firsati verir

     */
String dinamikDosyaYoluDeneme=System.getProperty("user.dir")+"/src/test/java/testS/K01_fileTestleri/deneme.txt";

        System.out.println(dinamikDosyaYoluDeneme);

dosyasecButonu.sendKeys(dinamikDosyaYoluDeneme);
ReusableMethods.bekle(2);
driver.findElement(By.id("file-submit")).click();
//"File Uploaded!" textinin goruntulendigini test edelim.
WebElement fileUploadYazisi=driver.findElement(By.xpath("//*[.='File Uploaded!']"));
        Assertions.assertTrue(fileUploadYazisi.isDisplayed());

        String expecetdYazi="File Uploaded!";
        String actualYazi=fileUploadYazisi.getText();

        Assertions.assertEquals(expecetdYazi,actualYazi);


    }
}
