package com.kazzak.demokafkacb;

import com.fasterxml.jackson.databind.JsonNode;

import java.text.SimpleDateFormat;
import java.util.Date;

public record GenericTransactionModel(Integer canal,
                                      String aplicativoOrigem,
                                      String tipoOperacao,
                                      String tipoTransacao,
                                      Integer etapaTransacao,
                                      String codigoIdTransacao,
                                      String dataHoraTransacao,
                                      JsonNode areaMensagem)
{
    public GenericTransactionModel(Integer canal, String aplicativoOrigem, String tipoOperacao, String tipoTransacao, Integer etapaTransacao, String codigoIdTransacao, String dataHoraTransacao, JsonNode areaMensagem) {
        this.canal = canal;
        this.aplicativoOrigem = aplicativoOrigem;
        this.tipoOperacao = tipoOperacao;
        this.tipoTransacao = tipoTransacao;
        this.etapaTransacao = etapaTransacao;
        this.codigoIdTransacao = codigoIdTransacao;
        this.dataHoraTransacao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        this.areaMensagem = areaMensagem;
    }

    @Override
    public String toString() {
        return "{" +
                "canal:" + canal +
                ", aplicativoOrigem:'" + aplicativoOrigem + '\'' +
                ", tipoOperacao:" + tipoOperacao +
                ", tipoTransacao:'" + tipoTransacao + '\'' +
                ", etapaTransacao:" + etapaTransacao +
                ", codigoIdTransacao:'" + codigoIdTransacao + '\'' +
                ", areaMensagem:" + areaMensagem +
                '}';

    }


}
