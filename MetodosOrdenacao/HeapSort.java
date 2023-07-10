package MetodosOrdenacao;

public class HeapSort {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe HeapSort -------------------------------------

	private static long comparacoes;
    private static long trocas;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **HEAP SORT**

    public static void heapSort(int[] array) {
        comparacoes = 0;
        trocas = 0;

        int tamanho = array.length;

        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(array, tamanho, i);
        }

        for (int i = tamanho - 1; i > 0; i--) {
            trocarElementos(array, 0, i);
            trocas++; // **TROCA**

            heapify(array, i, 0);
        }
        
        comparacoes = (long) (tamanho * (Math.log(tamanho) / Math.log(2))); // **COMPARAÇÃO**
        
        System.out.println(getSort());
       
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **DIVIDE O ARRAY EM DIREITA E ESQUEDA **

    private static void heapify(int[] array, int tamanho, int indiceRaiz) {
        int maior = indiceRaiz;
        int filhoEsquerda = 2 * indiceRaiz + 1;
        int filhoDireita = 2 * indiceRaiz + 2;

        if (filhoEsquerda < tamanho && array[filhoEsquerda] > array[maior]) {
            maior = filhoEsquerda;
        }

        if (filhoDireita < tamanho && array[filhoDireita] > array[maior]) {
            maior = filhoDireita;
        }

        if (maior != indiceRaiz) {
            trocarElementos(array, indiceRaiz, maior);
            trocas++; // **TROCA**

            heapify(array, tamanho, maior);
        }
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **FAZ A TROCA DOS ELEMENTOS**

    private static void trocarElementos(int[] array, int indice1, int indice2) {
        int temp = array[indice1];
        array[indice1] = array[indice2];
        array[indice2] = temp;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe HeapSort -------------------------------------	
    public static String getSort() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------------------\n");
        builder.append("Operações => " + comparacoes + "\n");
        builder.append("Trocas => " + trocas);
        return builder.toString();
    }
}

