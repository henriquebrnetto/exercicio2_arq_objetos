package br.insper.biblioteca;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservaService {

    private ArrayList<Reserva> reservas =  new ArrayList<>();

    public void cadastrarReserva(String codigo, LocalDateTime data, Usuario usuario,
                                 Livro livro) {

        Reserva reserva = new Reserva();
        reserva.setCodigo(codigo);
        reserva.setLocalDateTime(data);
        reserva.setUsuario(usuario);
        reserva.setLivro(livro);

        reservas.add(reserva);
        usuario.adicionaReserva(reserva);
        livro.adicionaReserva(reserva);
    }

    public void listarReserva() {
        for (Reserva reserva : reservas) {
            System.out.println("Livro: " + reserva.getLivro());
            System.out.println("Usuário: " + reserva.getUsuario().getNome());
            System.out.println("Data: " + reserva.getLocalDateTime().toString());
        }
    }
}
