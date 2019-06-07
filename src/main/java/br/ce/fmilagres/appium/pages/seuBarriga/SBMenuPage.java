package br.ce.fmilagres.appium.pages.seuBarriga;

import br.ce.fmilagres.appium.core.BasePage;

public class SBMenuPage extends BasePage {

	public void acessarHome() {
		clicarPorTexto("HOME");
	}
	
	public void acessarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacao() {
		clicarPorTexto("MOV...");
	}
	
	public void	acessarResumo() {
		clicarPorTexto("RESUMO");
	}
}
