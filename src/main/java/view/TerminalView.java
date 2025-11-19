package view;

import java.util.List;
import java.util.Scanner;
import model.Produto;

public class TerminalView {

    private Scanner scanner;

    public TerminalView() {
        this.scanner = new Scanner(System.in);
    }

    // Exibe o menu principal e retorna a opção escolhida
    public int mostrarMenu() {
        System.out.println("\n--- SISTEMA DE ESTOQUE ---");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Remover Produto");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

        try {
            // Lê como string e converte para int para evitar bugs de quebra de linha do Scanner
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Retorna inválido se não digitar número
        }
    }

    // Note que a View retorna os DADOS, quem cria o objeto é o Controller/Factory

    public String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public double lerDouble(String mensagem) {
        boolean valido = false;
        double numero = 0.0;

        while (!valido) {
            System.out.print(mensagem);
            String input = scanner.nextLine();
            try {
                // Substitui vírgula por ponto para aceitar "10,50" ou "10.50"
                numero = Double.parseDouble(input.replace(",", "."));
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro! Digite um valor numérico válido (ex: 10.50).");
            }
        }
        return numero;
    }

    public int lerInteiro(String mensagem) {
        boolean valido = false;
        int numero = 0;

        while (!valido) {
            System.out.print(mensagem);
            String input = scanner.nextLine();
            try {
                numero = Integer.parseInt(input);
                valido = true; // Se chegou aqui, é número, então sai do loop
            } catch (NumberFormatException e) {
                System.out.println("Erro! Por favor, digite um número inteiro válido.");
            }
        }
        return numero;
    }

    // Mostra a lista de produtos formatada
    public void listarProdutos(List<Produto> produtos) {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                // Aqui o POLIMORFISMO acontece: o toString() muda dependendo se é Livro ou Eletronico
                System.out.println(p.toString());
            }
        }
    }
    public void mostrarMensagem(String msg) {
        System.out.println("[INFO]: " + msg);
    }
}