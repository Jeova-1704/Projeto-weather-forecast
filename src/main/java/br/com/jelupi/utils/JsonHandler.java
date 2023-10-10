package br.com.jelupi.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.util.*;

/**
 * Utilitário com ferramentas destinadss à manipulação de dados armazenados em formato Json
 */
public class JsonHandler {

    // FERRAMENTAS

    /**
     * Gera um {@link HashMap} com pares de keys e values correspondentes àqueles encontrados no Json
     *
     * @param jsonRequest Json do qual deseja extrair os dados
     * @param keys        Chaves as quais você deseja buscar
     * @return {@link HashMap} com os dados
     */
    public static HashMap<String, Object> extractJsonToHashMap(String jsonRequest, String... keys) {
        JsonElement jsonElement = JsonParser.parseString(jsonRequest);
        HashMap<String, Object> jsonHashMap = new HashMap<>();

        searchJsonItemsToInsert(jsonElement, jsonHashMap, keys);

        return jsonHashMap;
    }

    public static HashMap<String, Object> extractJsonToHashMap(String jsonRequest) {
        JsonElement jsonElement = JsonParser.parseString(jsonRequest);
        HashMap<String, Object> jsonHashMap = new HashMap<>();

        searchJsonItemsToInsert(jsonElement, jsonHashMap);

        return jsonHashMap;
    }

    public static ArrayList<Object> extractJsonArrayToArrayList(String jsonRequest) {
        JsonElement jsonElement = JsonParser.parseString(jsonRequest);
        ArrayList<Object> jsonArray = new ArrayList<>();

        searchJsonItemsToInsert(jsonElement, jsonArray);

        return jsonArray;
    }


    // MÉTODOS AUXILIARES

    /**
     * Realiza uma busca percorrendo os items do {@link JsonElement}
     *
     * @param jsonElement Elemento Json a partir do qual deseja obter os dados
     * @param jsonHashMap {@link HashMap} no qual deseja inserir os dados
     * @param keys        Chaves as quais você deseja buscar
     */
    private static void searchJsonItemsToInsert(JsonElement jsonElement, HashMap<String, Object> jsonHashMap, String... keys) {

        if (!jsonElement.isJsonNull() && keys.length != 0) {
            if (jsonElement.isJsonArray()) {
                for (JsonElement jsonItem : jsonElement.getAsJsonArray()) {
                    searchJsonItemsToInsert(jsonItem, jsonHashMap, keys);
                }
            } else if (jsonElement.isJsonObject()) {
                for (Map.Entry<String, JsonElement> jsonItem : jsonElement.getAsJsonObject().entrySet()) {
                    if (Arrays.stream(keys).anyMatch(key -> key.equals(jsonItem.getKey()))) {
                        keys = removeKeyFromArray(keys, jsonItem.getKey());
                        insertValue(jsonItem.getKey(), jsonItem.getValue(), jsonHashMap);
                    } else {
                        searchJsonItemsToInsert(jsonItem.getValue(), jsonHashMap, keys);
                    }
                }
            }
        }

    }


    private static void searchJsonItemsToInsert(JsonElement jsonElement, HashMap<String, Object> jsonHashMap) {

        if (!jsonElement.isJsonNull()) {
            if (jsonElement.isJsonArray()) {
                for (JsonElement jsonItem : jsonElement.getAsJsonArray()) {
                    searchJsonItemsToInsert(jsonItem, jsonHashMap);
                }
            } else if (jsonElement.isJsonObject()) {
                for (Map.Entry<String, JsonElement> jsonItem : jsonElement.getAsJsonObject().entrySet()) {
                    insertValue(jsonItem.getKey(), jsonItem.getValue(), jsonHashMap);
                }
            }
        }

    }


    private static void searchJsonItemsToInsert(JsonElement jsonElement, ArrayList<Object> jsonArray) {
        if (!jsonElement.isJsonNull() && jsonElement.isJsonArray()) {
            for (JsonElement jsonItem : jsonElement.getAsJsonArray()) {
                insertValue(jsonItem, jsonArray);
            }
        }
    }


    /**
     * Insere os dados do Json no {@link HashMap}
     *
     * @param key         chave do valor o qual será passado
     * @param value       {@link JsonElement} contendo o valor a ser salvo
     * @param jsonHashMap {@link HashMap} no qual deseja inserir os dados
     */
    private static void insertValue(String key, JsonElement value, HashMap<String, Object> jsonHashMap) {
        Gson gson = new Gson();
        String valueJson = gson.toJson(value);

        if (value.isJsonNull()) {
            jsonHashMap.put(key, null);
        } else if (value.isJsonObject()) {
            jsonHashMap.put(key, extractJsonToHashMap(valueJson));
        } else if (value.isJsonArray()) {
            jsonHashMap.put(key, extractJsonArrayToArrayList(valueJson));
        } else if (value.isJsonPrimitive()) {
            checkAndInsertJsonPrimitiveValue(key, value.getAsJsonPrimitive(), jsonHashMap);
        }

    }

    private static void insertValue(JsonElement value, ArrayList<Object> jsonArray) {
        Gson gson = new Gson();
        String valueJson = gson.toJson(value);

        if (value.isJsonNull()) {
            jsonArray.add(null);
        } else if (value.isJsonObject()) {
            jsonArray.add(extractJsonToHashMap(valueJson));
        } else if (value.isJsonArray()) {
            jsonArray.add(extractJsonArrayToArrayList(valueJson));
        } else if (value.isJsonPrimitive()) {
            checkAndInsertJsonPrimitiveValue(value.getAsJsonPrimitive(), jsonArray);
        }

    }


    /**
     * Verifica o tipo do valor armazenado no {@link JsonPrimitive} passado
     * e insere os dados no {@link HashMap} especificado
     *
     * @param key         chave do valor a ser inserido
     * @param value       {@link JsonPrimitive} do qual será extraído o valor
     * @param jsonHashMap {@link HashMap} no qual será guardado os dados
     */
    private static void checkAndInsertJsonPrimitiveValue(String key, JsonPrimitive value, HashMap<String, Object> jsonHashMap) {
        if (value.isBoolean()) {
            jsonHashMap.put(key, value.getAsBoolean());
        } else if (value.isNumber()) {
            if (value.getAsString().contains(".")) {
                jsonHashMap.put(key, value.getAsFloat());
            } else {
                jsonHashMap.put(key, value.getAsInt());
            }
        } else {
            jsonHashMap.put(key, value.getAsString());
        }

    }


    private static void checkAndInsertJsonPrimitiveValue(JsonPrimitive value, ArrayList<Object> jsonArray) {
        if (value.isBoolean()) {
            jsonArray.add(value.getAsBoolean());
        } else if (value.isNumber()) {
            if (value.getAsString().contains(".")) {
                jsonArray.add(value.getAsFloat());
            } else {
                jsonArray.add(value.getAsInt());
            }
        } else {
            jsonArray.add(value.getAsString());
        }

    }


    private static String[] removeKeyFromArray(String[] array, String keyToBeRemoved) {
        List<String> lista = new ArrayList<>(Arrays.stream(array).toList());
        for (String value : lista) {
            if (value.equals(keyToBeRemoved)) {
                lista.remove(keyToBeRemoved);
                break;
            }
        }
        return lista.toArray(new String[0]);
    }


}

