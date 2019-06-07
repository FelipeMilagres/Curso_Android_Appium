package br.ce.fmilagres.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.DragDropPage;
import br.ce.fmilagres.appium.pages.MenuPage;

public class DragNDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private DragDropPage page = new DragDropPage();
	
	private String[] estadoInicial = new String[] {"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta",  "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,", "� uma lista", "Drag em Drop!", "e arraste para", "Esta",  "qualquer local desejado."};
	
	@Test
	public void deveEfetuarDragNDrop() {
		//acessar menu
		menu.acessarDragAndDrop();
		
		//verificar estado inicial
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		//arasstar "Esta" para "e arraste para"
		page.arrastar("Esta", "e arraste para");
		
		//verificar estado intermediario
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		//arasstar "Fa�a um clique longo," para "� uma lista"
		page.arrastar("Fa�a um clique longo,", "� uma lista");
		
		//verificar estado final
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}
}
