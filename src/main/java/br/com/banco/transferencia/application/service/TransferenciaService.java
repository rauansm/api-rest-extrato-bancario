package br.com.banco.transferencia.application.service;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.api.TransferenciaRequest;
import br.com.banco.transferencia.application.api.TransferenciaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransferenciaService {
    TransferenciaResponse realizaTransacao(TransferenciaRequest transferenciaRequest);

    Page<TransferenciaResponse> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro, Pageable pageable);
}
