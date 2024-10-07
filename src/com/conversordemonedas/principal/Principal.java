package com.conversordemonedas.principal;

import com.conversordemonedas.modulos.ConsultaTasaCambioApi;
import com.conversordemonedas.modulos.ConversionDeMoneda;
import com.conversordemonedas.modulos.HistorialDeConversiones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String MENU = """
                    *********************************************
                    ***** BIENVENID@ AL CONVERSOR DE MONEDA *****
                    *********************************************
                    
                     1) Dólar ==> Peso chileno
                     2) Peso chileno ==> Dólar
                     3) Dólar ==> Peso argentino
                     4) Peso argentino ==> Dólar
                     5) Dólar  ==> Real brasileño
                     6) Real Brasileño ==> Dólar
                     7) Dólar ==> Peso colombiano
                     8) Peso colombiano ==> Dólar
                     9) Salir
                    
                    *********************************************
                    """;

        Map<Integer, String[]> opcionesConversion = Map.of(
                1, new String[]{"USD", "CLP"},
                2, new String[]{"CLP", "USD"},
                3, new String[]{"USD", "ARS"},
                4, new String[]{"ARS", "USD"},
                5, new String[]{"USD", "BRL"},
                6, new String[]{"BRL", "USD"},
                7, new String[]{"USD", "COP"},
                8, new String[]{"COP", "USD"}
        );

        ArrayList<ConversionDeMoneda> conversionesDeMonedas = new ArrayList<>();


        try (Scanner teclado = new Scanner(System.in)) {
            ConsultaTasaCambioApi consulta = new ConsultaTasaCambioApi();

            while (true) {
                System.out.println(MENU);
                System.out.print("Escribe una opción del menu: ");

                int operacionMenu = leerOpcion(teclado);

                if (operacionMenu == 9) {
                    System.out.println("Has salido de la aplicación Conversor de Monedas.");
                    HistorialDeConversiones historial = new HistorialDeConversiones();
                    historial.guardarJson(conversionesDeMonedas);
                    break;
                }

                if (opcionesConversion.containsKey(operacionMenu)) {
                    double monto = leerMonto(teclado);
                    String[] monedas = opcionesConversion.get(operacionMenu);
                    String monedaOrigen = monedas[0];
                    String monedaDestino = monedas[1];
                    ConversionDeMoneda conversion = new ConversionDeMoneda(consulta.tasaConversion(monedaOrigen), monedaDestino, monto);
                    System.out.println(conversion);
                    conversionesDeMonedas.add(conversion);
                } else {
                    System.out.println("Debe escribir una opción válida! \n");
                }
            }
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static int leerOpcion(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            System.out.print("Por favor escribe un número válido: ");
            teclado.next();
        }
        return teclado.nextInt();
    }

    private static double leerMonto(Scanner teclado) {
        System.out.print("Escribe el monto de dinero a convertir: ");
        while (!teclado.hasNextDouble()) {
            System.out.print("Por favor ingrese un monto válido: ");
            teclado.next();
        }
        return teclado.nextDouble();
    }
}

