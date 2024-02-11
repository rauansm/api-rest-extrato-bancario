package br.com.banco.transferencia.application.repository;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.domain.Transferencia;

import java.util.List;

public interface TransferenciaRepository {
    Transferencia salva(Transferencia transferencia);

    List<Transferencia> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro);
}
