package br.com.banco.transferencia.application.api;

import br.com.banco.conta.domain.Conta;
import br.com.banco.transferencia.domain.Tipo;
import br.com.banco.transferencia.domain.Transferencia;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class TransacaoResponse {

    private Long idTransferencia;
    private OffsetDateTime dataTransferencia;
    private BigDecimal valor;
    private Tipo tipo;
    private String nomeOperadorTransacao;
    private Conta conta;

    public TransacaoResponse(Transferencia transacao) {
        this.idTransferencia = transacao.getIdTransferencia();
        this.dataTransferencia = transacao.getDataTransferencia();
        this.valor = transacao.getValor();
        this.tipo = transacao.getTipo();
        this.nomeOperadorTransacao = transacao.getNomeOperadorTransacao();
        this.conta = transacao.getConta();
    }

    public static List<TransacaoResponse> converte(Page<Transferencia> transacoes) {
        return transacoes.stream()
                .map(TransacaoResponse::new)
                .collect(Collectors.toList());
    }
}
