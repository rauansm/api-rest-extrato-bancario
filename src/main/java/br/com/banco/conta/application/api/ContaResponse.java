package br.com.banco.conta.application.api;

import br.com.banco.conta.domain.Conta;
import lombok.Value;

@Value
public class ContaResponse {
    private Long idConta;
    private String nomeResponsavel;

    public ContaResponse(Conta conta) {
        this.idConta = conta.getIdConta();
        this.nomeResponsavel = conta.getNomeResponsavel();
    }
}
