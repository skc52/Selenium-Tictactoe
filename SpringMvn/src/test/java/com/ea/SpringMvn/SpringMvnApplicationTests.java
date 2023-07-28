package com.ea.SpringMvn;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import static org.testng.Assert.*;

public class SpringMvnApplicationTests {

//	private WebDriver driver;
//
//	@BeforeMethod
//	public void setUp() {
//		// Set up ChromeDriver
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\samip\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		// Close the browser and reset the game state
//		if (driver != null) {
//			driver.quit();
//		}
//		// Reset the game state after each test
//		resetGameState();
//	}
//
//	@Test(threadPoolSize = 3, invocationCount = 3, timeOut = 10000)
//	public void playGameAndWin() {
//		// Open the TicTacToe game page
//		driver.get("http://localhost:8080/game");
//
//		// Perform game actions using Selenium to win the game
//		WebElement cell11 = driver.findElement(By.xpath("//table//tr//td[1]"));
//		cell11.click(); // Player 1's move
//		WebElement cell12 = driver.findElement(By.xpath("//table//tr//td[2]"));
//		cell12.click(); // Player 2's move
//		WebElement cell21 = driver.findElement(By.xpath("//table//tr[2]//td[1]"));
//		cell21.click(); // Player 1's move
//		WebElement cell22 = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
//		cell22.click(); // Player 2's move
//		WebElement cell31 = driver.findElement(By.xpath("//table//tr[3]//td[1]"));
//		cell31.click(); // Player 1's move
//
//		// Verify the game state
//		WebElement winMessage = driver.findElement(By.xpath("//div[@id='msg']"));
//		String messageText = winMessage.getText();
//		boolean hasCongratulations = messageText.contains("Congratulations");
//		assertTrue(hasCongratulations, "Win message should contain 'Congratulations'.");
//	}
//
//	@Test(threadPoolSize = 3, invocationCount = 3, timeOut = 10000)
//	public void playGameAndDraw() {
//		// Open the TicTacToe game page
//		driver.get("http://localhost:8080/game");
//
//		// Perform game actions using Selenium to reach a draw scenario
//		WebElement cell11 = driver.findElement(By.xpath("//table//tr//td[1]"));
//		cell11.click(); // Player 1's move
//		WebElement cell12 = driver.findElement(By.xpath("//table//tr//td[2]"));
//		cell12.click(); // Player 2's move
//		WebElement cell21 = driver.findElement(By.xpath("//table//tr[2]//td[1]"));
//		cell21.click(); // Player 1's move
//		WebElement cell22 = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
//		cell22.click(); // Player 2's move
//		WebElement cell13 = driver.findElement(By.xpath("//table//tr//td[3]"));
//		cell13.click(); // Player 1's move
//		WebElement cell23 = driver.findElement(By.xpath("//table//tr[2]//td[3]"));
//		cell23.click(); // Player 2's move
//		WebElement cell32 = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
//		cell32.click(); // Player 1's move
//		WebElement cell33 = driver.findElement(By.xpath("//table//tr[3]//td[3]"));
//		cell33.click(); // Player 2's move
//		WebElement cell31 = driver.findElement(By.xpath("//table//tr[3]//td[1]"));
//		cell31.click(); // Player 1's move
//
//		// Verify the game state
//		WebElement drawMessage = driver.findElement(By.xpath("//div[@id='msg']"));
//		String messageText = drawMessage.getText();
//		boolean hasDrawMessage = messageText.contains("It's a draw");
//		assertTrue(hasDrawMessage, "Draw message should be displayed.");
//	}
//

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		// Set up ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\samip\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	}

	@AfterMethod
	public void tearDown() {
		// Reset the game state after each test
//		resetGameState();
	}
	@Test(threadPoolSize = 3, invocationCount = 3, timeOut = 10000)
	public void playGameAndWin() {
		// Create a new WebDriver instance for each test case
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open the TicTacToe game page
		driver.get("http://localhost:8080/game");

		// Perform game actions using Selenium to win the game
		WebElement cell11 = driver.findElement(By.xpath("//table//tr//td[1]"));
		cell11.click(); // Player 1's move
		WebElement cell12 = driver.findElement(By.xpath("//table//tr//td[2]"));
		cell12.click(); // Player 2's move
		WebElement cell21 = driver.findElement(By.xpath("//table//tr[2]//td[1]"));
		cell21.click(); // Player 1's move
		WebElement cell22 = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
		cell22.click(); // Player 2's move
		WebElement cell31 = driver.findElement(By.xpath("//table//tr[3]//td[1]"));
		cell31.click(); // Player 1's move



		// Verify the game state
		WebElement winMessage = driver.findElement(By.xpath("//div[@id='msg']"));
		String messageText = winMessage.getText();
		boolean hasCongratulations = messageText.contains("Congratulations");
		assertTrue(hasCongratulations, "Win message should contain 'Congratulations'.");
//

		// Close the browser after the test is finished
		driver.quit();
	}

	private void resetGameState() {
		// Reset the game state by navigating back to the game page
		driver.get("http://localhost:8080/game/reset");
	}
}
