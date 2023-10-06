package br.com.jelupi.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Utilitário destinado à manipulação de requisições HTTP
 */

public class HttpRequestHandler {

    /**
     * Obtém uma {@link String} Json a partir de um http request (GET)
     * @param urlRequest Url do qual deseja obter o Json
     * @return {@link String} com os dados do Json obtido
     */
    public static String getJsonResponse(String urlRequest) {
        HttpRequest getRequest;               // Usado para fazer uma requisição com method "GET"
        HttpResponse<String> httpResponse;   // Encapsula os resultados da requisição
        HttpClient client;                  //  Cliente HTTP para receber a requisição e enviar o resultado

        try {
            client = HttpClient.newHttpClient();

            getRequest = HttpRequest.newBuilder()
                    .uri(new URI(urlRequest))
                    .GET().build();

            httpResponse =  client.send(getRequest, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.out.printf("Não foi possível acessar a API na seguinte URL: %s", urlRequest);
            return null;
        }

        return httpResponse.body();
    }
}
