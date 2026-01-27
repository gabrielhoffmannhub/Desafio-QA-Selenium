# Desafio-QA-Selenium

Este repositório contém a automação de testes de interface desenvolvida como parte de um desafio técnico para a área de QA.

O objetivo do projeto é validar os principais fluxos da aplicação Sauce Demo por meio de testes automatizados, utilizando Selenium e boas práticas de organização de código.

## Escopo dos Testes

Os testes automatizados cobrem os seguintes cenários:

- Login com credenciais válidas e inválidas  
- Listagem de produtos  
- Adição de produtos ao carrinho  
- Processo de checkout  
- Fluxo completo de compra (end-to-end)

Os cenários foram priorizados com base em risco e impacto no negócio.

## Estrutura do Projeto

O projeto utiliza o padrão **Page Object Model (POM)** para facilitar a manutenção e a leitura do código.

## Tecnologias Utilizadas

- Java 17  
- Selenium WebDriver  
- JUnit 5  
- Gradle  
- ChromeDriver  

## Execução dos Testes

### Pré-requisitos
- Java 17 instalado  
- Google Chrome instalado  
- ChromeDriver compatível disponível no sistema  

### Executar os testes

Na raiz do projeto, execute:

```bash
.\gradlew.bat test
````
## Estratégia de Testes

Foram automatizados os cenários considerados críticos, priorizados com base em risco e impacto no negócio.

Os cenários de menor risco foram documentados no plano de testes e mantidos como candidatos para execução manual ou automação futura.

## Processo de Versionamento

O desenvolvimento foi realizado utilizando branch de trabalho e Pull Request, seguindo um fluxo padrão de versionamento.

