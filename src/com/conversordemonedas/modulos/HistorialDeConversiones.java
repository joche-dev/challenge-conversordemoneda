package com.conversordemonedas.modulos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HistorialDeConversiones {
    public void guardarJson(ArrayList<ConversionDeMoneda> conversionesDeMonedas) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("HistorialDeConversiones.json");
        escritura.write(gson.toJson(conversionesDeMonedas));
        escritura.close();
    }
}
