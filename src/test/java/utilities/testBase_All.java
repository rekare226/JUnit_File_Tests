package utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class testBase_All {

  protected static WebDriver driver;
  @BeforeAll
  public static void setUp(){

      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }

  @AfterAll
  public static void tearDown(){
  driver.quit();

  }


}
