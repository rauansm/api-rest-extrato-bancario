package br.com.banco.transferencia.application.service;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.api.TransacaoRequest;
import br.com.banco.transferencia.application.api.TransacaoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface TransferenciaService {
    TransacaoResponse realizaTransacao(TransacaoRequest transacaoRequest);

    Page<TransacaoResponse> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro, Pageable pageable);

    BigDecimal buscaSaldoTotalDaConta (Long idConta);
}
