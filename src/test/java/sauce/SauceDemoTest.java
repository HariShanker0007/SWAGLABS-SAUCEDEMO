package sauce;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basePack.Baseclass;
import genutil.ExcelUtility;
import objRepo.InfoPage;
import objRepo.SauceProdPage;


//@Listeners(basePack.Listeners.class)

public class SauceDemoTest extends Baseclass {

	@Test
	public void add2Prod() throws Throwable {

		ExcelUtility elib = new ExcelUtility();

		String FN = elib.toReadDataFromExcelFile("Info", 0, 1);
		String LN = elib.toReadDataFromExcelFile("Info", 1, 1);
		String ZIP = elib.toReadDataFromExcelFile("Info", 2, 1);

		SauceProdPage spp = new SauceProdPage(driver);
		spp.addProd2toCart();
		
		driver.findElement(By.id("checkout")).click();

		InfoPage ip = new InfoPage(driver);
		ip.details(FN, LN, ZIP);
		driver.findElement(By.id("finish")).click();
	}

	@Test
	public void add4Prod() throws Throwable {

		ExcelUtility elib = new ExcelUtility();

		String FN = elib.toReadDataFromExcelFile("Info", 0, 1);
		String LN = elib.toReadDataFromExcelFile("Info", 1, 1);
		String ZIP = elib.toReadDataFromExcelFile("Info", 2, 1);

		SauceProdPage spp = new SauceProdPage(driver);
		spp.addProd4toCart();

		driver.findElement(By.id("checkout")).click();

		InfoPage ip = new InfoPage(driver);
		ip.details(FN, LN, ZIP);

		driver.findElement(By.id("finish")).click();
	}

	@Test
	public void add6Prod() throws Throwable {

		ExcelUtility elib = new ExcelUtility();

		String FN = elib.toReadDataFromExcelFile("Info", 0, 1);
		String LN = elib.toReadDataFromExcelFile("Info", 1, 1);
		String ZIP = elib.toReadDataFromExcelFile("Info", 2, 1);

		SauceProdPage spp = new SauceProdPage(driver);
		spp.addProd6toCart();

		driver.findElement(By.id("checkout")).click();

		InfoPage ip = new InfoPage(driver);
		ip.details(FN, LN, ZIP);

		driver.findElement(By.id("finish")).click();
	}
}
