package com.conversordemonedas.modulos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HistorialDeConversiones {

    private static final String ARCHIVO = "HistorialDeConversiones.json";

    public void guardarJson(ArrayList<ConversionDeMoneda> conversionesDeMonedas){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try{
            FileWriter escritura = new FileWriter(ARCHIVO);
            escritura.write(gson.toJson(conversionesDeMonedas));
            escritura.close();
            System.out.println("El historial de conversiones se ha guardado correctamente en " + ARCHIVO);
        }catch (IOException e){
            System.out.println("Error al guardar el historial de conversiones: " + e.getMessage());
        }

    }
}
