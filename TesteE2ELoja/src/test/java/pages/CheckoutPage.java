// Autor: Henrique Cesar
// Data: 06/05/2025

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Classe Page Object que representa a tela de checkout do SauceDemo.
 * Encapsula os elementos e ações necessárias para preencher o formulário de compra
 * e finalizar o pedido.
 */
public class CheckoutPage {

    WebDriver driver;

    // Localizadores dos campos e botões da página de checkout
    By firstName = By.id("first-name");      // Campo para o primeiro nome
    By lastName = By.id("last-name");        // Campo para o sobrenome
    By postalCode = By.id("postal-code");    // Campo para o código postal (CEP)
    By continueBtn = By.id("continue");      // Botão para continuar após preencher os dados
    By finishBtn = By.id("finish");          // Botão para finalizar o checkout

    /**
     * Construtor da classe que recebe o WebDriver ativo.
     * @param driver instância atual do WebDriver
     */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Preenche o formulário de checkout com nome, sobrenome e código postal,
     * e clica no botão "Continue".
     *
     * @param first Primeiro nome do cliente
     * @param last Sobrenome do cliente
     * @param zip Código postal (CEP)
     */
    public void fillCheckoutInfo(String first, String last, String zip) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    /**
     * Clica no botão "Finish" para concluir a compra.
     */
    public void finishCheckout() {
        driver.findElement(finishBtn).click();
    }
}
