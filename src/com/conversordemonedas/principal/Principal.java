package com.conversordemonedas.principal;

import com.conversordemonedas.modulos.ConsultaTasaCambioApi;
import com.conversordemonedas.modulos.ConversionDeMoneda;
import com.conversordemonedas.modulos.HistorialDeConversiones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    private static final String MENU = """
            *********************************************
            ***** BIENVENID@ AL CONVERSOR DE MONEDA *****
            *********************************************

             1) Dólar ==> Peso chileno
             2) Peso chileno ==> Dólar
             3) Dólar ==> Peso argentino
             4) Peso argentino ==> Dólar
             5) Dólar ==> Real brasileño
             6) Real Brasileño ==> Dólar
             7) Dólar ==> Peso colombiano
             8) Peso colombiano ==> Dólar
             9) Salir

            *********************************************
            """;

    private static final Map<Integer, String[]> OPCIONES_CONVERSION = Map.of(
            1, new String[]{"USD", "CLP"},
            2, new String[]{"CLP", "USD"},
            3, new String[]{"USD", "ARS"},
            4, new String[]{"ARS", "USD"},
            5, new String[]{"USD", "BRL"},
            6, new String[]{"BRL", "USD"},
            7, new String[]{"USD", "COP"},
            8, new String[]{"COP", "USD"}
    );

    private static final String REGEX_OPCIONMENU = "^[1-9]$";
    private static final String REGEX_VALIDACIONMONTO = "^[1-9]\\d*$";

    public static void main(String[] args) {
        ArrayList<ConversionDeMoneda> conversionesDeMonedas = new ArrayList<>();

        try (Scanner teclado = new Scanner(System.in)) {
            ConsultaTasaCambioApi consulta = new ConsultaTasaCambioApi();

            while (true) {
                System.out.println(MENU);

                int operacionMenu = leerOpcion(teclado, REGEX_OPCIONMENU);

                if (operacionMenu == 9) {
                    salirAplicacion(conversionesDeMonedas);
                    break;
                }

                if (OPCIONES_CONVERSION.containsKey(operacionMenu)) {
                    double monto = leerMonto(teclado, REGEX_VALIDACIONMONTO);
                    String[] monedas = OPCIONES_CONVERSION.get(operacionMenu);
                    String monedaOrigen = monedas[0];
                    String monedaDestino = monedas[1];
                    ConversionDeMoneda conversion = new ConversionDeMoneda(consulta.tasaConversion(monedaOrigen), monedaDestino, monto);
                    System.out.println(conversion);
                    conversionesDeMonedas.add(conversion);
                }
            }
        } catch (IOException e) {
            System.err.println("Error de conexión con la API: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private static int leerOpcion(Scanner teclado, String REGEX_OPCIONMENU) {
        System.out.print("Escribe una opción del menu: ");
        String input = teclado.nextLine();
        while (!input.matches(REGEX_OPCIONMENU)) {
            System.out.print("Solo tiene permitido ingresar un número entre 1 y 9: ");
            input = teclado.nextLine();
        }
        return Integer.parseInt(input);
    }

    private static double leerMonto(Scanner teclado, String REGEX_VALIDACIONMONTO) {
        System.out.print("Escribe el monto de dinero a convertir: ");
        String input = teclado.nextLine();
        while (!input.matches(REGEX_VALIDACIONMONTO)) {
            System.out.print("Por favor ingrese un monto de dinero válido a convertir: ");
            input = teclado.nextLine();
        }
        return Double.parseDouble(input);
    }

    private static void salirAplicacion(ArrayList<ConversionDeMoneda> conversionesDeMonedas) throws IOException {
        System.out.println("Has salido de la aplicación Conversor de Monedas.");
        HistorialDeConversiones historial = new HistorialDeConversiones();
        historial.guardarJson(conversionesDeMonedas);
    }
}

