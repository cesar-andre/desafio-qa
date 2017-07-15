package br.com.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver webdriver){
		this.driver = webdriver;
	}

	public HomePage fazerLogin(String email, String senha) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		
		WebElement txtEmail = driver.findElement(By.name("email"));
		WebElement txtSenha = driver.findElement(By.name("password"));
		
		txtEmail.sendKeys(email);
		txtSenha.sendKeys(senha);
		
		WebElement btnContinuar = driver.findElement(By.name("submit_button"));
		btnContinuar.click();
		
		
		return new HomePage(driver);
		
	}

}
