package com.estebanvm.conversor;

import com.estebanvm.conversor.configs.Config;
import com.estebanvm.conversor.constants.Currencies;
import com.estebanvm.conversor.models.Conversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        Config config = new Config();
        var apiKey = config.get("API_KEY");

        while (true) {
            try {
                showMenu();

                int option = scanner.nextInt();
                String baseCode, baseName, targetCode, targetName;

                switch (option) {
                    // De dólar a euro
                    case 1: {
                        baseCode = Currencies.US_DOLLAR_CODE;
                        baseName = Currencies.US_DOLLAR_NAME;
                        targetCode = Currencies.EURO_CODE;
                        targetName = Currencies.EURO_NAME;
                        break;
                    }
                    // De euro a dólar
                    case 2: {
                        baseCode = Currencies.EURO_CODE;
                        baseName = Currencies.EURO_NAME;
                        targetCode = Currencies.US_DOLLAR_CODE;
                        targetName = Currencies.US_DOLLAR_NAME;
                        break;
                    }
                    // De dólar a peso argentino
                    case 3: {
                        baseCode = Currencies.US_DOLLAR_CODE;
                        baseName = Currencies.US_DOLLAR_NAME;
                        targetCode = Currencies.ARGENTINE_PESO_CODE;
                        targetName = Currencies.ARGENTINE_PESO_NAME;
                        break;
                    }
                    // De peso argentino a dólar
                    case 4: {
                        baseCode = Currencies.ARGENTINE_PESO_CODE;
                        baseName = Currencies.ARGENTINE_PESO_NAME;
                        targetCode = Currencies.US_DOLLAR_CODE;
                        targetName = Currencies.US_DOLLAR_NAME;
                        break;
                    }
                    // De dólar a real brasileño
                    case 5: {
                        baseCode = Currencies.US_DOLLAR_CODE;
                        baseName = Currencies.US_DOLLAR_NAME;
                        targetCode = Currencies.BRAZILIAN_REAL_CODE;
                        targetName = Currencies.BRAZILIAN_REAL_NAME;
                        break;
                    }
                    // De real brasileño a dólar
                    case 6: {
                        baseCode = Currencies.BRAZILIAN_REAL_CODE;
                        baseName = Currencies.BRAZILIAN_REAL_NAME;
                        targetCode = Currencies.US_DOLLAR_CODE;
                        targetName = Currencies.US_DOLLAR_NAME;
                        break;
                    }
                    // De dólar a peso colombiano
                    case 7: {
                        baseCode = Currencies.US_DOLLAR_CODE;
                        baseName = Currencies.US_DOLLAR_NAME;
                        targetCode = Currencies.COLOMBIAN_PESO_CODE;
                        targetName = Currencies.COLOMBIAN_PESO_NAME;
                        break;
                    }
                    // De peso colombiano a dólar
                    case 8: {
                        baseCode = Currencies.COLOMBIAN_PESO_CODE;
                        baseName = Currencies.COLOMBIAN_PESO_NAME;
                        targetCode = Currencies.US_DOLLAR_CODE;
                        targetName = Currencies.US_DOLLAR_NAME;
                        break;
                    }
                    // De dólar a guaraní
                    case 9: {
                        baseCode = Currencies.US_DOLLAR_CODE;
                        baseName = Currencies.US_DOLLAR_NAME;
                        targetCode = Currencies.GUARANI_CODE;
                        targetName = Currencies.GUARANI_NAME;
                        break;
                    }
                    // De guaraní a dólar
                    case 10: {
                        baseCode = Currencies.GUARANI_CODE;
                        baseName = Currencies.GUARANI_NAME;
                        targetCode = Currencies.US_DOLLAR_CODE;
                        targetName = Currencies.US_DOLLAR_NAME;
                        break;
                    }
                    // Salir
                    case 11: {
                        scanner.close();

                        if (!history.isEmpty()) {
                            FileWriter writer = new FileWriter("historial.txt", true);

                            for (String entry : history) {
                                writer.write(entry);
                            }

                            writer.close();
                            System.out.println("Historial de conversiones guardado.");
                        }

                        System.out.println("¡Hasta la próxima!");
                        return;
                    }
                    default: {
                        System.out.println("¡Opción inválida!");
                        continue;
                    }
                }

                System.out.println("Ingrese el valor que desea convertir (de " + baseName + " a " + targetName + "):");

                double amount = scanner.nextDouble();

                String url = "https://v6.exchangerate-api.com/v6/"
                        + apiKey
                        + "/pair/"
                        + baseCode
                        + "/"
                        + targetCode
                        + "/"
                        + amount;

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                client.close();

                String json = response.body();
                Conversion conversion = gson.fromJson(json, Conversion.class);

                String entry = conversion.makeHistoryEntry(amount);
                history.add(entry);

                String result = "El valor " + amount
                        + " " + baseCode + " "
                        + "corresponde al valor final de "
                        + conversion.conversion_result()
                        + " " + targetCode + "\n";

                System.out.println(result);
            } catch (Exception e) {
                scanner.close();
                System.out.println("Ocurrió un error:");
                System.out.println(e.getClass().getSimpleName());
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n**********************************");
        System.out.println("¡Bienvenido/a al conversor de monedas!");
        System.out.println("Elija una opción válida:");
        System.out.println("1) De " + Currencies.US_DOLLAR_NAME + " a " + Currencies.EURO_NAME);
        System.out.println("2) De " + Currencies.EURO_NAME + " a " + Currencies.US_DOLLAR_NAME);
        System.out.println("3) De " + Currencies.US_DOLLAR_NAME + " a " + Currencies.ARGENTINE_PESO_NAME);
        System.out.println("4) De " + Currencies.ARGENTINE_PESO_NAME + " a " + Currencies.US_DOLLAR_NAME);
        System.out.println("5) De " + Currencies.US_DOLLAR_NAME + " a " + Currencies.BRAZILIAN_REAL_NAME);
        System.out.println("6) De " + Currencies.BRAZILIAN_REAL_NAME + " a " + Currencies.US_DOLLAR_NAME);
        System.out.println("7) De " + Currencies.US_DOLLAR_NAME + " a " + Currencies.COLOMBIAN_PESO_NAME);
        System.out.println("8) De " + Currencies.COLOMBIAN_PESO_NAME + " a " + Currencies.US_DOLLAR_NAME);
        System.out.println("9) De " + Currencies.US_DOLLAR_NAME + " a " + Currencies.GUARANI_NAME);
        System.out.println("10) De " + Currencies.GUARANI_NAME + " a " + Currencies.US_DOLLAR_NAME);
        System.out.println("11) Salir");
        System.out.println("**********************************\n");
    }
}
