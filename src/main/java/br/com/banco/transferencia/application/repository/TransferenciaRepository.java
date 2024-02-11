package br.com.banco.transferencia.application.repository;

import br.com.banco.transferencia.domain.Transferencia;

public interface TransferenciaRepository {
    Transferencia salva(Transferencia transferencia);
}
