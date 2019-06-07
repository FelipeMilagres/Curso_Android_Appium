package br.ce.fmilagres.appium.test;

import org.junit.Assert;
import org.junit.Test;
import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.MenuPage;

public class SwipeTeste extends BaseTest {

	private MenuPage menu = new MenuPage();

	@Test
	public void deveRealizarSwipe() {

		// acessar menu
		menu.acessarSwipe();

		// verificar texto a esquerda
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		// swipe para direita
		menu.swipeRight();

		// verificar texto 'E veja se consegue
		Assert.assertTrue(menu.existeElementoPorTexto("você consegue"));

		// clicar botão direita
		menu.clicarPorTexto("›");

		// verificar o texto 'Chegar até o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		// swipe esquerda
		menu.swipeLeft();

		// clicar botão esquerda
		menu.clicarPorTexto("‹");

		// verificar texto a esquerda
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
