# 👩‍💻👨‍💻 Repositório de Treinamento para Estagiários - Paradigmas, Padrões e Boas Práticas 🚀

Seja muito bem-vindo(a) ao **repositório oficial de treinamento para estagiários da empresa**! 🎉

Este espaço foi criado com muito cuidado e dedicação para apoiar o seu **desenvolvimento profissional e técnico**, desde os primeiros passos na jornada de programação até a construção de soluções bem estruturadas, orientadas por **paradigmas de programação**, **separação de responsabilidades** e **padrões de software**.

---

## 🎯 Objetivo do Repositório

O propósito central deste repositório é guiar os novos estagiários a:

- Entender e aplicar os principais paradigmas de programação:
  - **Programação Funcional (PF)** 🧠
  - **Programação Orientada a Objetos (POO)** 🧩
  - **Programação Declarativa** 📘
  - **Programação Reativa** ⚡
- Aprender a **separar responsabilidades** de forma clara e coesa
- Praticar **boas práticas de organização de código**
- Ter contato com **padrões de software reais** utilizados em projetos profissionais

---

## 🛠️ O que você vai aprender aqui?

Ao explorar os exemplos e desafios disponíveis neste repositório, você será exposto(a) a uma série de conceitos essenciais para se tornar um(a) desenvolvedor(a) mais **consciente**, **limpo(a)** e **eficiente**:

---

### ✅ Programação Funcional (PF)

- Uso de **funções puras**
- **Composição de funções**
- Uso de **streams**, **lambdas** e **operações de pipeline**
- Abordagem **declarativa** e **imutabilidade**

---

### ✅ Programação Orientada a Objetos (POO)

- Criação e uso de **interfaces** e **classes abstratas**
- **Encapsulamento**, **herança**, **polimorfismo**
- **Abstração de responsabilidades**
- Boas práticas de organização com **pacotes**

---

### ✅ Programação Declarativa

- Foco no **“o que fazer”** ao invés do **“como fazer”**
- Clareza e **legibilidade** no fluxo de código
- Abordagens como **streams**, **filtragens** e **transformações**

---

### ✅ Programação Reativa ⚡

- **Reatividade** como resposta a eventos e mudanças de estado
- Trabalho com **fluxos de dados assíncronos** (ex: Publisher, Subscriber)
- Uso de bibliotecas como:
  - `RxJava`
  - `Project Reactor`
- Abordagem ideal para sistemas que lidam com:
  - Eventos em tempo real
  - I/O assíncrono
  - Alta concorrência
- Pensamento orientado a **fluxos contínuos** e **propagação automática de mudanças**

> 💡 **Dica:** Ao contrário da abordagem imperativa tradicional, a programação reativa permite **responder automaticamente a mudanças**, tornando os sistemas mais **responsivos**, **resilientes** e **escaláveis**.

---

### ✅ Separação de Responsabilidades (SRP)

- **Divisão de funcionalidades** por papel
- Organização em **camadas** e **pacotes distintos**
- Aplicação do princípio de **Responsabilidade Única** (Single Responsibility Principle)

---

### ✅ Padrões de Software

- Uso de **interfaces** para contratos de negócio
- **Estratégias de implementação desacoplada**
- **Reutilização** e **extensibilidade** através de boas práticas de design

---

Sinta-se à vontade para explorar, praticar e perguntar! Este repositório é seu aliado no processo de aprendizagem e evolução como desenvolvedor(a) 🚀👩‍💻👨‍💻

---

## 📁 Organização do Repositório

```
.
├── estagiariosbase
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── estagiarios
│   │                       └── base
│   │                           ├── ComReatividade
│   │                           │   ├── ComPadraoDeProj
│   │                           │   │   ├── model
│   │                           │   │   │   └── Pessoa.java
│   │                           │   │   ├── observer
│   │                           │   │   │   ├── PessoaEvent.java
│   │                           │   │   │   └── PessoaObserver.java
│   │                           │   │   ├── repository
│   │                           │   │   │   └── PessoaRepository.java
│   │                           │   │   └── Main.java
│   │                           │   └── ComRXJava
│   │                           │       ├── model
│   │                           │       │   └── Pessoa.java
│   │                           │       ├── repository
│   │                           │       │   └── PessoaRepository.java
│   │                           │       ├── service
│   │                           │       │   └── PessoaService.java
│   │                           │       └── Main.java
│   │                           ├── ComSeparacaoParadigDeclaratESepResp
│   │                           │   ├── PF
│   │                           │   │   └── MainSepRespPF.java
│   │                           │   └── POO
│   │                           │       ├── Abs
│   │                           │       │   └── Cadastros.java
│   │                           │       ├── Impel
│   │                           │       │   └── GerenciadoCadastros.java
│   │                           │       ├── Models
│   │                           │       │   ├── Fornecedor.java
│   │                           │       │   └── Produto.java
│   │                           │       └── MainPOOEx02.java
│   │                           ├── ComSeparacaoParadigEDeclarativo
│   │                           │   ├── PF
│   │                           │   │   └── MainPF02.java
│   │                           │   └── POO
│   │                           │       ├── Abs
│   │                           │       │   └── IAvaliador.java
│   │                           │       ├── Impel
│   │                           │       │   └── AvaliadorAlunos.java
│   │                           │       └── MainPOO2.java
│   │                           ├── ComSeparacaoParadigmas
│   │                           │   ├── PF
│   │                           │   │   ├── Facilitadores01.png
│   │                           │   │   └── MainPF.java
│   │                           │   └── POO
│   │                           │       ├── Abs
│   │                           │       │   └── GerenciaFormaPagamento.java
│   │                           │       ├── Impel
│   │                           │       │   ├── GerenciadorPagamentos.java
│   │                           │       │   ├── PagamentoViaCartao.java
│   │                           │       │   └── PagamentoViaPix.java
│   │                           │       └── MainSepRespPOO.java
│   │                           └── SemSepararParadigmas
│   │                               ├── MainComList.java
│   │                               └── MainComMap.java
│   └── pom.xml
├── .gitignore
├── LICENSE
└── README.md
```
