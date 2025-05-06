// Autor: Henrique Cesar
// Data: 06/05/2025

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Classe Page Object responsável por encapsular os elementos
 * e ações da página de login do site SauceDemo.
 */
public class LoginPage {
    WebDriver driver;

    // Localizadores dos elementos da tela de login
    By username = By.id("user-name");      // Campo de nome de usuário
    By password = By.id("password");       // Campo de senha
    By loginBtn = By.id("login-button");   // Botão de login

    /**
     * Construtor da classe LoginPage que recebe o WebDriver da sessão atual.
     *
     * @param driver instância ativa do WebDriver
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Realiza o login preenchendo os campos de usuário e senha
     * e clicando no botão "Login".
     *
     * @param user nome de usuário a ser inserido
     * @param pass senha a ser inserida
     */
    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
