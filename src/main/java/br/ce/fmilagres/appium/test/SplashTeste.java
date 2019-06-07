package br.ce.fmilagres.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.MenuPage;
import br.ce.fmilagres.appium.pages.SplashPage;


public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage(); 
	private SplashPage page = new SplashPage();

	@Test
	public void deveAguardarSplashSumir() {
		//acessar menu splash
		menu.acessarSplash();
		
		//verificar que o splash est� sendo exibido
		page.isTelaSplashVisivel();
		
		
		//aguardar saida do splash
		page.aguardarSplashSumir();
		
		//verificar que o formul�rio est� sendo exibido
		Assert.assertTrue(page.existeElementoPorTexto("Formul�rio"));
	}
}
