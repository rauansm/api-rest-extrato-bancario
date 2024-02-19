package br.com.banco.extrato.domain;

import br.com.banco.transferencia.domain.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class ExtratoConta {

    private Date data;
    private BigDecimal valor;
    private Tipo tipo;
    private String nomeOperadorTransacao;

}
