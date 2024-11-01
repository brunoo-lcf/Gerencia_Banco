package com.mycompany.gerenciabanco;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GerenciaBanco {

    static class Conta {
        private String nome;
        private String sobrenome;
        private String cpf;
        private double saldo;

        public Conta(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = 0.0;
        }

        public void consultarSaldo() {
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
            } else {
                System.out.println("Valor inválido para depósito.");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        }
    }

    public static void exibirMenu(Conta conta, Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n--- MENU BANCO ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 4:
                    System.out.println("Saindo da aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        
        Conta conta = new Conta(nome, sobrenome, cpf);

        
        exibirMenu(conta, scanner);

        scanner.close();
    }
}