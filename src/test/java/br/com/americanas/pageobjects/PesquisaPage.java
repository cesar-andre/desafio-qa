package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PesquisaPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public PesquisaPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProdutoPage selecionarProduto(String termoBusca) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='" + termoBusca + "']")));
		WebElement produto = driver.findElement(By.xpath("//*[@title='" + termoBusca + "']"));
		produto.click();
		
		return new ProdutoPage(driver);
		
	}

}
