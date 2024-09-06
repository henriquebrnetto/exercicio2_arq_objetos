package br.insper.biblioteca;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer opcao = -1;

        BibliotecaService bibliotecaService = new BibliotecaService();
        UsuarioService usuarioService = new UsuarioService();
        LivroService livroService = new LivroService();
        ReservaService reservaService = new ReservaService();
        EmprestimoService emprestimoService = new EmprestimoService();

        while (opcao != 0) {

            System.out.println("1 - Cadastrar Biblioteca");
            System.out.println("2 - Listar Biblitecas");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Cadastrar Livro");
            System.out.println("6 - Listar Livros");
            System.out.println("7 - Cadastrar Reserva");
            System.out.println("8 - Listar Reservas");
            System.out.println("9 - Cadastrar Emprestimo");
            System.out.println("10 - Listar Emprestimos");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();

            //--------------------------------------------------------------------------
            // --------------------------- BIBLIOTECA ----------------------------------

            if (opcao == 1) { // CADASTRAR
                System.out.println("Digite o nome biblioteca:");
                String nome = scanner.next();

                System.out.println("Digite o endereço da bilioteca");
                String endereco = scanner.next();

                bibliotecaService.cadastrarBiblioteca(nome, endereco);

            }

            if (opcao == 2) { // LISTAR
                bibliotecaService.listarBibliotecas();
            }

            //--------------------------------------------------------------------------
            // ------------------------------ USUÁRIO ----------------------------------

            if (opcao == 3) { // CADASTRAR
                System.out.println("Digite o nome do usuário:");
                String nome = scanner.next();

                System.out.println("Digite o email do usuário:");
                String email = scanner.next();

                System.out.println("Digite o endereco do usuário:");
                String endereco = scanner.next();

                System.out.println("Digite o nome da biblioteca:");
                String nomeBiblioteca = scanner.next();

                Biblioteca biblioteca = bibliotecaService.buscarBiblioteca(nomeBiblioteca);

                if (biblioteca != null) {
                    usuarioService
                            .cadastrarUsuario(nome, endereco, email, biblioteca);
                } else {
                    System.out.println("Erro ao cadastrar usuário.");
                }
            }

            if (opcao == 4) { // LISTAR
                usuarioService.listarUsuarios();
            }

            //--------------------------------------------------------------------------
            // -------------------------------- LIVRO ----------------------------------

            if (opcao == 5) { // CADASTRAR
                System.out.println("Digite o nome do livro:");
                String nome = scanner.next();

                System.out.println("Digite o autor do livro:");
                String autor = scanner.next();

                System.out.println("O livro está disponível?");
                Boolean disponivel = scanner.nextBoolean();

                System.out.println("Digite o nome da biblioteca:");
                String nomeBiblioteca = scanner.next();

                Biblioteca biblioteca = bibliotecaService.buscarBiblioteca(nomeBiblioteca);

                if (biblioteca != null) {
                    livroService
                            .cadastrarLivro(nome, autor, disponivel, biblioteca);
                } else {
                    System.out.println("Erro ao cadastrar livro.");
                }
            }

            if (opcao == 6) { // LISTAR
                livroService.listarLivros();
            }
            //--------------------------------------------------------------------------
            // ------------------------------ RESERVA ----------------------------------
            if (opcao == 7) { // CADASTRAR
                System.out.println("Digite o código da reserva:");
                String codigo = scanner.next();

                System.out.println("Digite a data de reserva:");
                LocalDateTime data = LocalDateTime.parse(scanner.next());

                System.out.println("Digite o nome do usuário:");
                String nomeUsuario = scanner.next();

                System.out.println("Digite o nome da biblioteca:");
                String nomeLivro = scanner.next();

                Usuario usuario = usuarioService.buscarUsuario(nomeUsuario);
                Livro livro = livroService.buscarLivro(nomeLivro);

                if (livro != null && usuario != null) {
                    reservaService
                            .cadastrarReserva(codigo, data, usuario, livro);
                } else {
                    System.out.println("Erro ao cadastrar reserva.");
                }
            }

            if (opcao == 8) { // LISTAR
                reservaService.listarReserva();
            }

            //--------------------------------------------------------------------------
            // ------------------------------ EMPRÉSTIMO -------------------------------
            if (opcao == 9) { // CADASTRAR
                System.out.println("Digite o código do empréstimo:");
                String codigo = scanner.next();

                System.out.println("Digite o status de reserva:");
                String status = scanner.next();

                System.out.println("Digite o nome do usuário:");
                LocalDateTime dataDevolucao = LocalDateTime.parse(scanner.next());

                System.out.println("Digite o nome do usuário:");
                String nomeUsuario = scanner.next();

                System.out.println("Digite o nome do livro:");
                String nomeLivro = scanner.next();

                Usuario usuario = usuarioService.buscarUsuario(nomeUsuario);
                Livro livro = livroService.buscarLivro(nomeLivro);

                if (usuario != null && livro != null) {
                    emprestimoService
                            .cadastrarEmprestimo(codigo, status, dataDevolucao, usuario, livro);
                } else {
                    System.out.println("Erro ao cadastrar usuário.");
                }
            }

            if (opcao == 10) { // LISTAR
                emprestimoService.listarEmprestimo();
            }

            //--------------------------------------------------------------------------

            // adicionar as outras operacoes:
            // Cadastrar e Listar Livros
            // Cadastrar e Listar Reservas
            // Cadastrar e Listar Emprestimos

        }


    }

}
