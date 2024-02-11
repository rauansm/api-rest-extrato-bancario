package br.com.banco.transferencia.application.api;

import br.com.banco.conta.domain.Conta;
import br.com.banco.transferencia.domain.Tipo;
import br.com.banco.transferencia.domain.Transferencia;
import lombok.Value;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class TransferenciaResponse {

    private Long idTransferencia;
    private OffsetDateTime dataTransferencia;
    private BigDecimal valor;
    private Tipo tipo;
    private String nomeOperadorTransacao;
    private Conta conta;

    public TransferenciaResponse(Transferencia transferencia) {
        this.idTransferencia = transferencia.getIdTransferencia();
        this.dataTransferencia = transferencia.getDataTransferencia();
        this.valor = transferencia.getValor();
        this.tipo = transferencia.getTipo();
        this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
        this.conta = transferencia.getConta();
    }

    public static List<TransferenciaResponse> converte(List<Transferencia> transferencias) {
        return transferencias.stream()
                .map(TransferenciaResponse::new)
                .collect(Collectors.toList());
    }
}
