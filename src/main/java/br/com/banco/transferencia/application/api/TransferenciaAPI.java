package br.com.banco.transferencia.application.api;

import br.com.banco.filtro.TransacoesFiltro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/transferencia")
public interface TransferenciaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TransferenciaResponse realizaTransacao (@Valid @RequestBody TransferenciaRequest transferenciaRequest);

    @GetMapping("/conta/{idConta}")
    @ResponseStatus(code = HttpStatus.OK)
    List<TransferenciaResponse> pesquisaTransacoes (@PathVariable Long idConta,
                                           TransacoesFiltro filtro);

}
