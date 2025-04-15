package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static void  bekle(int saniye){

   try {

       Thread.sleep(saniye*1000);
   }
    catch (InterruptedException e){

        System.out.println("Thread.sleep komutu calismadi");

    }

    }

    public static List<String> listiStringListeDondur(List<WebElement> WebElementListesi){

List<String> stringList=new ArrayList<>();

for (WebElement eachElement
         :WebElementListesi) {

    stringList.add(eachElement.getText());
   }

return stringList;
    }

    public static void tumSayfaResimCek(WebDriver driver){
     // 1. adim tss objesi olusturalım

        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;

//2. adim resmi kaydedeceğimiz File 'olusturalım

        String dosyaYolu="target/secreenshot/tumsayfaResmi.jpeg";
        File tumSayfaResmi=new File(dosyaYolu);

//3. adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya=takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("resim cekilemedi");
        }


    }

    public static void tumSayfaResimCek(WebDriver driver,String raporIsmi) {

        // 1. adim tss objesi olusturalım

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

//2. adim resmi kaydedeceğimiz File 'olusturalım

        String dosyaYolu = "target/secreenshot/"+raporIsmi+".jpeg";
        File tumSayfaResmi = new File(dosyaYolu);

//3. adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("resim cekilemedi");


        }

    }

    public static void tarihliTumSayfaResimCek(WebDriver driver){

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi=localDateTime.format(format);//_140425_

        // 1. adim tss objesi olusturalım

        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;

//2. adim resmi kaydedeceğimiz File 'olusturalım

        String dosyaYolu="target/secreenshot/tumsayfaResmi"+tarihEtiketi+".jpeg";
        File tumSayfaResmi=new File(dosyaYolu);

//3. adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya=takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("resim cekilemedi");
        }


    }

    public static void tarihliTumSayfaResimCek(WebDriver driver,String raporIsmi) {

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi=localDateTime.format(format);//_140425_

        // 1. adim tss objesi olusturalım

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

//2. adim resmi kaydedeceğimiz File 'olusturalım

        String dosyaYolu = "target/secreenshot/"+raporIsmi+tarihEtiketi+".jpeg";
        File tumSayfaResmi = new File(dosyaYolu);

//3. adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaResmi);
        } catch (IOException e) {
            System.out.println("resim cekilemedi");


        }

    }

    public static void webElementResimCek(WebElement logoutYazisiElementi) {
        //1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        //                   biz parametre olarak gönderiyoruz


        //2.adim resmi kaydedeceğimiz File'i olusturalim
        String dosyaYolu="target/secreenshot/webElementResmi.jpeg";
        File webElementResim=new File(dosyaYolu);


        //3.adim webElement'i kullanarak screeenshot'i alip geçici bir dosya olarak kaydedelim
        File geciciDosya=logoutYazisiElementi.getScreenshotAs(OutputType.FILE);

//4. adim gecici dosyayi asil dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//logout butonuna basarak sistemden cikis yapin

        logoutYazisiElementi.click();









    }

    public static void webElementResimCek(WebElement logoutYazisiElementi,String raporIsmi) {
        //1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        //                   biz parametre olarak gönderiyoruz


        //2.adim resmi kaydedeceğimiz File'i olusturalim
        String dosyaYolu="target/secreenshot/"+raporIsmi+".jpeg";
        File webElementResim=new File(dosyaYolu);


        //3.adim webElement'i kullanarak screeenshot'i alip geçici bir dosya olarak kaydedelim
        File geciciDosya=logoutYazisiElementi.getScreenshotAs(OutputType.FILE);

//4. adim gecici dosyayi asil dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//logout butonuna basarak sistemden cikis yapin

        logoutYazisiElementi.click();









    }

    public static void tarihliWebElementResimCek(WebElement logoutYazisiElementi) {

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi=localDateTime.format(format);//_140425_
        //1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        //                   biz parametre olarak gönderiyoruz


        //2.adim resmi kaydedeceğimiz File'i olusturalim
        String dosyaYolu="target/secreenshot/webElementResmi"+tarihEtiketi+".jpeg";
        File webElementResim=new File(dosyaYolu);


        //3.adim webElement'i kullanarak screeenshot'i alip geçici bir dosya olarak kaydedelim
        File geciciDosya=logoutYazisiElementi.getScreenshotAs(OutputType.FILE);

//4. adim gecici dosyayi asil dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//logout butonuna basarak sistemden cikis yapin

        logoutYazisiElementi.click();









    }

    public static void tarihliWebElementResimCek(WebElement logoutYazisiElementi,String raporIsmi) {

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi=localDateTime.format(format);//_140425_
        //1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        //                   biz parametre olarak gönderiyoruz


        //2.adim resmi kaydedeceğimiz File'i olusturalim
        String dosyaYolu="target/secreenshot/"+raporIsmi+tarihEtiketi+".jpeg";
        File webElementResim=new File(dosyaYolu);


        //3.adim webElement'i kullanarak screeenshot'i alip geçici bir dosya olarak kaydedelim
        File geciciDosya=logoutYazisiElementi.getScreenshotAs(OutputType.FILE);

//4. adim gecici dosyayi asil dosyaya kopyalayalım
        try {
            FileUtils.copyFile(geciciDosya,webElementResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//logout butonuna basarak sistemden cikis yapin

        logoutYazisiElementi.click();









    }



    }


