package testS.K06_ReadExcel_ApachiVeApachi_OXML.D01_ReadExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        /*
        Exceldeki bilgileri kullanabilmek için once
        excel'deki datalara ulaşmamız lazım bilgisayarımızdaki dosyaya
        selenium WebDriver ile ulasamayacagimiz icin  Java dan yardım istemeliyiz

         */

//1. adım dosya yolunu alalım

 String excelDosyaYolu="src/test/java/testS/K06_ReadExcel_ApachiVeApachi_OXML/D02_Read_Write_Excel/ulkeler.xlsx";

 //2. adim java ile dosyaya erişmek için
        FileInputStream fileInputStream=new FileInputStream(excelDosyaYolu);

        //3. adım Excelden alinan bilgileri
        //kodlarımızın icinde olusturacagımız bir obje olarak kaydedelim
        //Workbook workbook=new Workbook();
        //Workbook' is abstract; cannot be instantiated

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //4.adim excel'in kopyasi olan workbook da istediğimiz bilgiye ulaşalım
        //Sayfa1'deki 5. satir, 3.hucrede olan bilgiyi yazdirin

        Sheet sayfa1=workbook.getSheet("Sayfa1");
        Row besinciSatir=sayfa1.getRow(4);
        Cell ucuncuHucre=besinciSatir.getCell(2);

        System.out.println("5. satır 3.cell : "+ucuncuHucre);//5. satır 3.cell : Andorra

        /*
        workbook da Java da genel kabule uygun olarak index kullanılır
        index 0 dan basladigi icin 5. satir icin index==>4,3.hucre icin index==>2 secilmelidir


         */
        //Sayfa1'deki 15.satir, 2.hucrede olan bilgiyi yazdirin
        System.out.println(workbook.getSheet("Sayfa1")
                .getRow(14)
                .getCell(1));//Dhaka

        //son satir numarasini yazidirin
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());//190 index oldugu için 0 başlar
        //java bize son satırın indeksini getirir getirilen satırın numarası değil indeksidir

        //Kullanilan satir sayısını yazdirin
        System.out.println("Kullanilan satir sayisi : "+workbook.getSheet("Sayfa1")
                .getPhysicalNumberOfRows());//

    }





}
