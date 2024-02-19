package br.com.banco.transferencia.application.api;

import br.com.banco.transferencia.domain.Tipo;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Value
public class TransacaoRequest {
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Tipo tipo;
    @NotBlank
    private String nomeOperadorTransacao;
    @NotNull
    private Long idConta;
}
