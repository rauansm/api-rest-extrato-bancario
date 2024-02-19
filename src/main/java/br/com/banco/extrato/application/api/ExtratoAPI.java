package br.com.banco.extrato.application.api;

import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/conta/{idConta}/extrato")
public interface ExtratoAPI {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    List<ExtratoConta> extratoContaBancaria (@PathVariable Long idConta,
                                             ExtratoFiltro filtro);

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<byte[]> extratoContaBancariaPDF (@PathVariable Long idConta,
                                            ExtratoFiltro filtro) throws JRException;


}
