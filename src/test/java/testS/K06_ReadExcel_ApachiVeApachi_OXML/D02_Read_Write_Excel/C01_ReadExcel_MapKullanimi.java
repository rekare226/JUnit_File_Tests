package testS.K06_ReadExcel_ApachiVeApachi_OXML.D02_Read_Write_Excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel_MapKullanimi {


    @Test
            public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1 'e gidin
        String excelDosyaYolu="src/test/java/testS/K06_ReadExcel_ApachiVeApachi_OXML/D02_Read_Write_Excel/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelDosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1=workbook.getSheet("Sayfa1");

    /*
    birden fazla test varsa her seferinde for loop yapmak
    yerine data'lara daha rahat ulasabilecegimiz bir java objesi olan Map' kaydedelim
    ingilizce ulke isimleri ==> key
    turkce baskent isimleri==>value

     */

        Map<String,String> ulkelerMap=new TreeMap<>();

        for (int i = 1; i <=sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi=sayfa1.getRow(i)
                                                    .getCell(0)
                                                    .getStringCellValue();

            String satirdakiTurkceIsmi=sayfa1.getRow(i)
                                            .getCell(3)
                                             .getStringCellValue();

            ulkelerMap.put(satirdakiIngilizceUlkeIsmi,satirdakiTurkceIsmi);


        }

        //Eger Ingilizce ulke isimleri ve Turkce baskent isimleri ile
        //ıngilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

   String expectedBaskentIsmi="Amsterdam";
   String actualBaskentIsmi=ulkelerMap.get("Netherlands") ;
   Assertions.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

   //Turkce baskent isimlerinde Ankara bulundugunu test edin
   Assertions.assertTrue(ulkelerMap.containsValue("Ankara"));

   //Ulkeler excel'inde ingilizce Ghana olan bir ulke var mı
   Assertions.assertTrue(ulkelerMap.containsKey("Ghana"));

   //MAPLER EXCELDE DATA BASE OLARAK KULLANILABİLECEK BİR YAPIDIR EGER BİR
        // DATA BASE İHTİYACIMIZ VARSA JAVA ICINDEKİ EN KULLANIŞLI YAPIDIR MAP








    }



}
