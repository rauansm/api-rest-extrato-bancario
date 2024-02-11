package br.com.banco.conta.application.repository;

import br.com.banco.conta.domain.Conta;

public interface ContaRepository {
    Conta salva(Conta conta);
}
