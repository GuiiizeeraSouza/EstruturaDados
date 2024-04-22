package Atividade_Avaliativa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static ArrayList<Atleta> atletas = new ArrayList<>();
    static final String FILE_PATH = "Atividade_Avaliativa/atletas.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Principal.carregarDados();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Listar atletas (nome ou por pontuação decrescente)");
            System.out.println("2 - Cadastrar atleta");
            System.out.println("3 - Procurar por atleta (nome ou apelido)");
            System.out.println("4 - Remover atleta (nome ou apelido)");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    listarAtletas();
                    break;
                case 2:
                    cadastrarAtleta(scanner);
                    Principal.salvarDados();
                    break;
                case 3:
                    procurarAtleta(scanner);
                    break;
                case 4:
                    break;

                case 5:

                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    static void listarAtletas() {
        if (atletas.isEmpty()) {
            System.out.println("Nenhum atleta cadastrado.");

            return;
        }

        System.out.println("Lista de Atletas:");
        for (Atleta atleta : atletas) {
            System.out.println(atleta);
        }
    }

    static void cadastrarAtleta(Scanner scanner) {
        System.out.println("Digite o nome do atleta: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o apelido do atleta: ");
        String apelido = scanner.nextLine();
        System.out.println("Digite o telefone do atleta: ");
        String fone = scanner.nextLine();
        System.out.println("Digite a data de nascimento do atleta: ");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite a pontuação do atleta: ");
        int pontuacaoAcumulada = scanner.nextInt();

        Atleta novoAtleta = new Atleta(fone, nome, apelido, dataNascimento, pontuacaoAcumulada);
        if (!verificarDuplicado(novoAtleta)) {
            atletas.add(novoAtleta);
            System.out.println("Atleta cadastrado com sucesso!");
        } else {
            System.out.println("Atleta já cadastrado com esse telefone.");
        }
    }

    static boolean verificarDuplicado(Atleta novoAtleta) {
        for (Atleta atleta : atletas) {
            if (atleta.getFone().equals(novoAtleta.getFone())) {
                return true;
            }
        }
        return false;
    }

    static void procurarAtleta(Scanner scanner) {
        System.out.print("Digite o nome ou apelido do atleta a ser procurado: ");
        String termo = scanner.nextLine();

        boolean encontrado = false;
        for(Atleta atleta : atletas) {
            if (atleta.getNome().equalsIgnoreCase(termo) || atleta.getApelido().equalsIgnoreCase(termo)){
                System.out.println("Atletal encontrado: ");
                System.out.println(atleta);
                encontrado =  true;
                break;
            }

            if (!encontrado){
                System.out.println("Atleta não encontrado.");
            }
        }
    }

    static void salvarDados() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Atleta atleta : atletas) {
                writer.print1
                (atleta.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    static void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String fone = parts[0];
                String nome = parts[1];
                String apelido = parts[2];
                String dataNascimento = parts[3];
                int pontuacaoAcumulada = Integer.parseInt(parts[4]);
               
                atletas.add(new Atleta(fone, nome, apelido, dataNascimento, pontuacaoAcumulada));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

    } 

}