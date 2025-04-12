package testS.K01_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileTests extends TestBase_Each {

    @Test
    public void test01() {
        //1- https://www.testotomasyonu.com adresine gidelim
  // driver.get("https://www.testotomasyonu.com");

   //bu konudun amacı dosya yolu kaydedilen dosyanın var olup olmadıgını bulmaktır
//K01 package'i altinda deneme.txt dosyasinin var oldugunu test edin

        String dosyaYoluDeneme="src/test/java/testS/K01_fileTestleri/deneme.txt";
        System.out.println(Files.exists(Paths.get(dosyaYoluDeneme)));//true
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYoluDeneme)));

//K01 package 'i altinda deneme1.txt dosyasinin
        //var olmadiğini test edin

        String dosyaYoluDeneme1="src/test/java/testS/K01_fileTestleri/deneme1.txt";
        System.out.println(Files.exists(Paths.get(dosyaYoluDeneme1)));
       Assertions.assertFalse(Files.exists(Paths.get(dosyaYoluDeneme1)));


       //dowlands klasorunde deneme.txt dosyasinin var oldugunu test edin

        String dosyaYoluDowlandsDeneme="C:\\Users\\aydin\\Downloads\\deneme.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYoluDowlandsDeneme)));

    }

}
