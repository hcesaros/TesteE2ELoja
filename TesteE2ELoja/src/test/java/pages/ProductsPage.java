// Autor: Henrique Cesar
// Data: 06/05/2025

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Classe Page Object responsável por encapsular as ações realizadas
 * na página de produtos do site SauceDemo.
 */
public class ProductsPage {

    WebDriver driver;

    // Elementos da página
    By productAddBtn = By.id("add-to-cart-sauce-labs-backpack"); // Primeiro produto
    By secondProductAddBtn = By.id("add-to-cart-sauce-labs-bike-light"); // Segundo produto
    By cartIcon = By.className("shopping_cart_link"); // Ícone do carrinho (canto superior direito)
    By btnContinueShipping = By.xpath("//button[@id='continue-shopping']"); // Botão "Continue Shopping" no carrinho

    /**
     * Construtor que recebe a instância do WebDriver.
     * @param driver WebDriver da sessão atual.
     */
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clica no botão "Add to cart" do primeiro produto (Sauce Labs Backpack).
     */
    public void addProductToCart() {
        driver.findElement(productAddBtn).click();
    }

    /**
     * Clica no botão "Add to cart" do segundo produto (Sauce Labs Bike Light).
     */
    public void addOutroProdutoAoCarrinho() {
        driver.findElement(secondProductAddBtn).click();
    }

    /**
     * Clica no ícone do carrinho para ir à página do carrinho de compras.
     */
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    /**
     * Clica no botão "Continue Shopping" para retornar da tela do carrinho
     * para a tela de listagem de produtos.
     */
    public void returnPaginaInicial() {
        driver.findElement(btnContinueShipping).click();
    }
}
