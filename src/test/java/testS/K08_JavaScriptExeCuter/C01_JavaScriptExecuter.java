package testS.K08_JavaScriptExeCuter;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_JavaScriptExecuter extends TestBase_Each {

    @Test
    public void test01(){

   //https://www.testotomasyonu.com/form sayfasina gidin
   driver.get("https://www.testotomasyonu.com/form");

   //isitme kaybi checkbox gorunecek kadar asagi gidin

       //1. adim jse objesi olustur
        JavascriptExecutor jse=(JavascriptExecutor) driver;

       // 2.adim kullanmak istediğimiz webelementi locate edip kaydedin
        WebElement isitmeKaybiCheckBox= driver.findElement(By.id("hastalikCheck5"));
        ReusableMethods.bekle(1);
        jse.executeScript("arguments[0].scrollIntoView(true);",isitmeKaybiCheckBox);
        ReusableMethods.bekle(3);
      //3. adım jse.executeScript() ile istenen işelmi yapın
        jse.executeScript("arguments[0].click();",isitmeKaybiCheckBox);
        ReusableMethods.bekle(3);

        //javascript ile JUnit bitti yazdırın
        jse.executeScript("alert('JUnit bittttiiii');");
        ReusableMethods.bekle(2);






    }








}
