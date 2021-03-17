import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javatests {
    private WebDriver webDriver;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://savkk.github.io/selenium-practice/");
    }

    @Test
    public void firstTask(){
        WebElement firstTask =webDriver.findElement(By.id("button"));
        firstTask.click();
        WebElement firstClickMe= webDriver.findElement(By.id("first"));
        firstClickMe.click();
        WebElement resultFirstClicMe = webDriver.findElement(By.xpath(".//label[text()='Excellent!']"));
        Assert.assertEquals("Excellent!",resultFirstClicMe.getText());
        WebElement buttonClicMeTo = webDriver.findElement(By.xpath("//input[@type='button']"));
        buttonClicMeTo.click();
        WebElement returnFirstClicMe = webDriver.findElement(By.linkText("Great! Return to menu"));
        Assert.assertEquals("Great! Return to menu",returnFirstClicMe.getText());
        returnFirstClicMe.click();
    }
    @Test
    public void SecondTask() {
        WebElement secondTask = webDriver.findElement(By.id("checkbox"));
        secondTask.click();
        WebElement CheckBoxOne = webDriver.findElement(By.xpath("//*[@id='one']"));
        WebElement CheckboxTwo = webDriver.findElement(By.xpath("//*[@id='two']"));
        WebElement CheckboxThree = webDriver.findElement(By.xpath("//*[@id='three']"));
        WebElement RadioButtonOne = webDriver.findElement(By.id("radio_one"));
        WebElement ButtonGetResult = webDriver.findElement(By.id("radio_go"));
        CheckBoxOne.click();
        WebElement buttonCheckBox = webDriver.findElement(By.id("go"));
        buttonCheckBox.click();
        WebElement resultCheckBox = webDriver.findElement(By.id("result"));
        Assert.assertEquals("one", resultCheckBox.getText().trim());
        CheckboxTwo.click();
        buttonCheckBox.click();
        Assert.assertEquals("one two", resultCheckBox.getText().trim());
        CheckboxThree.click();
        buttonCheckBox.click();
        Assert.assertEquals("one two three", resultCheckBox.getText().trim());
        RadioButtonOne.click();
        ButtonGetResult.click();
        WebElement RadioResult = webDriver.findElement(By.id("radio_result"));
        Assert.assertEquals("one",RadioResult.getText());
        WebElement returnFirstClicMe = webDriver.findElement(By.linkText("Great! Return to menu"));
        Assert.assertEquals("Great! Return to menu",returnFirstClicMe.getText());
        returnFirstClicMe.click();
    }
    @After
    public void teardown () throws InterruptedException {
        Thread.sleep(5000);
        if (webDriver !=null){
            webDriver.quit();
        }
    }


}
