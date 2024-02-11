package br.com.banco.transferencia.domain;

import br.com.banco.conta.domain.Conta;
import br.com.banco.transferencia.application.api.TransferenciaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", name = "id_transferencia", updatable = false, unique = true, nullable = false)
    private Long idTransferencia;
    @CreationTimestamp
    private OffsetDateTime dataTransferencia;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String nomeOperadorTransacao;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Transferencia(TransferenciaRequest transferenciaRequest, Conta conta) {
        this.valor = transferenciaRequest.getValor();
        this.tipo = transferenciaRequest.getTipo();
        this.nomeOperadorTransacao = conta.getNomeResponsavel();
        this.conta = conta;
    }
}
