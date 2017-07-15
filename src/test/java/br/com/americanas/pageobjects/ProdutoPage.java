package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public ProdutoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visitar(){
		driver.get("https://www.americanas.com.br/produto/23060588/moto-g-5-geracao-plus-32gb-platinum");
	}

	public boolean validarSelecionado(String termoBusca) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-name")));
		WebElement tituloProduto = driver.findElement(By.className("product-name"));
		return termoBusca.equals(tituloProduto.getText());
	}

	public boolean validarInformacoesDoProduto() {	
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-name")));
		// Contem o iframe de descrição do produto
		return driver.getPageSource().contains("/product-description/acom/23060588");
	}

	public GarantiaSeguroPage comprar() {
		WebElement btnComprar = driver.findElement(By.id("bt-buy-product"));
		btnComprar.click();
		
		return new GarantiaSeguroPage(driver);
		
	}

	public String getTituloProduto() {
		WebElement nomeProduto = driver.findElement(By.className("product-name"));
		return nomeProduto.getText();
		
	}

	public String getPrecoUnitario() {
		WebElement preco = driver.findElement(By.className("sales-price"));
		return preco.getText();
	}

}
