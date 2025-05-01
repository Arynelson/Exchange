# 💱 Conversor de Moedas (Java + Maven)

Este é um projeto simples em Java que permite converter valores entre diferentes moedas utilizando a API pública [ExchangeRate-API](https://www.exchangerate-api.com/).

O usuário escolhe a conversão desejada em um menu, digita o valor a ser convertido, e o sistema retorna o valor convertido com base na cotação atual.

---

## 🚀 Funcionalidades

- Menu interativo com 9 opções de conversão
- Consumo da API de câmbio em tempo real
- Exibição do valor convertido
- Estrutura modular e orientada a objetos
- Testes unitários com JUnit (em breve)

---

## 🧰 Tecnologias Utilizadas

- Java 17+
- Maven
- Gson (para JSON)
- JUnit 5 (para testes) -ainda não implementada

---

## 📦 Como executar o projeto

### Pré-requisitos

- Java JDK 17 ou superior instalado
- Maven instalado e configurado

🗂 Estrutura de Diretórios
```
src/
├── main/
│   ├── java/
│   │   └── com.exchange/
│   │       ├── api/
│   │       ├── model/
│   │       ├── service/
│   │       ├── ui/
│   │       ├── util/
│   │       └── Main.java
│   └── resources/
└── test/
    └── java/
        └── com.exchange.service/
            └── CurrencyConverterServiceTest.java
```
🔑 API
O projeto utiliza a ExchangeRate-API no plano gratuito:
```
https://v6.exchangerate-api.com/v6/SUA-API-KEY/latest/USD
