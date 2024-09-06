package br.insper.biblioteca;

import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Usuario> usuarios =  new ArrayList<>();

    public void cadastrarUsuario(String nome, String endereco, String email,
                                 Biblioteca biblioteca) {

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEndereco(endereco);
        usuario.setEmail(email);
        usuario.setBiblioteca(biblioteca);

        usuarios.add(usuario);
        biblioteca.adicionaUsuario(usuario);
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Biblioteca: " + usuario.getBiblioteca().getNome());
            System.out.println("Emprestimos: " + usuario.getEmprestimos());
            System.out.println("Reservas: " + usuario.getReservas());
        }
    }

    public Usuario buscarUsuario(String nomeUsuario) {

        // return usuarios
        //         .stream()
        //         .filter(b -> b.getNome().equals(nomeUsuarios))
        //         .findFirst()
        //         .get();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

}
