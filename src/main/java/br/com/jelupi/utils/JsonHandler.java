package br.com.jelupi.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Utilitário com ferramentas destinadss à manipulação de dados armazenados em formato Json
 */
public class JsonHandler {

    // FERRAMENTAS

    /**
     * Gera um {@link HashMap} com pares de keys e values correspondentes àqueles encontrados no Json
     * @param jsonRequest Json do qual deseja extrair os dados
     * @param keys Chaves as quais você deseja buscar
     * @return {@link HashMap} com os dados
     */
    public static HashMap<String , Object> extractJason(String jsonRequest, String... keys){
        JsonElement jsonElement = JsonParser.parseString(jsonRequest);
        HashMap<String, Object> jsonHashMap = new HashMap<>();

        searchJsonItems(jsonElement, jsonHashMap, keys);

        return jsonHashMap;
    }


    // MÉTODOS AUXILIARES

    /**
     * Realiza uma busca percorrendo os items do {@link JsonElement}
     * @param jsonElement Elemento Json a partir do qual deseja obter os dados
     * @param jsonHashMap {@link HashMap} no qual deseja inserir os dados
     * @param keys Chaves as quais você deseja buscar
     */
    private static void searchJsonItems(JsonElement jsonElement, HashMap<String, Object> jsonHashMap, String[] keys) {
        if (!jsonElement.isJsonNull()) {
            if (jsonElement.isJsonArray()) {
                for (JsonElement jsonItem : jsonElement.getAsJsonArray()) {
                    searchJsonItems(jsonItem, jsonHashMap, keys);
                }
            }
            else if (jsonElement.isJsonObject()) {
                for (Map.Entry<String, JsonElement> jsonItem : jsonElement.getAsJsonObject().entrySet()) {
                    if (Arrays.stream(keys).anyMatch(key -> key.equals(jsonItem.getKey()))) {
                        insertValue(jsonItem.getKey(), jsonItem.getValue().getAsJsonPrimitive(), jsonHashMap);
                    }
                }
            }
        }

    }


    /**
     * Insere os dados do Json no {@link HashMap}
     * @param key chave do valor o qual será passado
     * @param value {@link JsonElement} contendo o valor a ser salvo
     * @param jsonHashMap {@link HashMap} no qual deseja inserir os dados
     */
    private static void insertValue (String key, JsonElement value, HashMap<String, Object> jsonHashMap) {
        if (value.isJsonNull()) {
            jsonHashMap.put(key, null);
        }
        else if (value.isJsonObject()) {
            jsonHashMap.put(key, value.getAsJsonObject());
        }
        else if (value.isJsonArray()) {
            jsonHashMap.put(key, value.getAsJsonArray());
        }
        else if (value.isJsonPrimitive()) {
            checkAndInsertJsonPrimitiveValue(key, value.getAsJsonPrimitive(), jsonHashMap);
        }

    }


    /**
     * Verifica o tipo do valor armazenado no {@link JsonPrimitive} passado
     * e insere os dados no {@link HashMap} especificado
     * @param key chave do valor a ser inserido
     * @param value {@link JsonPrimitive} do qual será extraído o valor
     * @param jsonHashMap {@link HashMap} no qual será guardado os dados
     */
    private static void checkAndInsertJsonPrimitiveValue(String key, JsonPrimitive value, HashMap<String, Object> jsonHashMap) {
        if (value.isBoolean()) {
            jsonHashMap.put(key, value.getAsBoolean());
        }
        else if (value.isNumber()) {
            if (value.getAsString().contains(".")) {
                jsonHashMap.put(key, value.getAsFloat());
            }
            else {
                jsonHashMap.put(key, value.getAsInt());
            }
        }
        else {
            jsonHashMap.put(key, value.getAsString());
        }

    }


}

