package br.insper.biblioteca;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmprestimoService {

    private ArrayList<Emprestimo> emprestimos =  new ArrayList<>();

    public void cadastrarEmprestimo(String codigo, String status, LocalDateTime dataDevolucao,
                                 Usuario usuario, Livro livro) {

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setCodigo(codigo);
        emprestimo.setStatus(status);
        emprestimo.setDataDevolucao(dataDevolucao);
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        emprestimos.add(emprestimo);
        usuario.adicionaEmprestimo(emprestimo);
        livro.adicionaEmprestimo(emprestimo);
        livro.setDisponivel(false);
    }

    public void listarEmprestimo() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Livro: " + emprestimo.getLivro());
            System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
            System.out.println("Status: " + emprestimo.getStatus());
        }
    }

}
