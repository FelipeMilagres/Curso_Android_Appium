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
		Assert.assertTrue(menu.existeElementoPorTexto("voc� consegue"));

		// clicar bot�o direita
		menu.clicarPorTexto("�");

		// verificar o texto 'Chegar at� o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar at� o fim!"));

		// swipe esquerda
		menu.swipeLeft();

		// clicar bot�o esquerda
		menu.clicarPorTexto("�");

		// verificar texto a esquerda
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
