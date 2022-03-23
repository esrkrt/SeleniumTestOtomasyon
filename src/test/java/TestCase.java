
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase {
@Test

    public  void doTestCase(){
        System.setProperty("webdriver.gecko.driver","Drivers/geckodriver.exe");
        WebDriver webDriver=new FirefoxDriver();
        webDriver.get("http://www.iett.istanbul/");
        WebElement searchbox= webDriver.findElement(By.id("select2-searchShortcutsLine-container"));
        searchbox.click();
        WebElement fillSearchbox=webDriver.findElement(By.className("select2-search__field"));
        fillSearchbox.sendKeys("522");
        WebDriverWait  webDriverWait= new WebDriverWait(webDriver,3);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("select2-results__option"),
                webDriver.findElement(By.className("select2-results__option")).getText()));
        List<WebElement> searchResults=webDriver.findElements(By.className("select2-results__option"));
        searchResults.get(0).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button--success")));
        WebElement allİnfos=webDriver.findElement(By.className("button--success"));
        allİnfos.click();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement stations=webDriver.findElement((By.cssSelector("a[href*='#LineStation']")));
        stations.click();

        webDriver.quit();


}
}
