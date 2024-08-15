package br.com.facisa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkin;

    private LocalDate checkout;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;
}
