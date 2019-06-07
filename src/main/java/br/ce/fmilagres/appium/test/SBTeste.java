package br.ce.fmilagres.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.fmilagres.appium.core.BaseTest;
import br.ce.fmilagres.appium.pages.MenuPage;
import br.ce.fmilagres.appium.pages.seuBarriga.SBContasPage;
import br.ce.fmilagres.appium.pages.seuBarriga.SBHomePage;
import br.ce.fmilagres.appium.pages.seuBarriga.SBLoginPage;
import br.ce.fmilagres.appium.pages.seuBarriga.SBMenuPage;
import br.ce.fmilagres.appium.pages.seuBarriga.SBMovimentacaoPage;
import br.ce.fmilagres.appium.pages.seuBarriga.SBResumoPage;

public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage sbmenu = new SBMenuPage();
	private SBContasPage sbconta = new SBContasPage(); 
	private SBMovimentacaoPage sbmovimentacao = new SBMovimentacaoPage();
	private SBHomePage sbhome = new SBHomePage();
	private SBResumoPage sbresumo = new SBResumoPage();
	
	@Before
	public void setUp() {
		menu.acessarSBNativo();
		login.setEmail("felipe@teste.com.br");
		login.setSenha("teste");
		login.entrar();
	}
	
	@Test
	public void deveInserirContaComSucesso(){
		//entrar conta
		sbmenu.acessarContas();
		
		//inserir conta
		sbconta.setConta("Caixa 2923");
		
		//SALVAR
		sbconta.salvar();
		
		//verifica mensagem
		Assert.assertTrue(sbconta.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta(){
		//entrar conta
		sbmenu.acessarContas();
		
		//clique longo conta
		sbconta.selecionarConta("Caixa 2923");
		
		//excluir
		sbconta.excluir();
		
		//verifica mensagem
		Assert.assertTrue(sbconta.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMovimentacao() {
		//entrar mov...
		sbmenu.acessarMovimentacao();
		
		//validar descrição
		sbmovimentacao.salvar();
		Assert.assertTrue(sbmovimentacao.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		//validar interessado
		sbmovimentacao.setDescricao("teste");
		sbmovimentacao.salvar();
		Assert.assertTrue(sbmovimentacao.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		//validar valor		
		sbmovimentacao.setInterssado("a");
		sbmovimentacao.salvar();
		Assert.assertTrue(sbmovimentacao.existeElementoPorTexto("Valor é um campo obrigatório"));		
		
		//validar conta
		sbmovimentacao.setValor("4000");
		sbmovimentacao.salvar();
		Assert.assertTrue(sbmovimentacao.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		//inserir com sucesso
		sbmovimentacao.selecionarConta("Caixa 2923");
		sbmovimentacao.salvar();
		Assert.assertTrue(sbmovimentacao.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}

	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
		//verificar saldo "Conta para saldo" = 534,00
		Assert.assertEquals("534.00", sbhome.obterSaldoConta("Conta para saldo"));
		
		//ir para resumo
		sbmenu.acessarResumo();
		
		//excluir movimentação 3
		sbresumo.excluirMovimentacao("Movimentacao 3, calculo saldo");		
		
		//validar mensagem
		Assert.assertTrue(sbresumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
			
		//voltar home
		sbmenu.acessarHome();
		
		//atualizar saldo	
		esperar(2000);
		sbhome.atualizarSaldo();		
		
		//verificar saldo
		Assert.assertEquals("-1000.00", sbhome.obterSaldoConta("Conta para saldo"));
	}
}
