package br.ce.fmilagres.appium.test;

import org.junit.Assert;
import org.junit.Test;
import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.MenuPage;
import br.ce.fmilagres.appium.pages.SwipeListPage;

public class SwipeElementTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();	
	private SwipeListPage page = new SwipeListPage();
	
	@Test
	public void deveResolverDesafio() {
		
		menu.acessarSwipeList();	
		page.swipeElementRight("Op��o 1");	
		page.clicarBotaoMais();
				
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));
		
		page.swipeElementRight("Op��o 4");		
		page.clicarPorTexto("(-)");
		
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 4 (-)"));
		
		page.swipeElementLeft("Op��o 5");			
			
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 5"));
	}
	
}
