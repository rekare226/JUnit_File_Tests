package testS.K01_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.PatternSyntaxException;

public class C02_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){
    //dowlands klasorunde deneme.txt dosyasının varlıgını test edin
    String dosyaYoluDownloadDeneme="C:\\Users\\aydin\\Downloads\\deneme.txt";


        System.out.println(System.getProperty("user.home")); //C:\Users\aydin

        String dinamikDownloadDosyaYolu=System.getProperty("user.home")+"\\Downloads\\deneme.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dinamikDownloadDosyaYolu)));

        //K15 package'i altinda deneme.txt dosyasinin
        //var oldugunu test edin

        String dosyaYoluProjedekiDeneme="C:\\Users\\aydin\\IdeaProjects\\FileExists\\src\\test\\java\\testS\\K01_fileTestleri\\deneme.txt";
        System.out.println(System.getProperty("user.dir")); //C:\Users\aydin\IdeaProjects\FileExists

        String dinamnikDosyaYoluProjedekiDeneme=System.getProperty("user.dir")+"\\src\\test\\java\\testS\\K01_fileTestleri\\deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamnikDosyaYoluProjedekiDeneme)));





    }
}
