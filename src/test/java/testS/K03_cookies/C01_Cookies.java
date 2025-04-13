package testS.K03_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBase_Each;

import java.util.Set;
import java.util.logging.SocketHandler;

public class C01_Cookies extends TestBase_Each {

    @Test
    public void test01(){


     //Google anasayfaya gidin
        driver.get("https://google.com");

     //cookies cikarsa kabul edin
        // driver.findElement(By.xpath("//div[.='Accept all'")); cookie çikmadi
        // çikmadiği içinde locate yapamadı ve InvalidSelectorException hatasi verdi

     //sayafada kaç adet cookies bulundugunu yazdirin

        Set<Cookie> sayfadakiCookieSeti=driver.manage().getCookies();
        System.out.println("sayfadaki cookie sayisi"+sayfadakiCookieSeti.size());


     //sayfadaki cookie'leri yazdirin
        System.out.println(sayfadakiCookieSeti);
     //daha anlaşilılr olmasi foor each loop ile yazdıralım
        System.out.println("================================================0");
     int siraNo=1;
     for ( Cookie eachCookie
              :sayfadakiCookieSeti ) {

         System.out.println(siraNo+".cookie"+eachCookie);
         siraNo++;
        }


     //cookielerin isimlerini yazdirin
        System.out.println("=============================");
         siraNo=1;
        for ( Cookie eachCookie
                :sayfadakiCookieSeti ) {

            System.out.println(siraNo+".cookie ismi: "+eachCookie.getName());
            siraNo++;
        }




        //ismi OGPC olan cookilerin degerinin
        //AVcja2e9Xii6EsbZLabJOOXPV8Lv-ozMMe-vqYOEPRZlkJcDSnMzk8sCd6Q

        String expectedValueOgpc="19046228-1:";

        //AVcja2d0q9A4wrfwSmylwygYiJ-2_7DRM6i-5E6IpdlYBPQMsxJ5gjNzXD0
        String actualValueOgpc=driver.manage().getCookieNamed("OGPC").getValue();
        Assertions.assertEquals(expectedValueOgpc,actualValueOgpc);

        //ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup
        //sayfaya ekleyin
        Cookie yeniCookie=new Cookie("enSevdigimCookie","cikolataliCookie");
        driver.manage().addCookie(yeniCookie);
        sayfadakiCookieSeti=driver.manage().getCookies();

        siraNo=1;
        for ( Cookie eachCookie
                :sayfadakiCookieSeti ) {

            System.out.println(siraNo+".cookie"+eachCookie);
            siraNo++;
        }

//cookiye ekleyebildiğimizi test edin

        Assertions.assertTrue(sayfadakiCookieSeti.contains(yeniCookie));

        //ismi OGPC olan cookiyi silin ve silkinidğini test edin
        driver.manage().deleteCookieNamed("OGPC");
        System.out.println("==================================");
        sayfadakiCookieSeti=driver.manage().getCookies();

        siraNo=1;
        for ( Cookie eachCookie
                :sayfadakiCookieSeti ) {

            System.out.println(siraNo+".cookie"+eachCookie);
            siraNo++;
        }

        boolean OgpcVarmi=false;
        for (Cookie eachCookie :sayfadakiCookieSeti   ) {

            if (eachCookie.getName().equalsIgnoreCase("OGPC")){

                OgpcVarmi=true;
            }
        }

        Assertions.assertFalse(OgpcVarmi);

        driver.manage().deleteAllCookies();
        sayfadakiCookieSeti=driver.manage().getCookies();
        Assertions.assertEquals(0,sayfadakiCookieSeti.size());

    }





}
