package br.com.banco.transferencia.infra;

import br.com.banco.transferencia.domain.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TransferenciaSpringDataJPA extends JpaRepository<Transferencia, Long>,
        JpaSpecificationExecutor<Transferencia> {
    @Query("SELECT sum(t.valor) FROM Transferencia t where t.conta.id = :idConta")
    BigDecimal findbuscaSaldoTotalDaContaContaByIdConta(@Param("idConta") Long idConta);
}
