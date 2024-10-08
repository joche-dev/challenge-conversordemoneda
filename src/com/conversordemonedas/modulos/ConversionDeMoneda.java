package com.conversordemonedas.modulos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionDeMoneda {
    private String fechaHoraConversion;
    private String codigoMonedaBase;
    private String codigoMonedaFinal;
    private double tasaDeConversion;
    private double montoDeConversion;
    private double resultadoDeConversion;

    public ConversionDeMoneda(MonedaOmdb monedaOmdb, String monedaFinal, double monto) {
        this.fechaHoraConversion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.codigoMonedaBase = monedaOmdb.base_code();
        this.codigoMonedaFinal = monedaFinal;
        this.tasaDeConversion = monedaOmdb.conversion_rates().get(monedaFinal);
        this.montoDeConversion = monto;
        this.resultadoDeConversion = tasaDeConversion * montoDeConversion;
    }

    public String getFechaHoraConversion() {
        return fechaHoraConversion;
    }

    public String getCodigoMonedaBase() {
        return codigoMonedaBase;
    }

    public String getCodigoMonedaFinal() {
        return codigoMonedaFinal;
    }

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public double getMontoDeConversion() {
        return montoDeConversion;
    }

    public double getResultadoDeConversion() {
        return resultadoDeConversion;
    }

    @Override
    public String toString() {
        return String.format("%s - El valor de %.2f [%s] equivale a => %.2f [%s]",
                fechaHoraConversion,
                montoDeConversion,
                codigoMonedaBase,
                resultadoDeConversion,
                codigoMonedaFinal);
    }
}
