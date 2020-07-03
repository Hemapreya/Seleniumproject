package basedriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Basetest {
	public ExtentHtmlReporter report;
	public ExtentReports extent;//UI design
	public ExtentTest test;//pass or fail
	public static WebDriver driverlaunch(String url) {
		System.setProperty("webdriver.chrome.driver","E:\\selenium driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
	}

	public static void driverquit(WebDriver driver) {
		driver.quit();
	}
	
	@Before
	public void extentreport() {
		
		report=new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser", "chrome");
        
        //configuration items to change the look and feel
        //add content, manage tests etc
        report.config().setChartVisibilityOnOpen(true);
        report.config().setDocumentTitle("Amazon report");//project name
        report.config().setReportName("Test Report");//sanity or regression check report
        report.config().setTestViewChartLocation(ChartLocation.TOP);
        report.config().setTheme(Theme.STANDARD);
        report.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}
	
	@After
	public void endreport() {
		extent.flush();
	}
}
