package br.ce.fmilagres.appium.pages.seuBarriga;

import static br.ce.fmilagres.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.fmilagres.appium.core.BasePage;

public class SBResumoPage extends BasePage {
	
	public void excluirMovimentacao(String movimentacao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+movimentacao+"']/..")), 0.9, 0.1);		
		clicarPorTexto("Del");
	}
}
