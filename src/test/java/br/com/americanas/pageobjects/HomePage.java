package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void visitar() {
		driver.get("https://www.americanas.com.br/");
	}

	public LoginPage entrar() {
		WebElement facaLogin = driver.findElement(By.id("h_user"));
		facaLogin.click();
		WebElement btnEntrar = driver.findElement(By.className("usr-signin"));
		btnEntrar.click();
		return new LoginPage(driver);
	}

	public boolean validarBotaoMeusPedidos() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("h_user")));
		WebElement usuarioMenu = driver.findElement(By.id("h_user"));
		usuarioMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("usr-orders")));
		return driver.findElement(By.className("usr-orders")).isDisplayed();
	}

	public MeusPedidosPage entrarMeusPedidos() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("h_user")));
		WebElement usuarioMenu = driver.findElement(By.id("h_user"));
		usuarioMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("usr-orders")));
		WebElement meusPedidos = driver.findElement(By.className("usr-orders"));
		meusPedidos.click();
		
		return new MeusPedidosPage(driver);
	}

	public PesquisaPage pesquisarProduto(String termoBusca) {
		WebElement txtBusca = driver.findElement(By.id("h_search-input"));
		txtBusca.sendKeys(termoBusca);
		WebElement btnBusca = driver.findElement(By.className("src-btn"));
		btnBusca.click();
		
		return new PesquisaPage(driver);
		
	}
}
