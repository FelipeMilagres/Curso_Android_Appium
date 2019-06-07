package br.ce.fmilagres.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.AlertaPage;
import br.ce.fmilagres.appium.pages.MenuPage;

public class AlertTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {	
		page.clicarAlertaConfirm();
		
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		page.confirmar();
		
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		page.clicarAlertaSimples();		
			
		esperar(1000);
		page.clicarForaCaixa();
		
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
