package br.ce.fmilagres.appium.pages;

import static br.ce.fmilagres.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.fmilagres.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SwipeListPage extends BasePage {

	public void swipeElementLeft(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[starts-with(@text, '"+opcao+"')]/..")), 0.1, 0.9);
	}

	public void swipeElementRight(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[starts-with(@text, '"+opcao+"')]/..")), 0.9, 0.1);
	}
	
	public void clicarBotaoMais() {
		MobileElement botao = getDriver().findElement(By.xpath("//*[starts-with(@text, '(+)')]/.."));
		new TouchAction(getDriver())
			.tap(botao, -50, 0)
			.perform();
	}
}
