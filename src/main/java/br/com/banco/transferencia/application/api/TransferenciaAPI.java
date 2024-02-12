package br.com.banco.transferencia.application.api;

import br.com.banco.filtro.TransacoesFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/transferencia")
public interface TransferenciaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TransferenciaResponse realizaTransacao (@Valid @RequestBody TransferenciaRequest transferenciaRequest);

    @GetMapping("/conta/{idConta}")
    @ResponseStatus(code = HttpStatus.OK)
    Page<TransferenciaResponse> pesquisaTransacoes (@PathVariable Long idConta, TransacoesFiltro filtro,
                                                    @PageableDefault(size = 10) Pageable pageable);

}
