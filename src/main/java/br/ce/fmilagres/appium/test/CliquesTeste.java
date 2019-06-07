package br.ce.fmilagres.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.CliquesPage;
import br.ce.fmilagres.appium.pages.MenuPage;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Before
	public void setUp() throws MalformedURLException {
		menu.acessarCliques();;
	}
	
	@Test
	public void deveRealizarCliqueLongo() {	
		page.cliqueLongo();		
		
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}

	@Test
	public void deveRealizarCliqueDuplo() {
		//page.clicarPorTexto("Clique duplo");
		//page.clicarPorTexto("Clique duplo");
		
		page.cliqueDuplo();
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}
	
}
