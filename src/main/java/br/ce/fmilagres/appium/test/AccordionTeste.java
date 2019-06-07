package br.ce.fmilagres.appium.test;

import org.junit.Assert;
import org.junit.Test;
import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.AccordionPage;
import br.ce.fmilagres.appium.pages.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
	
		//Acessar menu Accordion
		menu.acessarAccordion();
		
		//Acessar opção 1
		page.selecionarOpcao1();
				
		//verificar que aba opção 1
		esperar(1000);
		Assert.assertTrue(page.isOpcao1());
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOpcao1());
	}
}
