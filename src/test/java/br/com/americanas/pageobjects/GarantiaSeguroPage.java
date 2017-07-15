package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GarantiaSeguroPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public GarantiaSeguroPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validarElementosPrincipais() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("service-flow--title")));
		return driver.findElement(By.className("installment-description-default")).isDisplayed()
				&& driver.findElement(By.className("service-flow--title")).isDisplayed() && driver.getPageSource()
						.contains("Agora que você já escolheu seu produto, saiba como protegê-lo por mais tempo.");
	}

	public CestaPage continuar() {
		WebElement btnContinuar = driver.findElement(By.className("btn-buy"));
		btnContinuar.click();
		return new CestaPage(driver);

	}

}
