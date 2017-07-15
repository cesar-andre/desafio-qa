package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeusPedidosPage {

	private WebDriver driver;
	
	public MeusPedidosPage(WebDriver driver){
		this.driver = driver;
	}

	public boolean validarSemPedidosRecentes() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("order-empty")));
		
		return driver.getPageSource().contains("Período sem pedidos.");
	}

	public MinhaContaPage entrarMinhaConta() {
		WebElement usuarioMenu = driver.findElement(By.id("h_user"));
		usuarioMenu.click();
		
		WebElement meusPedidos = driver.findElement(By.className("usr-account"));
		meusPedidos.click();
		
		return new MinhaContaPage(driver);
		
	}
	
}
