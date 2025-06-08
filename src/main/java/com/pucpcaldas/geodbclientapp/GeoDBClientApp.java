package com.pucpcaldas.geodbclientapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe responsável por consultar a API GeoDB Cities
 * e exibir informações de cidades com base no prefixo do nome.
 */
public class GeoDBClientApp {

    // Chave de API para autenticação com o serviço GeoDB
    // YES!!!!!!!!!!!!! THE KEY IS HERE IN THE CODE
    private static final String API_KEY = "1bfdcb4a86mshf4ee4ce59811ec7p188cecjsn49c81557acb2";

    /**
     * Método que realiza uma requisição HTTP para a API GeoDB Cities
     * buscando cidades com um determinado prefixo no nome.
     *
     * @param namePrefix Prefixo do nome da cidade a ser pesquisada.
     */
    public void searchCities(String namePrefix) {
        try {
            // Monta a URL da requisição com o prefixo informado e limite de resultados
            String urlStr = "https://wft-geo-db.p.rapidapi.com/v1/geo/cities?namePrefix=" + namePrefix + "&limit=5";
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Define o método HTTP e cabeçalhos de autenticação
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-RapidAPI-Key", API_KEY);
            conn.setRequestProperty("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");

            // Lê a resposta da API linha por linha
            StringBuilder json;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
            }

            // Chama o método para formatar e exibir a resposta JSON
            formatarResposta(json.toString());

        } catch (IOException e) {
            // Exibe mensagem de erro caso a requisição falhe
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Método responsável por formatar e exibir os dados recebidos da API.
     *
     * @param jsonString Resposta da API em formato JSON (como String).
     */
    public void formatarResposta(String jsonString) {
        // Converte a string JSON em objeto JSON
        JSONObject json = new JSONObject(jsonString);
        JSONArray cidades = json.getJSONArray("data");

        // Exibe cabeçalho do resultado
        System.out.println("--------------------------------------------");
        System.out.println("-- --------------- OUTPUT --------------- --");

        // Itera pelas cidades e imprime informações relevantes
        for (int i = 0; i < cidades.length(); i++) {
            JSONObject cidade = cidades.getJSONObject(i);
            System.out.println("--------------------------------------------");
            System.out.println("📍🖈 Cidade: " + cidade.getString("name"));
            System.out.println("🌍 País: " + cidade.getString("country") + " (" + cidade.getString("countryCode") + ")");
            System.out.println("🏞 Região: " + cidade.getString("region") + " (" + cidade.getString("regionCode") + ")");
            System.out.println("📌✶ Coordenadas: " + cidade.getDouble("latitude") + ", " + cidade.getDouble("longitude"));
            System.out.println("👥🕇 População: " + cidade.getInt("population"));
            System.out.println("--------------------------------------------");
        }
    }
}
