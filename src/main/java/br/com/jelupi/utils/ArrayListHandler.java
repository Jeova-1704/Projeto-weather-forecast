package br.com.jelupi.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayListHandler {
    /**
     * Informa a média dos valores numéricos fornecidos na String
     * @param arrayList {@link  ArrayList} o qual deseja verificar
     * @return {@link Float} com a média dos números
     * @param <T> Classe dos objetos do {@link ArrayList} especificado
     */
    public static <T extends Number> Float getMedia(ArrayList<T> arrayList) {
        if (!arrayList.isEmpty()) {
            float soma = 0;
            for (T numero : arrayList) {
                soma += numero.floatValue();
            }

            return soma / arrayList.size();
        } else {
            return null;
        }
    }


    /**
     * Informa a String mais repetida dentre aquelas presentes no {@link ArrayList}
     * @param arrayList {@link ArrayList} o qual deseja verificar
     * @return {@link String} com a palavra mais repetida
     */
    public static String getPalavraRecorrente(ArrayList<String> arrayList) {
        Set<String> conjunto = new HashSet<>(arrayList.stream().toList());

        String palavraMaisRepetida = "";
        int qnt = 0;

        for (String setCondition : conjunto){
            int qntAux = 0;

            for (String mapContidition : arrayList.stream().toList()) {
                if (setCondition.equals(mapContidition)) {
                    qntAux++;
                }
            }

            if (qnt == 0 || qntAux > qnt) {
                qnt = qntAux;
                palavraMaisRepetida = setCondition;
            }
        }

        return palavraMaisRepetida;
    }


    /**
     * Cria um {@link ArrayList} com elementos do {@link Class} especificada
     * @param arrayList {@link ArrayList} a partir do qual obterá o novo {@link ArrayList} pós casting
     * @param objectType {@link Class} para a qual deseja realizar o casting
     * @param <V> Classe dos objetos do {@link ArrayList}
     * @param <T> {@link Class} especificada para o casting
     * @return Novo {@link ArrayList} com elementos da {@link Class} especificada
     */
    public static <V, T> ArrayList<T> CastArrayList(ArrayList<V> arrayList, Class<T> objectType) {
        try {
            if (Number.class.isAssignableFrom(objectType)) {
                return castNumberArrayList(arrayList, objectType);
            }
            else if (objectType.isInstance(arrayList.get(0))) {
                ArrayList<T> newArrayList = new ArrayList<>();
                for (V object : arrayList) {
                    newArrayList.add(objectType.cast(object));
                }
                return newArrayList;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        catch (ClassCastException e) {
            System.err.println("O ArrayList fornecido não possui objetos do mesmo tipo:" + e.getMessage());
        }
        catch (NullPointerException | IllegalArgumentException e1 ) {
            System.err.println("Não foi possível realizar o casting:" + e1.getMessage());
        }
        return new ArrayList<>();
    }


    /**
     * Utilizado na função {@link ArrayListHandler#CastArrayList(ArrayList, Class)} para tratar o casting de números
     * @param arrayList {@link ArrayList} a partir do qual obterá o novo {@link ArrayList} pós casting
     * @param objectType {@link Class} para a qual deseja realizar o casting
     * @param <V> Classe dos objetos do {@link ArrayList}
     * @param <T> {@link Class} especificada para o casting
     * @return Novo {@link ArrayList} com elementos da {@link Class} especificada
     */
    private static <V, T> ArrayList<T> castNumberArrayList(ArrayList<V> arrayList, Class<T> objectType) {
        ArrayList<T> newArrayList = new ArrayList<>();
        if (Float.class == objectType) {
            for (V object : arrayList) {
                newArrayList.add(objectType.cast(((Number) object).floatValue()));
            }
        }
        else if (Double.class == objectType) {
            for (V object : arrayList) {
                newArrayList.add(objectType.cast(((Number) object).doubleValue()));
            }
        }
        else if (Integer.class == objectType) {
            for (V object : arrayList) {
                newArrayList.add(objectType.cast(((Number) object).intValue()));
            }
        }
        else if (Byte.class == objectType) {
            for (V object : arrayList) {
                newArrayList.add(objectType.cast(((Number) object).byteValue()));
            }
        }
        else if (Long.class == objectType) {
            for (V object : arrayList) {
                newArrayList.add(objectType.cast(((Number) object).longValue()));
            }
        }

        else if (Short.class == objectType) {
            for (V object : arrayList) {
                newArrayList.add(objectType.cast(((Number) object).shortValue()));
            }
        }

        return newArrayList;
    }

}
