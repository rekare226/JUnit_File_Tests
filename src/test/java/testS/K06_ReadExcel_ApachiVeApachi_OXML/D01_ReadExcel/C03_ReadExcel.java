package testS.K06_ReadExcel_ApachiVeApachi_OXML.D01_ReadExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1'e gidin
        String excelDosyaYolu="src/test/java/testS/K06_ReadExcel_ApachiVeApachi_OXML/D02_Read_Write_Excel/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelDosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1=workbook.getSheet("Sayfa1");
        //1. satirdaki 2. hucreye gidin yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1));

        //1.satirdaki 2.hucreye bir string degiskene atayin
        String satir1Hucre2=sayfa1.getRow(0).getCell(1).getStringCellValue();
        // ve degerin "Baskent (İngilizce)" oldugunu test edin
         String expectedHucreBilgisi="Başkent (İngilizce)";
        Assertions.assertEquals(expectedHucreBilgisi,satir1Hucre2);

        //2.satir 4.cell'in afganistan'in baskenti "Kabil" oldugunu test edin
        String satir2Hucre4=sayfa1.getRow(1).getCell(3).getStringCellValue();
        String expectedsatir2Hucre4Bilgisi="Kabil";
        Assertions.assertEquals(expectedsatir2Hucre4Bilgisi,satir2Hucre4);

        // Ulke sayisinin 190 oldugunu test edin
         int actualUlkesayisi=sayfa1.getLastRowNum()+1-1;
         /*
         +1 method bize index getiriyor,satir sayisini bulmak icin +1 ekliyoruz
         -1 basta BASLIK satiri oldugundan satir sayısından 1 cikartarak ulke sayisini bulabiliriz
          */
         int expectedUlkeSayisi=190;
         Assertions.assertEquals(actualUlkesayisi,expectedUlkeSayisi);

    //Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        int fizikiSatirsayisi=sayfa1.getPhysicalNumberOfRows();
        int expectedSatirsayisi=191;
        Assertions.assertEquals(fizikiSatirsayisi,expectedSatirsayisi);

 //ingilizce ismi NetherLands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

 /*
 butun satirlari tek tek kontrol edip o indeksteki data Netherlands
 ise 3. index'deki data'nin Amsterdam oldugunu test edin
  */
        String expectedBaskentIsmi="Amsterdam";
        for (int i = 0; i < sayfa1.getLastRowNum(); i++) {

            String satirdakiUlkeIsmi=sayfa1.getRow(i).getCell(0).getStringCellValue();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Netherlands")){

                String satirdakiTurkcebaskentIsmi=sayfa1.getRow(i).getCell(3).getStringCellValue();
                Assertions.assertEquals(satirdakiTurkcebaskentIsmi,expectedBaskentIsmi);
                break;
            }

        }
//Turkce baskent isimlerinde Ankara bulundugunu test edin
//Turkce baskent isimleri her satirin 3.index'inde
//bir flag olusturup, her satirdaki baskent ismini kontrol edelim
//Ankara olan varsa flag i değiştirielim

  String expectedBaskentTurkce="Ankara";
  boolean ankaraVarmi=false;
        for (int i = 1; i <= sayfa1.getLastRowNum(); i++) {

            String satirdakibBaskentısmiTurkce=sayfa1.getRow(i)
                                                     .getCell(3)
                                                      .getStringCellValue();

            if (satirdakibBaskentısmiTurkce.equalsIgnoreCase(expectedBaskentTurkce)){

                ankaraVarmi=true;
                break;
            }


        }
      Assertions.assertTrue(ankaraVarmi);



    }
}
