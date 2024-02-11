package br.com.banco.transferencia.application.service;

import br.com.banco.transferencia.application.api.TransferenciaRequest;
import br.com.banco.transferencia.application.api.TransferenciaResponse;

public interface TransferenciaService {
    TransferenciaResponse realizaTransacao(TransferenciaRequest transferenciaRequest);
}
