package br.com.banco.extrato.infra;

import br.com.banco.filtro.ExtratoFiltro;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

@Component
@RequiredArgsConstructor
@Log4j2
public class ExtratoJasperPDF {

    private final ExtratoSpringDataJPA extratoSpringDataJPA;

    public byte[] emitirExtratoBancarioPDF(Long idConta,BigDecimal saldoTotalConta, ExtratoFiltro filtro) throws JRException {
        log.info("[inicia] ExtratoJasperPDF - emitirExtratoBancarioPDF");

        var inputStrem = this.getClass().getResourceAsStream("/relatorios/extrato-bancario.jasper");

        var parametros = new HashMap<String, Object>();
        parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
        parametros.put("REPORT_TIME_ZONE", TimeZone.getTimeZone("America/Sao_Paulo"));
        parametros.put("SALDO_TOTAL", new BigDecimal(String.valueOf(saldoTotalConta)));

        var extratoBancario = extratoSpringDataJPA.extratoContaBancaria(idConta,filtro);
        var dataSource = new JRBeanCollectionDataSource(extratoBancario);
        var jasperPrint = JasperFillManager.fillReport(inputStrem, parametros, dataSource);

        log.info("[finaliza] ExtratoJasperPDF - emitirExtratoBancarioPDF");
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
