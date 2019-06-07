package br.ce.fmilagres.appium.pages;

import static br.ce.fmilagres.appium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.fmilagres.appium.core.BasePage;
import io.appium.java_client.TouchAction;

public class CliquesPage extends BasePage {

	public void cliqueLongo() {
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}

	public void cliqueDuplo() {
		WebElement elemento = getDriver().findElement(By.xpath("//*[@text='Clique duplo']")); 
		new TouchAction(getDriver())
			.press(elemento).waitAction(Duration.ofMillis(50)).release()
			.press(elemento).waitAction(Duration.ofMillis(50)).release()
			.perform();
	}

	public String obterTextoCampo() {
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
