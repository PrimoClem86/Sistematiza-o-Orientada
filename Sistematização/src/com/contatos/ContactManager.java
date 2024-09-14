package com.contatos;

import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contactList = new ContactList();
        int choice;

        do {
            System.out.println("\n--- Menu de Gerenciamento de Contatos ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Listar Todos os Contatos");
            System.out.println("5. Sair");

            // Validação da entrada de escolha do menu
            choice = getValidIntInput(scanner, "Escolha uma opção: ");

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o número de telefone: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, email);
                    contactList.addContact(newContact);
                    break;

                case 2:
                    System.out.print("Digite o nome ou número de telefone para busca: ");
                    String searchQuery = scanner.nextLine();
                    Contact foundContact = contactList.searchContact(searchQuery);
                    if (foundContact != null) {
                        System.out.println("Contato encontrado: " + foundContact);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome ou número de telefone para remover: ");
                    String removeQuery = scanner.nextLine();
                    if (contactList.removeContact(removeQuery)) {
                        System.out.println("Contato removido com sucesso.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\nLista de Contatos:");
                    contactList.listContacts();
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Função para garantir que a entrada seja um número inteiro válido
    private static int getValidIntInput(Scanner scanner, String message) {
        int input = -1;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha pendente
                break;  // Se for um número válido, saia do loop
            } else {
                System.out.println("Por favor, insira um número válido.");
                scanner.next();  // Consumir entrada inválida
            }
        }
        return input;
    }
}
