package br.com.banco.extrato.infra;

import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;
import br.com.banco.transferencia.domain.Transferencia;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
@Log4j2
public class ExtratoQueryImpl implements ExtratoSpringDataJPA {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<ExtratoConta> extratoContaBancaria(Long idConta,ExtratoFiltro filtro) {
        log.info("[inicia] ExtratoQueryImpl - extratoContaBancaria");

        var builder = manager.getCriteriaBuilder();
        var query = builder.createQuery(ExtratoConta.class);
        var root = query.from(Transferencia.class);

        var functionConvertTzDataCriacao = builder.function("convert_tz", Date.class,
                root.get("dataTransferencia"), builder.literal("+00:00"), builder.literal("-03:00"));
        var functionDateDataCriacao = builder.function("date", Date.class, functionConvertTzDataCriacao);

        var selection = builder.construct(ExtratoConta.class, functionDateDataCriacao,
                root.get("valor"), root.get("tipo"), root.get("nomeOperadorTransacao"));

        var predicates = new ArrayList<Predicate>();

        predicates.add(builder.equal(root.get("conta").get("idConta"), idConta));

        if (filtro.getNomeOperadorTransacao() != null) {
            predicates.add(builder.like(root.get("nomeOperadorTransacao"), "%" + filtro.getNomeOperadorTransacao() + "%"));}

        if (filtro.getDataInicio() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataTransferencia"), filtro.getDataInicio()));}

        if (filtro.getDataFim() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("dataTransferencia"), filtro.getDataFim()));}

        query.select(selection);
        query.where(predicates.toArray(new Predicate[0]));

        log.info("[finaliza] ExtratoQueryImpl - extratoContaBancaria");
        return manager.createQuery(query).getResultList();
    }
}

    /*
    Claro, poderia ter optado por usar Specifications, o que deixaria o código mais simples.
    No entanto, como já havia utilizado Specifications em outra parte do projeto para fazer
    praticamente a mesma coisa, mas com paginação e ordenação, decidi usar Criteria neste caso
    para mostrar que também é uma opção viável para lidar com consultas complexas e com muitos parâmetros.
    */