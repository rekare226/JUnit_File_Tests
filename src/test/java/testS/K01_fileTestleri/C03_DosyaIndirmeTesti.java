package testS.K01_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_DosyaIndirmeTesti extends TestBase_Each {

  @Test
  public void test01(){
   //1.https://the-internet.herokuapp.com/download adresine gidelim
    driver.get("https://the-internet.herokuapp.com/download");


   //2. evening.png dosyasını indirelim
      driver.findElement(By.xpath("//*[.='evening.png']")).click();
      ReusableMethods.bekle(2);


   //3. dosyanın basarıyla indirilip indirilmediğini test edin
      String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\evening.png";
      Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));








  }










}
