package com.conversordemonedas.modulos;

import java.util.Map;

public record MonedaOmdb(String base_code, Map<String, Double> conversion_rates) {
}
