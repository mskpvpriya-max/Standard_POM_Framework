package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public Properties prop;

    @BeforeMethod
    public void setUp() throws IOException {
        // 1. Read config.properties via FileInputStream
        prop = new Properties();
        //FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        prop.load(input);

        // 2. Initialize Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Navigate to URL from properties file
        String url = prop.getProperty("url");
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
