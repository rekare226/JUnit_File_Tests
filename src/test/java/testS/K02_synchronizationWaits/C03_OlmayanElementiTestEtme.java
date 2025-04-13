package testS.K02_synchronizationWaits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_OlmayanElementiTestEtme {
    WebDriver driver;

    @Test
    public void test01(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2-Remove butonuna basin
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //it's gone yazisi gorununceye kadar bekleyin
        //itsgone yazi elemntini daha önce locate etmedğimiz için bekler ve checkbox yok olur
WebElement itsgoneYazisi=driver.findElement(By.xpath("//*[@id='message']"));

        //3.checkbox'in gorunur olmadigini test edin
        //checkbox ı daha önce lopcate etmediğimiz için
        //implictywait locate edinceye kadar bekler
        /*
        checkbox'i daha önceden locate ettiğimiz icin
        StaleElementreference Excepiton verdi,

        eger onceden locate etmemeis olsa idik bu satırda locate etmeye calissaydik
        implicityWait suresi kadar bekler ve sonra NoSuchElementException verirdi
         */

        try {
            WebElement checkBozYazisiElementi=driver.findElement(By.id("checkbox"));
            //locate edebilirse checkbox görünür demektir buda bizden isteene görevin failed oldugunu gösterir
            Assertions.assertTrue(false,"checkbox görünür durumunda");
        } catch (NoSuchElementException e) {
            //Checkbox'i locate edemediği için NoSuchElementException oluşur bu da aslında bizden istenen yani
            //checkbox in görünmediğinin ispatidir
            Assertions.assertTrue(true);

        }

//4- Add butonuna basin
        driver.findElement(By.xpath("//button[.='Add']"))
                .click();
//5-checkbox in görünür oldugunu test edin

        WebElement checkBozYazisiElementi=driver.findElement(By.id("checkbox"));
        Assertions.assertTrue(checkBozYazisiElementi.isDisplayed());
        driver.quit();

    }

}
