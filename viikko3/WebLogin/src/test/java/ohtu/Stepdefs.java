package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @Then("nonexistent user is not logged in and error message is given")
    public void nonexistentUserIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
    }   
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        createWith(username, password, password);
    }
    
    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @When("a invalid username {string} and password {string} and matching password confirmation are entered")
    public void aInvalidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        createWith(username, password, password);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String errorMessage) {
        pageHasContent(errorMessage);
    }
    
    @When("a valid username {string} and invalid password {string} and matching password confirmation are entered")
    public void aValidUsernameAndInvalidPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        createWith(username, password, password);
    }
    
    @When("a valid username {string} and password {string} and matching password {string} confirmation are ented")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEnted(String username, String password1, String password2) {
        createWith(username, password1, password2);
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String username, String password) {
        commandNewUserIsSelected();
        createWith(username, password, password);
    }

    @When("correct username {string} with password {string} are given")
    public void correctUsernameWithPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    
    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
        commandNewUserIsSelected();
        createWith(username, password, password);
    }

    @When("username {string} with password {string} are given")
    public void usernameWithPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void createWith(String username, String password, String passwordConfirmation) {
        pageHasContent("Create username and give password");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element.submit(); 
    }

}
