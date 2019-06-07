package br.ce.fmilagres.appium.pages.seuBarriga;

import org.openqa.selenium.By;

import br.ce.fmilagres.appium.core.BasePage;

public class SBHomePage extends BasePage {

	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
	
	public void atualizarSaldo() {		
		scroll(0.2, 0.9);
	}
}
