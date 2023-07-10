package MetodosOrdenacao;

import java.util.Arrays;

public class MergeSort{
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe MergeSort -------------------------------------
	
    private static long comparacoes;
    private static long trocas;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **MERGE SORT**

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        comparacoes = 0;
        trocas = 0;
        sort(array, true);
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **FAZ A DIVISÃO DOS ARRAYS**

    private static void sort(int[] array, boolean topLevel) {
        if (array.length <= 1) {
            return;
        }
        int meio = array.length / 2;
        int[] esquerda = Arrays.copyOfRange(array, 0, meio);
        int[] direita = Arrays.copyOfRange(array, meio, array.length);

        sort(esquerda, false);
        sort(direita, false);

        mesclar(array, esquerda, direita);

        if (topLevel)
        	System.out.println(getSort());
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **VERIFICA AS POSIÇÕES DOS ELEMENTOS**

    private static void mesclar(int[] valores, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.length && j < direita.length) {
            comparacoes++; // **COMPARAÇÃO**
            if (esquerda[i] < direita[j]) {
                valores[k++] = esquerda[i++];
            } else {
                valores[k++] = direita[j++];
            }
            trocas++; // **TROCA**
        }
        while (i < esquerda.length) {
            valores[k++] = esquerda[i++];
            trocas++; // **TROCA**
        }
        while (j < direita.length) {
            valores[k++] = direita[j++];
            trocas++; // **TROCA**
        }
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe MergeSort -------------------------------------	
    
    public static String getSort() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------------------\n");
        builder.append("Operações => " + comparacoes + "\n");
        builder.append("Trocas => " + trocas);
        return builder.toString();
    }
}