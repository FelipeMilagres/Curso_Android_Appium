package br.ce.fmilagres.appium.pages.seuBarriga;

import org.openqa.selenium.By;

import br.ce.fmilagres.appium.core.BasePage;

public class SBMovimentacaoPage extends BasePage {
	
	public void setDescricao(String descricao) {
		escrever(By.xpath("//android.widget.EditText[1]"), descricao);
	}
	
	public void setInterssado(String interessado) {
		escrever(By.xpath("//android.widget.EditText[2]"), interessado);
	}
	
	public void setValor(String valor) {
		escrever(By.xpath("//android.widget.EditText[3]"), valor);
	}	
	
	public void selecionarConta(String conta) {
		selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}

}
