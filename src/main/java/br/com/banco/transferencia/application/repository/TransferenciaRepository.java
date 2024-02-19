package br.com.banco.transferencia.application.repository;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.domain.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransferenciaRepository {
    Transferencia salva(Transferencia transferencia);

    Page<Transferencia> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro, Pageable pageable);
}
