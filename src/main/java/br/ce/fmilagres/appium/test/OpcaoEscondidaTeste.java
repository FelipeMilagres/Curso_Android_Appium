package br.ce.fmilagres.appium.test;

import static br.ce.fmilagres.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.MenuPage;

public class OpcaoEscondidaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test	
	public void deveEncontrarOpcaoEscondida() {
		//scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		menu.scrollDown();
		
		menu.acessarOpcaoBemEscondida();
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//sair mensagem
		menu.clicarPorTexto("OK");		
	}
}