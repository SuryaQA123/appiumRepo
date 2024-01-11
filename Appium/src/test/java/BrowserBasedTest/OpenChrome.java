package BrowserBasedTest;
import org.testng.annotations.Test;
public class OpenChrome  extends Browser_base{
    @Test
    public  void launchChrome()throws Exception{
        driver.get("https://www.bbc.com/");
    }
}
