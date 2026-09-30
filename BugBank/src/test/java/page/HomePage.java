package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    // 1. Driver privado (encapsulado)
    private WebDriver driver;

    // 2. Mapeamento dos elementos usando 'private By'
    private By elementoSaldo  = By.xpath("//*[@id='textBalance']/span");
    private By btnTransferencia = By.xpath("//*[@id='btn-TRANSFERÊNCIA']");

    // 3. Construtor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // 4. Métodos auxiliares de interação
    public void clicarPorXpath(By elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elemento));
        element.click();
    }

    // 5. Métodos de Ação / Negócio

    // Metodo para clicar no botão de Transferência
    public void clicarBotaoTransferencia() {
        clicarPorXpath(btnTransferencia);
    }

    // Metodo para acessar e validar o saldo
    public void validarSaldo(String valorEsperado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementoSaldo));

        String valorAtual = driver.findElement(elementoSaldo).getText();
        Assert.assertEquals(valorEsperado, valorAtual);
    }
}