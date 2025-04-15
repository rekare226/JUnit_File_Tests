package testS.K06_ReadExcel_ApachiVeApachi_OXML.D02_Read_Write_Excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1 'e gidin
        String excelDosyaYolu="src/test/java/testS/K06_ReadExcel_ApachiVeApachi_OXML/D02_Read_Write_Excel/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelDosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1=workbook.getSheet("Sayfa1");

  //1. satir 5. hucreye yeni bir cell olusturalım
  sayfa1.getRow(0).createCell(4);

  //Oluştrudugumuz hucreye "Nufus" yazdiralım
        sayfa1.getRow(0).createCell(4).setCellValue("Nufus");


  //2. satir nufus kolonuna 1500000 yazdiralım

       sayfa1.getRow(1).getCell(4).setCellValue(1500000);

  //10. satir nufus kolonuna 250000 yazdiralım
        sayfa1.getRow(9).createCell(4).setCellValue(250000);

  //15.satir nufus kolonuna 54000 yazdiralım

  sayfa1.getRow(14).createCell(4).setCellValue(54000);



        //bos olan ilk satira
        //ingilizce ulke ismi javaRepublic ingilizce baskent olarak Selenium yazdiralım

        //burada ilk olarak boş satırı bulmamız lazım

        int ilkBossatirIndex= sayfa1.getLastRowNum()+1;
        sayfa1.createRow(ilkBossatirIndex);
        sayfa1.getRow(ilkBossatirIndex).createCell(0).setCellValue("javaRepublic");
        sayfa1.getRow(ilkBossatirIndex).getCell(1).setCellValue("Selenium");

  //dosyayı kaydedelim ve kaydetmeden önce excel dosyası kapalı olsun
        // yani başka bir pencere de açık olmasın

        FileOutputStream fileOutputStream=new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);

        //dosyayı kapatalım

        //profesyoennlik anlamında fiel ınptlar kapatılır

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();






    }






}
