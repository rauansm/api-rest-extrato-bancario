package br.com.banco.transferencia.infra.spec;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.domain.Transferencia;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
@Log4j2
public class TransferenciaSpecs {

    public static Specification<Transferencia> usandoFiltro(Long idConta, TransacoesFiltro filtro) {
        log.info("[inicia] TransferenciaSpecs - usandoFiltro");
        return (root, query, builder) -> {

            var predicates = new ArrayList<Predicate>();

            if (idConta != null){
                predicates.add(builder.equal(root.get("conta"), idConta));}

            if (filtro.getNomeOperadorTransacao() != null) {
                predicates.add(builder.like(root.get("nomeOperadorTransacao"), "%" + filtro.getNomeOperadorTransacao() + "%"));}

            if (filtro.getDataInicio() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("dataTransferencia"),  filtro.getDataInicio()));}

            if (filtro.getDataFim() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("dataTransferencia"),  filtro.getDataFim()));}

            log.info("[finaliza] TransferenciaSpecs - usandoFiltro");
            return builder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };
    }
}
