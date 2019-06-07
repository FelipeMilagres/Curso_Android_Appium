package br.ce.fmilagres.appium.pages;

import br.ce.fmilagres.appium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarPorTexto("SAIR");
	}
	
	public void clicarForaCaixa() {
		tap(100, 150);
	}
	
}
