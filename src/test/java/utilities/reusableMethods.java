package utilities;

public class reusableMethods {

    public static void  bekle(int saniye){

   try {

       Thread.sleep(saniye*1000);
   }
    catch (InterruptedException e){

        System.out.println("Thread.sleep komutu calismadi");

    }

    }

}
