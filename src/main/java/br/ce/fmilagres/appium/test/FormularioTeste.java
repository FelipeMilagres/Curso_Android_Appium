package br.ce.fmilagres.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.core.DriverFactory;
import br.ce.fmilagres.appium.pages.FormularioPage;
import br.ce.fmilagres.appium.pages.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreeencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Felipe Milagres");

		assertEquals("Felipe Milagres", page.obterNome());
	}

	@Test
	public void devePreeencherCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");

		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isChechMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isChechMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Felipe Milagres");
		page.selecionarCombo("PS4");
		page.clicarCheck();
		page.clicarSwitch();

		page.Salvar();

		Assert.assertEquals("Nome: Felipe Milagres", page.obterNomeCadastrado());
		Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());
		Assert.assertEquals("Checkbox: Marcado", page.obterCheckCadastrado());
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
	}

	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Felipe Milagres");

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		page.SalvarDemorado();
		//esperar(3000);
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10); 
		wait .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Felipe Milagres']")));
				
		Assert.assertEquals("Nome: Felipe Milagres", page.obterNomeCadastrado());
	}

	@Test
	public void deveAlterData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));		
	}
	
	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		esperar(1000);
		page.clicar(MobileBy.AccessibilityId("55"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:55"));
		
	}
	
	@Test
	public void deveInteragirComSeekbar() {
		//clicar no seekbar
		page.clicarSeekBar(0.57);
		//salvar
		page.Salvar();
		
		//Obter valor
		Assert.assertEquals("Slider: 57", page.obterSliderCadastrado());
	}
}