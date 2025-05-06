// Autor: Henrique Cesar
// Data: 06/05/2025

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Classe Page Object responsável por representar e interagir com
 * os elementos da página de carrinho do site SauceDemo.
 */
public class CartPage {
    WebDriver driver;

    // Localizador do botão "Checkout" na página do carrinho
    By checkoutBtn = By.id("checkout");

    /**
     * Construtor da classe que recebe o WebDriver da sessão.
     * @param driver instância ativa do WebDriver.
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clica no botão "Checkout" para prosseguir com a compra.
     */
    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
