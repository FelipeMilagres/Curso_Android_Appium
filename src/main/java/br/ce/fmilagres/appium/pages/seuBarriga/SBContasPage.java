package br.ce.fmilagres.appium.pages.seuBarriga;

import org.openqa.selenium.By;

import br.ce.fmilagres.appium.core.BasePage;

public class SBContasPage extends BasePage {

	public void setConta(String conta) {
		escrever(By.className("android.widget.EditText"), conta);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void selecionarConta(String conta) {
		cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
	}
	
	public void excluir() {
		clicarPorTexto("EXCLUIR");
	}
}
