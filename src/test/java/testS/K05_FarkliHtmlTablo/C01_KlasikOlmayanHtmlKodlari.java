package testS.K05_FarkliHtmlTablo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikOlmayanHtmlKodlari extends TestBase_Each {

    @Test
    public void test01(){
   //1-"https://www.testotomasyonu.com/webtables2" sayfasina gidin
      driver.get("https://www.testotomasyonu.com/webtables2");

   //1.Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList=driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));
        System.out.println("Basliklar:"+ ReusableMethods.listiStringListeDondur(baslikElementleriList));



   //3. 3. sutunun basligini yazdirin
        System.out.println("3. sutun basliği"+ baslikElementleriList.get(2).getText());


   //4. Tablodaki tüm dataları yazdirin

    List<WebElement> tumdataWebElementListesi=driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));
        System.out.println("tum datalar"+
                ReusableMethods.listiStringListeDondur(tumdataWebElementListesi));

    //5.Tabloda kac tane cell(data) oldugunu yazdirin
        System.out.println("Tablodaki cell adedi"+tumdataWebElementListesi.size());

    //6. Tablodaki satir sayisi yazdirin
    //--satırları locate etmemiz lazım
        List<WebElement> satirElementleriListesi=driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("satir sayisi"+ satirElementleriListesi.size());

    //7.Tablodaki sutun sayisini yazdirin
    //web tabloda sutun yapisi yoktur
    //herhangi bir satşrdaki data sayisina bakabiliriz
    //yukarıda baslık sayıusını katdeyydiğimiz için onu lalabiliriz

        System.out.println("tablodaki sutun sayısı"+baslikElementleriList.size());

    //8.tablodaki 3 kolonu(sutunu) yazdirin
        //web toblada 3. diye birşey yoktur ama sutunu yazdırmak  için
        // 3.datayı aldığımızda 3. data ladar 3 kolandaki sutunu buluruz yoktur her

        List<WebElement> ucuncuSutunElementleriList=driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        System.out.println("3.sutun "+ucuncuSutunElementleriList);

        //10.Bir method olusturun
        //test method'undan satir ve sutun verildiğinde dondursun
        //datayi dondursun


        System.out.println(getCellData(1,2)); //Electronics
        System.out.println(getCellData(1,3));//$399.00
        System.out.println(getCellData(2,1));
        System.out.println(getCellData(3,4));

//9.Tabloda "Category" si Furniture olan urunun fiyatini yazdirin
        //satrıları tek tek dolaşıp istenen bilgiyi kontrol etmeli
        //ve şartı sağlanlar için yazıdırlması istenen bilgiyi yazdırmalıyız
            System.out.println("KATEGORİYE GÖRE ELELEMT SAYISI");
        for (int i = 1; i <=satirElementleriListesi.size() ; i++) {
            String satirdakiKategori=getCellData(i,2);

            if (satirdakiKategori.equalsIgnoreCase("Furniture")){

                System.out.println(getCellData(i,3));
            }

        }



    }

    public String getCellData(int satirNo,int sutunNo){

        //  //*[@role='throw'][4]/*[@role='tdata'][1]
        String dinamikXpath="//*[@role='trow']["+satirNo+"]/*[@role='tdata']["+sutunNo+"]";
       WebElement istenenDataElementi=driver.findElement(By.xpath(dinamikXpath)) ;


       return istenenDataElementi.getText();
    }

}
