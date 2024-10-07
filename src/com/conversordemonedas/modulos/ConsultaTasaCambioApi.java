package com.conversordemonedas.modulos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaCambioApi {
    String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    String API_KEY = "370a9a369a63bbd2d217d97e";

    public MonedaOmdb tasaConversion(String monedaBase) {
        URI direccion = URI.create(URL_BASE + API_KEY + "/latest/" + monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), MonedaOmdb.class);

        } catch (Exception e) {
            throw new RuntimeException("Error en la solicitud.");
        }
    }
}
