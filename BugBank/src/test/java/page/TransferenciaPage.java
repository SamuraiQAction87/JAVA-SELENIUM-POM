package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class TransferenciaPage {

    // 1. Driver privado (encapsulado)
    private final WebDriver driver;

    // 2. Mapeamento dos campos do formulário (usando By nativo)
    private final By campoNumeroDaConta = By.xpath("//input[@name='accountNumber']");
    private final By campoDigitoConta   = By.xpath("//input[@name='digit']");
    private final By campoValor         = By.xpath("//input[@name='transferValue']");
    private final By campoDescricao     = By.xpath("//input[@name='description']");
    private final By btnTransferirII    = By.xpath("//button[text()='Transferir agora']");

    // 3. Textos esperados nos modais (usados no getPageSource para evitar instabilidade da DOM)
    private final String txtSucesso = "Transferencia realizada com sucesso";
    private final String txtErro    = "Você não tem saldo suficiente para essa transação";

    // Construtor
    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos auxiliares
    private void preencherValorPorXpath(By elemento, String texto) {
        driver.findElement(elemento).sendKeys(texto);
    }

    public void clicarPorXpath(By elemento) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
        driver.findElement(elemento).click();
    }

    // Fluxo DRY
    public void realizarTransferencia(String conta, String digito, String valor, String descricao) {
        preencherValorPorXpath(campoNumeroDaConta, conta);
        preencherValorPorXpath(campoDigitoConta, digito);
        preencherValorPorXpath(campoValor, valor);
        preencherValorPorXpath(campoDescricao, descricao);
        clicarPorXpath(btnTransferirII);
    }

    // Validação via getPageSource usando a variável da classe (estável e sem duplicidade)
    public void validarTransferenciaSucesso() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.getPageSource().contains(txtSucesso));
        Assert.assertTrue("Erro ao validar a transferencia!", driver.getPageSource().contains(txtSucesso));
    }

    public void validarErroNaTransferencia() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.getPageSource().contains(txtErro));
        Assert.assertTrue("Erro ao validar o saldo insuficiente!", driver.getPageSource().contains(txtErro));
    }
}