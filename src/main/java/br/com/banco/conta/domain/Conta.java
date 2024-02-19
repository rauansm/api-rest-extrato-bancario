package br.com.banco.conta.domain;

import br.com.banco.conta.application.api.ContaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", name = "id_conta", updatable = false, unique = true, nullable = false)
    private Long idConta;
    private String nomeResponsavel;

    public Conta(ContaRequest contaRequest) {
        this.nomeResponsavel = contaRequest.getNomeResponsavel();
    }
}
