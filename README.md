# Sistema de Venda de Ingressos

## Descrição
Este é um sistema de venda de ingressos implementado em Java para me aprimorar em POO. 
O sistema permite o cadastro de usuários, login, compra de ingressos, verificação de poltronas, pesquisa de ocupantes de poltronas, verificação de usuários do sistema e exclusão de usuários.

## Estrutura do Projeto     
O projeto é composto por três classes principais:

- **App**: Contém o método main que inicia a execução do programa.
- **Pessoa**: Representa a entidade Pessoa, contendo informações como Id, Nome, Cpf e Idade.
- **Poltronas**: Representa a entidade Poltronas, contendo informações sobre a poltrona e seu ocupante.
- **Metodos**: Contém métodos para realizar as diversas operações do sistema.

## Funcionalidades do Sistema
1. **Cadastro de Usuários**
   - Para cadastrar um usuário, o sistema solicita nome, CPF e idade.
   - Antes de cadastrar, verifica se o nome tem pelo menos 4 letras, se o CPF tem 11 números e se o CPF não está duplicado no sistema.

2. **Login de Usuário**
   - O usuário é autenticado no sistema mediante inserção do CPF.
   - Se o CPF for encontrado, o usuário é considerado autenticado e pode realizar outras operações.

3. **Comprar Ingresso**
   - Usuários autenticados podem comprar ingressos, selecionando uma fileira e poltrona disponível.
   - O sistema verifica se a poltrona está disponível antes de efetuar a compra.
   - Após a compra, as informações do usuário são associadas à poltrona adquirida, incluindo o nome, CPF e idade.
   - As poltronas são marcadas como ocupadas.

4. **Verificar Poltronas**
   - Exibe a disposição das poltronas no formato de uma matriz, indicando as poltronas ocupadas e livres.

5. **Pesquisar Ocupante de Poltrona**
   - Permite pesquisar o ocupante de uma poltrona específica, indicando nome, CPF e idade.

6. **Verificar Usuários do Sistema**
   - Lista todos os usuários cadastrados no sistema, exibindo suas informações.

7. **Apagar Usuário do Sistema**
   - Permite apagar um usuário do sistema, informando o ID do usuário desejado.

8. **Sair**
   - Encerra a execução do programa.

## Instruções de Uso
- Ao iniciar o programa, um menu será exibido com as opções numeradas de 1 a 8.
- Selecione a opção desejada digitando o número correspondente e pressione Enter.
- Siga as instruções na tela para realizar a operação desejada.
- O programa continuará em execução até que a opção "8 - Sair" seja selecionada.

## Observações
- A matriz de poltronas é inicialmente gerada como vazia, e as poltronas são marcadas como ocupadas após a compra.
- O sistema suporta o cadastro de até 5 usuários.
- Caso deseje reiniciar o sistema, é necessário reiniciar a aplicação.

## Como Rodar o Programa

1. **Requisitos**
   - Certifique-se de ter o Java instalado no seu sistema.

```bash

# Compile o programa Java
$ javac App.java

# Execute o programa:
$ java App

```

