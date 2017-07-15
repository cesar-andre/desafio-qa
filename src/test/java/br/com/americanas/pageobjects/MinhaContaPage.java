package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinhaContaPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MinhaContaPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validarNomeUsuario() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("adress-name")));

		return driver.getPageSource().contains("Teste Cesar");
	}

	public boolean validarEndereco() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("adress-name")));
		
		return driver.getPageSource().contains("Rua Aureli José Nunes, 1000")
				&& driver.getPageSource().contains("15053-025 - Jardim do Bosque")
				&& driver.getPageSource().contains("São José do Rio Preto/SP");
		
	}

}
