package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggerPro {
	// initialize the WebDriver interface reference variable
	public static WebDriver driver;
	// Create Logger class object to initialize the log4j
	// Create reference variable “log” referencing getLogger method of Logger class,
	// it is used to store logs in log file
	public static Logger log = Logger.getLogger("devpinoyLogger");
	//public static Logger log = Logger.getLogger(LoggerPro.class)
				
	public static void main(String[] args) {

		String log4jConfigFile = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\properties\\log4j.properties";
		System.out.println(log4jConfigFile);
		PropertyConfigurator.configure(log4jConfigFile);

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		log.debug("Browser launched");
		driver = new ChromeDriver();
		// Hit the URL for which you want to see logs
		driver.get("https://www.google.co.in/");
		// Call debug method with the help of referencing variable log and log the
		// information in test.logs file
		log.debug("Getting errors");
		driver.manage().window().maximize();
		log.debug("Browser Maximizing");
		driver.quit();

	}
}
