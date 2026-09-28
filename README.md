# Projeto: Testes de UI com JAVA, SELENIUM e Padrão POM
![Java](https://api.devicons.dev.br/icon?icons=Linux%2CIdea%2CJava%2CSelenium%2CMaven&size=48&theme=dark&perline=30)

Projeto de automação de testes end-to-end (E2E) para a aplicação financeira **BugBank**, utilizando **Java**, **Selenium WebDriver 4**, **JUnit 4** e **Maven**, estruturado sobre o padrão de arquitetura **Page Object Model (POM)**.

---

## 📂 Estrutura do Projeto

```text
BugBank/
├── src/
│   └── test/
│       └── java/
│           ├── page/
│           │   ├── CadastroPage.java
│           │   ├── HomePage.java
│           │   ├── LoginPage.java
│           │   └── TransferenciaPage.java
│           └── suite/
│               ├── CadastroTest.java
│               ├── SaldoInicialTest.java
│               └── TransferenciaTest.java
├── .gitignore
└── pom.xml

```
 - [**CadastroPage.java**](https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM/blob/main/BugBank/src/test/java/page/CadastroPage.java)
 - [**HomePage.java**](https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM/blob/main/BugBank/src/test/java/page/HomePage.java)
 - [**LoginPage.java**](https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM/blob/main/BugBank/src/test/java/page/LoginPage.java)
 - [**TransferenciaPage.java**](https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM/blob/main/BugBank/src/test/java/page/TransferenciaPage.java)
 - [**CadastroTest.java**](https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM/blob/main/BugBank/src/test/java/suite/CadastroTest.java)
 - [**SaldoInicialTest.java**](https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM/blob/main/BugBank/src/test/java/suite/SaldoInicialTest.java)
 - [**TransferenciaTest.java**](https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM/blob/main/BugBank/src/test/java/suite/TransferenciaTest.java)
#
## 📋 Passo 1: Pré-requisito (Iniciar a Aplicação BugBank)

Para rodar os testes, a aplicação **Bugbank** precisa estar rodando localmente:

#### Clone e inicie o Bugbank:
  
**1. Clonar o projeto:**
```
git clone https://github.com/qaacademy/bugbank-ui.git
```

**2. Entrar no diretório:**
```
cd bugbank-ui
```

**3. Compilar a aplicação com o yarn(nodejs):** 
```
yarn install
```

**4. Rodar a aplicação:** 
```
yarn dev
```

**5. Buscar a aplicação no navegador:** 
```
http://localhost:3000  
```   

#
## 📥 Passo 2: Clonar o Projeto de Automação
Com a aplicação rodando no navegador, abra uma nova janela de terminal para clonar e preparar este repositório de testes:

**1. Clonar o repositório de testes:**
```
git clone https://github.com/SamuraiQAction87/JAVA-SELENIUM-POM.git
```

**2. Entrar no diretório do projeto:**
```
cd BugBank
```

#
## 🚀 Passo 3: Executando os Testes Automatizados (Maven)
Dentro do diretório do projeto de automação (BugBank/), utilize o Maven para compilar e executar a suíte de testes:

**1. Executar uma limpeza e rodar a suíte completa (Recomendado):**
```
mvn clean test
```

**2. Executar toda a suíte de testes (Execução rápida):**
```
mvn test
```

**3. Executar uma classe de teste específica:**
Caso queira rodar apenas os testes de uma funcionalidade (ex: transferências):
```
mvn test -Dtest=TransferenciaTest
```

