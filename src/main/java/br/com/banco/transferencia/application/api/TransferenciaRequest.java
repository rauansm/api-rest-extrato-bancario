package br.com.banco.transferencia.application.api;

import br.com.banco.transferencia.domain.Tipo;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
@Value
public class TransferenciaRequest {
    @Positive
    private BigDecimal valor;
    @NotNull
    private Tipo tipo;
    @NotNull
    private Long idConta;
}
