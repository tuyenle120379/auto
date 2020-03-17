package selenium.session;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import configuration.SetUp;

public enum DriverPool {
	INSTANCE;

	private WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null) {

			switch (SetUp.getSetup().getBrowser().toUpperCase()) {
			case "FIREFOX":
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("version", "");
				capabilities.setBrowserName("firefox");
				capabilities.setCapability("platform", Platform.WIN10);
				try {
					driver = new RemoteWebDriver(new URL(SetUp.getSetup().getRemoteSlaveNode()), capabilities);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().window().maximize();

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case "CHROME":
				System.setProperty("webdriver.chrome.driver", "");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				try {
					driver = new RemoteWebDriver(new URL(SetUp.getSetup().getRemoteSlaveNode()), cap);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().window().maximize();

				} catch (MalformedURLException e) {
					e.printStackTrace();
				}

				break;

			}
		}
		return driver;
	}

	public void quit() {
		driver.quit();
	}
}
