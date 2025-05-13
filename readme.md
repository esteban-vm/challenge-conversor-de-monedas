# Conversor de Monedas

**_Conversor de Monedas_** es una aplicación de consola que permite convertir un valor ingresado de una moneda
determinada y
el dólar estadounidense, y viceversa; utilizando tasas de cambio en tiempo real.

## Funcionalidades

- Interfaz de consola basada en selección de menús.
- Conversión de las siguientes monedas a dólar (y viceversa): euro, peso argentino, real brasileño, peso colombiano y
  guaraní.
- Tasas de cambio actualizadas a través del servicio de [**ExchangeRate-API**](https://www.exchangerate-api.com/).
- Guardado local automático de las últimas conversiones en un archivo `.json` luego de salir del programa.
- Manejo y control de errores.

## Uso

1. Clonar este repositorio:

        git clone https://github.com/esteban-vm/challenge-conversor-de-monedas

2. Navegar a la carpeta del proyecto:

        cd challenge-conversor-de-monedas/
3. Verificar que Java esté instalado:

        java -version
4. Abrir la carpeta en un IDE (como IntelliJ IDEA).
5. En la carpeta `src` crear un archivo `.env` que contenga una variable de entorno con la clave `API_KEY` y con el
   valor proporcionado por [**ExchangeRate-API**](https://www.exchangerate-api.com/).
6. Agregar las siguientes bibliotecas:

    - [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
    - [Dotenv Java](https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java)
7. Ejecutar el programa desde el método _main_ de la clase **Conversor**.