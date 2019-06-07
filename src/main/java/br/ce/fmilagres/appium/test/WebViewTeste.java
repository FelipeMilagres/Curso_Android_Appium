package br.ce.fmilagres.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.MenuPage;
import br.ce.fmilagres.appium.pages.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		//acessar menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("felipe@teste.com.br");
		
		//senha
		page.setSenha("teste");
		
		//entrar
		page.entrar();
		
		//verificar
		Assert.assertEquals("Bem vindo, Felipe!", page.getMensagem());		
	}
	
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}

}
