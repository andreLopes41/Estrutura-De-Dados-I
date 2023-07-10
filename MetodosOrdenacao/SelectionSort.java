package MetodosOrdenacao;

public class SelectionSort {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe SelectionSort -------------------------------------
	
    private static long comparacoes;
    private static long trocas;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //   **SELECTION SORT**

    public static void selectionSort(int[] array) {
    	
    	comparacoes = 0;
        trocas = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++; // **COMPARAÇÃO**
                if (array[j] < array[indiceMin]) {
                    indiceMin = j;
                }
            }
            if (indiceMin != i) {
                int temp = array[indiceMin];
                array[indiceMin] = array[i];
                array[i] = temp;
                trocas++; // **TROCA**
            }
        }
        
        System.out.println(getSort());
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe SelectionSort -------------------------------------
    
    public static String getSort() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------------------\n");
        builder.append("Operações => " + comparacoes + "\n");
        builder.append("Trocas => " + trocas);
        return builder.toString();
    }
}