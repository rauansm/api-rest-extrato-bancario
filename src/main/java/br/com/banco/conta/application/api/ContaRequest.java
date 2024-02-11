package br.com.banco.conta.application.api;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
public class ContaRequest {
    @NotBlank
    private String nomeResponsavel;

}
