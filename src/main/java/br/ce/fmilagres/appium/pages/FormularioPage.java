package br.ce.fmilagres.appium.pages;

import static br.ce.fmilagres.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.fmilagres.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{

	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}

	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}

	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheck() {
		clicar(By.xpath("//android.widget.CheckBox"));
	}

	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}

	public boolean isChechMarcado() {
		return isCheckMarcado(By.xpath("//android.widget.CheckBox"));
	}

	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSeekBar(double posicao) {
		double delta = 43;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		double xinicial = seek.getLocation().x + delta;
		int x = (int)(xinicial + (seek.getSize().width - 2*delta) * posicao);
		System.out.println(x);
		
		tap(x, y);
	}
	
	public void Salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void SalvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterSliderCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));  
	}
	
	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}	
}