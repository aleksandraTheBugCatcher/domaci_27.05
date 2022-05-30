//Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, prisisnuti dugme.
//Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje.
// Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
//Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.stealmylogin.com/demo.html");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Aleksandra");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("domaci2705");

        driver.findElement(By.xpath("/html/body/form/input[3]")).click();

        try {
            URL loginUrl = new URL("https://www.stealmylogin.com/demo.html");
            URL exampleUrl = new URL("https://example.com/");
            if(loginUrl.equals(exampleUrl)){
                System.out.println("Nice");
            } else {
                System.out.println("Not nice");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }





    }
}
