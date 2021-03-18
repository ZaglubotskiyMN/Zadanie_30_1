import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class javatests {
    private WebDriver webDriver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://savkk.github.io/selenium-practice/");
    }

    @Test
    public void firstTask() {
        WebElement firstTask = webDriver.findElement(By.id("button"));
        firstTask.click();
        WebElement firstClickMe = webDriver.findElement(By.id("first"));
        firstClickMe.click();
        WebElement resultFirstClicMe = webDriver.findElement(By.xpath(".//label[text()='Excellent!']"));
        Assert.assertEquals("Excellent!", resultFirstClicMe.getText());
        WebElement buttonClicMeTo = webDriver.findElement(By.xpath("//input[@type='button']"));
        buttonClicMeTo.click();
        WebElement returnFirstClicMe = webDriver.findElement(By.linkText("Great! Return to menu"));
        Assert.assertEquals("Great! Return to menu", returnFirstClicMe.getText());
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
        Assert.assertEquals("one", RadioResult.getText());
        WebElement returnFirstClicMe = webDriver.findElement(By.linkText("Great! Return to menu"));
        Assert.assertEquals("Great! Return to menu", returnFirstClicMe.getText());
        returnFirstClicMe.click();
    }

    @Test
    public void ThirdTask() {
        WebElement ThirdTask = webDriver.findElement(By.id("select"));
        ThirdTask.click();
        WebElement hero = webDriver.findElement(By.name("hero"));
        Select heroSelect = new Select(hero);
        heroSelect.selectByVisibleText("John von Neumann");
        WebElement languages = webDriver.findElement(By.name("languages"));
        Select languagesSelect = new Select(languages);
        if (languagesSelect.isMultiple()) {
            languagesSelect.selectByVisibleText("Java");
            languagesSelect.selectByVisibleText("Python");
            languagesSelect.selectByVisibleText("C++");
        } else languagesSelect.selectByVisibleText("Java");
        WebElement buttonSelectResult = webDriver.findElement(By.id("go"));
        buttonSelectResult.click();
        WebElement result = webDriver.findElement(By.xpath("//label[@name = 'result'][last()]"));
        if (languagesSelect.isMultiple()) {
            Assert.assertEquals("Java, Python, C++", result.getText());
        } else
            Assert.assertEquals("Java", result.getText());
        WebElement returnFirstClicMe = webDriver.findElement(By.linkText("Great! Return to menu"));
        returnFirstClicMe.click();
    }

    @Test
    public void Fourthtask() {
        WebElement formclick = webDriver.findElement(By.id("form"));
        formclick.click();
        inputdata("First Name:","Ivan");
        inputdata("Last Name:","Ivanov");
        inputdata("Email:","123@gmail.com");
        inputdata("Address:","Samara");
        inputdata("Avatar:", "C:\\Users\\Заглубоцкие\\IdeaProjects\\Zadanie_30_1\\javaphoto.jpg");
        WebElement inputtext = webDriver.findElement(By.xpath(".//label[text()='Tell me something about yourself']//following::textarea"));
        inputtext.sendKeys("very good");
        WebElement submit = webDriver.findElement(By.xpath("//*[contains(@type,'submit')]"));
        submit.submit();
        WebElement returnFirstClicMe = webDriver.findElement(By.linkText("Great! Return to menu"));
        returnFirstClicMe.click();
        //inputdatasex("Sex:","Male");---- уточнить

    }

    private void inputdata(String labeltext, String value){
        WebElement input = webDriver.findElement(By.xpath(".//label[text()='"+labeltext+"']//following::input"));
        input.sendKeys(value);
    }
    /*private  void inputdatasex(String labeltext,String value){
        WebElement input = webDriver.findElement(By.xpath(".//label[text()='"+ labeltext +"']//following::input"));
    }*/





    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        if (webDriver != null) {
            webDriver.quit();
        }
    }


}
