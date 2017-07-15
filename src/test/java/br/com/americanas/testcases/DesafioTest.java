package br.com.americanas.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.americanas.pageobjects.CestaPage;
import br.com.americanas.pageobjects.GarantiaSeguroPage;
import br.com.americanas.pageobjects.HomePage;
import br.com.americanas.pageobjects.LoginPage;
import br.com.americanas.pageobjects.MeusPedidosPage;
import br.com.americanas.pageobjects.MinhaContaPage;
import br.com.americanas.pageobjects.PesquisaPage;
import br.com.americanas.pageobjects.ProdutoPage;

public class DesafioTest {

	private FirefoxDriver driver;
	private HomePage home;
	
	private String produtoTitulo;
	private String precoUnitario;

	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.home = new HomePage(this.driver);
	}

	@Test
	public void preCompra() {
		home.visitar();
		LoginPage loginPage = home.entrar();
		home = loginPage.fazerLogin("i2272559@mvrht.net", "123456");

		assertTrue(home.validarBotaoMeusPedidos());

		MeusPedidosPage meusPedidosPage = home.entrarMeusPedidos();
		assertTrue(meusPedidosPage.validarSemPedidosRecentes());

		MinhaContaPage minhaContaPage = meusPedidosPage.entrarMinhaConta();

		assertTrue(minhaContaPage.validarNomeUsuario());
		assertTrue(minhaContaPage.validarEndereco());

	}

	@Test
	public void selecionarCompra() {
		home.visitar();
		String termoBusca = "Moto G (5ª Geração) Plus 32gb - Platinum";
		PesquisaPage pesquisaPage = home.pesquisarProduto(termoBusca);
		ProdutoPage produtoPage = pesquisaPage.selecionarProduto(termoBusca);
		assertTrue(produtoPage.validarSelecionado(termoBusca));
		assertTrue(produtoPage.validarInformacoesDoProduto());

	}
	
	@Test
	public void realizarCompra(){
		ProdutoPage produtoPage = new ProdutoPage(driver);
		produtoPage.visitar();
		produtoTitulo = produtoPage.getTituloProduto();
		precoUnitario = produtoPage.getPrecoUnitario();
		GarantiaSeguroPage garantiaSeguroPage = produtoPage.comprar();
		assertTrue(garantiaSeguroPage.validarElementosPrincipais());
	}
	
	@Test
	public void preencherCep(){
		this.realizarCompra();
		GarantiaSeguroPage garantiaSeguroPage = new GarantiaSeguroPage(driver);
		CestaPage cestaPage = garantiaSeguroPage.continuar();
		assertTrue(cestaPage.validarProduto(produtoTitulo, precoUnitario));
		cestaPage.inserirCep("15053-025");
		assertTrue(cestaPage.validarEnvio(precoUnitario));
		
	}

}
