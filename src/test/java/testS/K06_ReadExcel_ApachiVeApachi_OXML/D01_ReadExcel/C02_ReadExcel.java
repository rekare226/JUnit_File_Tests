package testS.K06_ReadExcel_ApachiVeApachi_OXML.D01_ReadExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

  @Test
  public void test01() throws IOException {

  //Gerekli ayarlamalari yapip, ulkeler excel'indeki sayfa2'ye gidin

      String excelDosyaYolu="src/test/java/testS/K06_ReadExcel_ApachiVeApachi_OXML/D02_Read_Write_Excel/ulkeler.xlsx";
      FileInputStream fileInputStream=new FileInputStream(excelDosyaYolu);
      Workbook workbook= WorkbookFactory.create(fileInputStream);
      Sheet sayfa2=workbook.getSheet("Sayfa2");


  //Kullanilan son satirin 20. satir oldugunu test edin

      int kullanilanSonSatir=sayfa2.getLastRowNum()+1; //indeks kullandıgından 1 ekliyoruz
      int expectedsonSatirNo=20;

      Assertions.assertEquals(kullanilanSonSatir,expectedsonSatirNo);


  //Kullanilan (bos birakilmayan,fiziki) satir sayisinin 8 oldugunu test edin

      int kullanilanSatirsayısı=sayfa2.getPhysicalNumberOfRows();
      int expectedKullanilanSatirSayisi=8;
      Assertions.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirsayısı);


  //17. satir 5. hucredeki bilgiyi yazdirin
  //satir var ama istenen hucrede bilgi yok

      System.out.println(sayfa2.getRow(16).getCell(4)); //satır var olup istenen hucrede bilgi olamdığı için null yazdırır


      //5. satir 3.hucredeki bilgiyi yazdirin
      System.out.println(sayfa2.getRow(4).getCell(2)); //boş bir satırda null getirir null dan bilgi istediğimiz içinde
      //NullPointException firlatır


  }










}
