package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CestaPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CestaPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validarProduto(String produtoTitulo, String precoUnitario) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("media-heading")));
		WebElement lblPreco = driver.findElement(By.xpath("//*[@id='app']/section/article/div[1]/section/article/ul/li/ul/li[6]/span"));
		WebElement produto = driver.findElement(By.className("media-heading"));
		return produto.isDisplayed() && lblPreco.getText().equals(precoUnitario);
	}

	public void inserirCep(String cep) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cep")));
		WebElement txtCep = driver.findElement(By.id("cep"));
		txtCep.sendKeys(cep);
		WebElement btnOk = driver.findElement(By.id("calculate-freight-button"));
		btnOk.click();
		
	}

	public boolean validarEnvio(String precoUnitario) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/section/article/div[2]/div[1]/div/ul/li/div/label/span[5]")));
		WebElement lblValorTotal = driver.findElement(By.id("total-amount"));
				
		return !driver.getPageSource().contains("Frete (?):") && !lblValorTotal.getText().equals(precoUnitario);
	}

}
