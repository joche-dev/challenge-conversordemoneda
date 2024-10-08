﻿# Challenge ONE Back End - Conversor de Monedas

 ![image](https://github.com/user-attachments/assets/4ecc4c69-2a6b-4a0c-bb97-42be482d76a0)

## Descripción
Este proyecto es un conversor de monedas que permite realizar conversiones entre distintas divisas. Utiliza la API Exchange Rate para obtener tasas de cambio actualizadas en tiempo real, procesando y filtrando datos en formato JSON. Para más detalles sobre la API, visita su sitio web: [Exchange Rate API](https://www.exchangerate-api.com/).

## Funcionalidades
- **Interfaz de Usuario Sencilla**: Ofrece una interfaz fácil de usar a través de la consola.
- **Conversión de Monedas**: Permite convertir entre diversas monedas con facilidad.
- **Tasas de Cambio en Tiempo Real**: Obtiene las tasas de cambio actuales mediante la integración con una API.
- **Historial de Conversiones**: Mantiene un registro de las conversiones recientes, mostrando una lista completa de las transacciones realizadas.
- **Registros con Marca de Tiempo**: Almacena detalles de cada conversión, incluyendo las monedas utilizadas y el momento exacto en que se realizó.

## Recursos Utilizados
- **Entorno de Desarrollo**: IntelliJ IDEA Community Edition
- **Lenguaje**: Java 17.0.10
- **Librería JSON**: Gson 2.11.0
- **API de Tasas de Cambio**: Exchange Rate API

## Instrucciones para Ejecutar el Proyecto Localmente
Sigue estos pasos para ejecutar el proyecto en tu entorno local:

1. **Clonar el Repositorio**:
   ```bash
    git clone https://github.com/joche-dev/appusuarios-frontend.git
    ```
2. **Abrir el Proyecto en IntelliJ y Configurar la Dependencia de Gson**: 
    1. Tienes que tener descargada la libreria Gson del sitio web Maven Repository.
    2. Haz clic derecho sobre la carpeta del proyecto en el panel izquierdo.
    3. Selecciona "Open Module Settings" en el menú contextual.
    4. En la ventana que se abre, ve a la pestaña "Dependencies".
    5. Haz clic en el signo "+" en la esquina inferior izquierda y elige "Library".
    6. Busca "gson" en el cuadro de búsqueda.
    7. Selecciona la versión de Gson que desees utilizar.
    8. Haz clic en "OK" para cerrar la ventana.
4. **Compilar y Ejecutar el Archivo Principal**: Navega al archivo Principal.java, compílalo y ejecútalo para comenzar a utilizar el conversor de monedas.
