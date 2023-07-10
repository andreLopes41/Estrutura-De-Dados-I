package MetodosOrdenacao;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe BucketSort -------------------------------------
	
    private static long comparacoes;
    private static long trocas;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **BUCKET SORT**

    public static void bucketSort(int[] array) {
        comparacoes = 0;
        trocas = 0;

        int max = max(array);
        int numBuckets = (int) Math.sqrt(array.length);
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int valor : array) {
            int indiceBucket = valor * numBuckets / (max + 1);
            buckets.get(indiceBucket).add(valor);
        }

        int indice = 0;
        for (List<Integer> bucket : buckets) {
            int[] contadores = ordenaPorInsercao(bucket);
            comparacoes = comparacoes + contadores[0]; // **COMPARAÇÃO**
            trocas = trocas + contadores[1]; // **TROCA**
            for (int valor : bucket) {
                array[indice++] = valor;
            }
        }

        System.out.println(getSort());
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **ORDENA O BUCKET**
    
    private static int[] ordenaPorInsercao(List<Integer> lista) {
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 1; i < lista.size(); i++) {
            int chave = lista.get(i);
            int j = i - 1;

            comparacoes++;
            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
                trocas++; // **TROCA**
                comparacoes++; // **COMPARAÇÃO**
            }
            lista.set(j + 1, chave);
        }

        return new int[]{comparacoes, trocas};
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **VERIFICA O VALOR MÁXIMO DO BUCKET**
    
    private static int max(int[] arr) {
        int max = arr[0];
        for (int valor : arr) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe BucketSort -------------------------------------	
    
    public static String getSort() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------------------\n");
        builder.append("Operações => " + comparacoes + "\n");
        builder.append("Trocas => " + trocas);
        return builder.toString();
    }
}