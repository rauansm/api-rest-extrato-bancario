package br.com.banco.extrato.application.api;

import br.com.banco.extrato.application.service.ExtratoService;
import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ExtratoController implements ExtratoAPI {
    private final ExtratoService extratoService;
    @Override
    public List<ExtratoConta> extratoContaBancaria(Long idConta, ExtratoFiltro filtro) {
        log.info("[inicia] ExtratoController - extratoContaBancaria");
        List<ExtratoConta> extrato = extratoService.extratoContaBancaria(idConta,filtro);
        log.info("[finaliza] ExtratoController - extratoContaBancaria");
        return extrato;
    }

    @Override
    public ResponseEntity<byte[]> extratoContaBancariaPDF(Long idConta, ExtratoFiltro filtro) throws JRException {
        log.info("[inicia] ExtratoController - extratoContaBancariaPDF");
        byte[] extratoPDF = extratoService.gerarExtratoBancarioPDF(idConta,filtro);
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=extrato-bancario.pdf");
        log.info("[finaliza] ExtratoController - extratoContaBancariaPDF");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers)
                .body(extratoPDF);
    }
}
