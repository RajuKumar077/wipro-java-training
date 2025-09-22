package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reporter {

	// Method to log test steps and attach screenshots
	public static void generateReport(WebDriver driver, ExtentTest test, Status status, String stepMessage) {
		File screenshotFile = captureScreenshot(driver, stepMessage);
		if (screenshotFile != null) {
			String absolutePath = screenshotFile.getAbsolutePath().replace("\\", "/"); // Convert to forward slashes
			String fileUrl = "file:///" + absolutePath;
			test.log(status, stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(fileUrl).build());
		} else {
			test.log(status, stepMessage + " (Screenshot capture failed)");
		}
	}

	// Method to capture screenshots
	public static File captureScreenshot(WebDriver driver, String stepName) {
		String userDir = System.getProperty("user.dir") + File.separator + "screenshots";

		// Create screenshots directory if it doesn't exist
		File screenshotDir = new File(userDir);
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
		}

		// Timestamp for unique screenshot names
		String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
		String filePath = userDir + File.separator + stepName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp
				+ ".png";

		// Take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		try {
			FileUtils.copyFile(srcFile, destFile);
			return destFile; // Return the actual file to use its absolute path
		} catch (IOException e) {
			System.out.println("Screenshot capture failed: " + e.getMessage());
			return null;
		}
	}
}
