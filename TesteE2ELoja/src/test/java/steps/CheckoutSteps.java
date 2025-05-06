// Autor: Henrique Cesar
// Data: 06/05/2025

package steps;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.testng.Assert;
import org.openqa.selenium.By;
import pages.*;
import support.BaseTest;

/**
 * Classe responsável por implementar os passos (steps) de automação
 * para o fluxo de checkout do e-commerce SauceDemo.
 * Utiliza o padrão Page Object para interação com elementos.
 */
public class CheckoutSteps extends BaseTest {

    // Objetos de páginas (Page Objects)
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    /**
     * Acessa a página inicial de login do site SauceDemo.
     */
    @Dado("que o usuário está na página de login do SauceDemo")
    public void abrirSite() {
        initializeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    /**
     * Realiza o login com o usuário e senha fornecidos no cenário.
     */
    @Quando("ele faz login com usuário {string} e senha {string}")
    public void realizarLogin(String user, String pass) {
        loginPage.login(user, pass);
        productsPage = new ProductsPage(driver);
    }

    /**
     * Adiciona o primeiro produto ao carrinho e navega para a carrinho.
     */
    @E("adiciona um produto ao carrinho")
    public void adicionarProduto() {
        productsPage.addProductToCart();
        productsPage.goToCart();
        cartPage = new CartPage(driver);
    }

    /**
     * Prossegue para a tela de checkout.
     */
    @E("prossegue para o checkout")
    public void checkout() {
        cartPage.clickCheckout();
        checkoutPage = new CheckoutPage(driver);
    }

    /**
     * Preenche os dados do formulário de checkout com nome, sobrenome e CEP.
     */
    @E("preenche os dados de pagamento com nome {string}, sobrenome {string} e cep {string}")
    public void preencherCheckout(String nome, String sobrenome, String cep) {
        checkoutPage.fillCheckoutInfo(nome, sobrenome, cep);
    }

    /**
     * Finaliza o processo de compra.
     */
    @E("finaliza a compra")
    public void finalizarCompra() {
        checkoutPage.finishCheckout();
    }

    /**
     * Valida que a compra foi concluída com sucesso.
     */
    @Entao("a compra deve ser concluída com sucesso")
    public void validarFinalizacao() {
        Assert.assertTrue(driver.findElement(By.className("complete-header")).isDisplayed());
        driver.quit();
    }

    /**
     * Verifica se a página de produtos está visível após o login.
     */
    @Entao("a página de produtos deve ser exibida")
    public void aPáginaDeProdutosDeveSerExibida() {
        boolean tituloVisivel = driver.findElement(By.className("title")).isDisplayed();
        Assert.assertTrue(tituloVisivel, "Página de produtos não foi exibida após login.");
        driver.quit();
    }

    /**
     * Adiciona um segundo produto ao carrinho.
     */
    @E("adiciona outro produto ao carrinho")
    public void adicionaOutroProdutoAoCarrinho() {
        productsPage.addOutroProdutoAoCarrinho();
        productsPage.goToCart();
        cartPage = new CartPage(driver);
    }

    /**
     * Clica em "Continue Shopping" para retornar à página de produtos.
     */
    @E("retorno a pagina inicial")
    public void retornoAPaginaInicial() {
        productsPage.returnPaginaInicial();
        cartPage = new CartPage(driver);
    }

    /**
     * Valida a exibição de uma mensagem de erro.
     */
    @Entao("uma mensagem de erro deve ser exibida")
    public void umaMensagemDeErroDeveSerExibida() {
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
        driver.quit();
    }

    /**
     * Valida se campos obrigatórios não preenchidos no checkout geram erro.
     */
    @Entao("uma mensagem de erro de campos obrigatórios deve ser exibida")
    public void umaMensagemDeErroDeCamposObrigatóriosDeveSerExibida() {
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
        driver.quit();
    }
}
