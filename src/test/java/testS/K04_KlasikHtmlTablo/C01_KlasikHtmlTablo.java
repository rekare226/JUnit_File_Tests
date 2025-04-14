package testS.K04_KlasikHtmlTablo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikHtmlTablo extends TestBase_Each {

    @Test
    public void  test01(){
      //1-"https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");


     //2-Web table tum body'sini yazdırın
        WebElement tumBodyElement= driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body  :\n"+ tumBodyElement.getText());

     //3-Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloIcerik="Comfortable Gaming Chair";
        String actualTumTablo=tumBodyElement.getText();
        Assertions.assertTrue(actualTumTablo.contains(expectedTabloIcerik));
     //4-Web tablosunda satır sayısının 5 oldugunu test edin
        List<WebElement> tumsatirElementleriList=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirsayisi=5;
        int actualSatirsayisi=tumsatirElementleriList.size();
        Assertions.assertEquals(expectedSatirsayisi,actualSatirsayisi);

     //5-Tum satırları yazdirin
        System.out.println("=============Tum Satirlar==============");
        System.out.println(ReusableMethods.listiStringListeDondur(tumsatirElementleriList));
        //eger satırları belirterek yazdırmak istersek bir for each loop ile satırlar yazdırılı
        int satırNo=1;
        for ( WebElement eachSatirElment
                 :tumsatirElementleriList   ) {

            System.out.println(satırNo+".satir"+eachSatirElment.getText());
            satırNo++;
           }

        //bu da for loop ile yapılmış hali
//        for (int i = 0; i < tumsatirElementleriList.size(); i++) {
//            WebElement eachSatirElement = tumsatirElementleriList.get(i);
//            System.out.println((i + 1) + ". satir " + eachSatirElement.getText());
//        }

//6- Web table'deki sutun sayisinin 4 oldugunu test edin
 //not web table da sutun diye bir şey yoktur
        //1 .saturda kaçtana td (yani data)varsa o kadar sutun vardır

  List<WebElement> birincisatirElementleriList=driver.findElements(By.xpath("//tbody/tr[*]/td[2]"));
   int expectedSutunSayisi=5; //5 i kontrol etmek lazım???
   int actualSutunSayisi=birincisatirElementleriList.size();
   Assertions.assertEquals(expectedSutunSayisi,actualSutunSayisi);

 //7- 3. sutunu yazdıralım
 //web tablolarında surun degeri yoktur her satırdaki 3. datayi alıp sutunu oluşturururuz

 List<WebElement> ucuncuSutunWebElementleriList=driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));
        System.out.println("Ucuncu sutun : "+ ReusableMethods.listiStringListeDondur(ucuncuSutunWebElementleriList));

  //8-Tablodaki baslikalri yazdirin

    List<WebElement> baslikElementleriList=driver.findElements(By.xpath("//thead/tr/th"));
        System.out.println("Basliklar"+ ReusableMethods.listiStringListeDondur(baslikElementleriList));
        //9- satir ve sutunu parametre olarak alip, hucredeki bilgiyi donduren bir method olusturun

        System.out.println("1.satir,2.sutun"+getCellData(1,2));
        System.out.println("1.satir,2.sutun"+getCellData(2,2));
        System.out.println("1.satir,2.sutun"+getCellData(3,1));
        System.out.println("1.satir,2.sutun"+getCellData(4,3));

        //10- 4.satirdaki category degerinin "Furniture" oldugunu test edin
        //10- 4.satir 2. surundaki datanin  "Furniture" oldugunu test edin
        String expected42="Furniture";
        String actual42=getCellData(4,2);
        Assertions.assertEquals(expected42,actual42);


    }





    public String getCellData(int satirNo, int sutunNo){
        String istenenCellData="";

        //9- satir ve sutunu parametre olarak alip, hucredeki bilgiyi donduren bir method olusturun


        //burda bu konuda veya istekde oluşturulacak method bu class da oluşturulmalı örneğin Reusable classına konulursa
        //sanki diğer web tablolarında da kullaınalack gibi zannedilir ji bu doğru değildir
        //diğer web tablolarının locate leri farklı olabiliri
        // bu method sadece şu ;"https://testotomasyonu.com/webtables"  adresde çalışır

        //    //tr [   4    ]/td[   2   ]

        String dinamikXpath="//tr ["+satirNo+"]/td["+sutunNo+" ]";
        WebElement istenenHucreElementi=driver.findElement(By.xpath(dinamikXpath));
        istenenCellData=istenenHucreElementi.getText();

     return istenenCellData;
    }

}
