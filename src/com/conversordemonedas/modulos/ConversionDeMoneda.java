package com.conversordemonedas.modulos;

import java.time.LocalDateTime;

public class ConversionDeMoneda {
    private String fechaHoraConversion;
    private String codigoMonedaBase;
    private String codigoMonedaFinal;
    private double tasaDeConversion;
    private double montoDeConversion;
    private double resultadoDeConversion;

    public ConversionDeMoneda(MonedaOmdb monedaOmdb, String monedaFinal, double monto) {
        this.fechaHoraConversion = LocalDateTime.now().withNano(0).toString();
        this.codigoMonedaBase = monedaOmdb.base_code();
        this.codigoMonedaFinal = monedaFinal;
        this.tasaDeConversion = monedaOmdb.conversion_rates().get(monedaFinal);
        this.montoDeConversion = monto;
        this.resultadoDeConversion = tasaDeConversion * montoDeConversion;
    }

    @Override
    public String toString() {
        return  String.format("El valor %.2f [" + codigoMonedaBase + "] " +
                "corresponde al valor final de ==> %.2f [" + codigoMonedaFinal + "] \n",
                montoDeConversion,
                resultadoDeConversion);
    }
}
