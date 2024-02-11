package br.com.banco.transferencia.infra;

import br.com.banco.transferencia.domain.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransferenciaSpringDataJPA extends JpaRepository<Transferencia, Long>,
        JpaSpecificationExecutor<Transferencia> {
}
