package br.com.banco.extrato.infra;

import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;

import java.util.List;

public interface ExtratoSpringDataJPA {

    List<ExtratoConta> extratoContaBancaria (Long idConta ,ExtratoFiltro filtro);

}
