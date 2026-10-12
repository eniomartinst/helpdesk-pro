package com.enialcode.helpdeskpro.domain.entities;

import com.enialcode.helpdeskpro.domain.enums.Prioridade;
import com.enialcode.helpdeskpro.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_chamados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ABERTO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;
}