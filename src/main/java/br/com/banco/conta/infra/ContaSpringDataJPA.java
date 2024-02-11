package br.com.banco.conta.infra;

import br.com.banco.conta.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaSpringDataJPA extends JpaRepository<Conta, Long> {
}
