// Define o pacote onde a classe está localizada
package com.pucpcaldas.geodbclientapp;

// Classe principal da aplicação
public class Main {

    // Método principal, ponto de entrada da aplicação Java
    public static void main(String[] args) {
        
        // Cria uma instância da classe GeoDBClientApp,
        // que é responsável por interagir com o serviço GeoDB
        GeoDBClientApp geodb_client = new GeoDBClientApp();
        
        // Executa uma busca por cidades com o nome
        // Este é um exemplo de chamada de função para testar a aplicação
        geodb_client.searchCities("São José do Vale do Rio Preto");
    }
}
