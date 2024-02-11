package br.com.banco.transferencia.domain;

import br.com.banco.conta.domain.Conta;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", name = "id_transferencia", updatable = false, unique = true, nullable = false)
    private Long idTransferencia;
    private Timestamp dataTransferencia;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String nomeOperadorTransferencia;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
}
