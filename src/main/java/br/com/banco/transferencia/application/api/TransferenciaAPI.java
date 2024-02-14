package br.com.banco.transferencia.application.api;

import br.com.banco.filtro.TransacoesFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/transferencia")
public interface TransferenciaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TransacaoResponse realizaTransacao (@Valid @RequestBody TransacaoRequest transacaoRequest);

    @GetMapping("/conta/{idConta}")
    @ResponseStatus(code = HttpStatus.OK)
    Page<TransacaoResponse> pesquisaTransacoes (@PathVariable Long idConta, TransacoesFiltro filtro,
                                                    Pageable pageable);


}
