package br.ce.fmilagres.appium.pages;

import org.openqa.selenium.By;

import br.ce.fmilagres.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionarOpcao1() {
		clicarPorTexto("Op��o 1");
	}
	
	public String obterValorOpcao1() {
		return obterTexto(By.xpath("//*[@text='Op��o 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
	
	public boolean isOpcao1() {
		return existeElementoPorTexto("Esta � a descri��o da op��o 1");
	}
}
