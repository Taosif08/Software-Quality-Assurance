package final_sameen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class edge {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Login Page
            driver.get("https://hachnat.stage-carelogix.de/sign-in");
            
            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for Username, Password, and Login button to be visible
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credential")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-btn")));

            // Enter login credentials and click the login button
            username.sendKeys("taosif@yopmail.com");
            password.sendKeys("Carelogix24!!");
            loginButton.click();

            // Wait for the next page to load
            Thread.sleep(6000);

            // Step 1: Click on the "Task" button
            WebElement taskButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/header/div/div[2]/nav/div[2]/div[3]/a")));
            taskButton.click();

            // Step 2: Click on the "Add New Column" button
            WebElement addNewColumnButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/main/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[2]/button")));
            addNewColumnButton.click();

            // Step 3: Enter the column name
            WebElement columnNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/form/div[1]/div/div[2]/div/div/input")));
            columnNameInput.sendKeys("New Column Name 1");

            // Step 4: Click on the "Create" button
            WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/button")));
            createButton.click();

            // Step 5: Click on the "Profile" button
            WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/header/div/div[3]/div[2]/a/div")));
            profileButton.click();

            // Step 6: Logout
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/header/div/div[3]/div[2]/div/button")));
            logoutButton.click();
            System.out.println("User logged out successfully!");

        } catch (Exception e) {
            // Print detailed error information
            System.err.println("An error occurred during the test:");
            e.printStackTrace();
        } finally {
            // Close the WebDriver properly
            driver.quit();
            System.out.println("Browser closed successfully!");
        }
    }
}
