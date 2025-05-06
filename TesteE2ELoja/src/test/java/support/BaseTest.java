// Autor: Henrique Cesar
// Data: 06/05/2025

package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Map;

/**
 * Classe base utilizada para configuração e inicialização do WebDriver.
 * Define as opções de execução no navegador Chrome, incluindo modo anônimo
 * e desativação de pop-ups de senha.
 */
public class BaseTest {

    // Instância compartilhada do WebDriver entre os testes
    public static WebDriver driver;

    /**
     * Inicializa o ChromeDriver com configurações personalizadas,
     * incluindo execução em modo anônimo, desativação do gerenciador
     * de senhas e tempo de espera implícito.
     */
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();

        // Executa o navegador em modo anônimo, evitando o uso de histórico e senhas salvas
        options.addArguments("--incognito");

        // Remove a barra de informações "Chrome is being controlled by automated test software"
        options.addArguments("--disable-infobars");

        // Desativa o gerenciador de senhas do Chrome para evitar pop-ups de senha comprometida
        options.setExperimentalOption("prefs", Map.of(
                "profile.password_manager_enabled", false,
                "credentials_enable_service", false
        ));

        // Instancia o ChromeDriver com as opções definidas
        driver = new ChromeDriver(options);

        // Define timeout implícito de 10 segundos
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximiza a janela do navegador
        driver.manage().window().maximize();
    }
}
