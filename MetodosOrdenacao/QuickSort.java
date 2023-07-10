package MetodosOrdenacao;

public class QuickSort {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe QuickSort -------------------------------------
	
    private static long comparacoes;
    private static long trocas;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **QUICK SORT**

    public static void quickSort(int[] array) {
        comparacoes = 0;
        trocas = 0;
        quickSort(array, 0, array.length - 1);
        System.out.println(getSort());
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//   **FAZ A ORDENAÇÃO**
    
    public static void quickSort(int X[], int inicio, int fim) {
        if (inicio < fim) {
            int q = particao(X, inicio, fim);
            quickSort(X, inicio, q);
            quickSort(X, q + 1, fim);
        }
        comparacoes++; // **COMPARAÇÃO**
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **PARTICIONA A ORDENAÇÃO**

    private static int particao(int X[], int inicio, int fim) {
        int pivo, i, j, aux;
        pivo = X[(inicio + fim) / 2];
        i = inicio - 1;
        j = fim + 1;

        while (i < j) {
            do {
                j = j - 1;
            } while (X[j] > pivo);

            do {
                i = i + 1;
            } while (X[i] < pivo);

            if (i < j) {
                aux = X[i];
                X[i] = X[j];
                X[j] = aux;
                trocas++; // **TROCA**
            }
        }
        comparacoes = comparacoes + (j - inicio) + (fim - j + 1); // **COMPARAÇÃO**
        return j;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe QuickSort -------------------------------------
    
    public static String getSort() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------------------\n");
        builder.append("Operações => " + comparacoes + "\n");
        builder.append("Trocas => " + trocas);
        return builder.toString();
    }
}