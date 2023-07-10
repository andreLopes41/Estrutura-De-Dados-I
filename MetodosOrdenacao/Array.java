package MetodosOrdenacao;

import java.util.Arrays;
import java.util.Random;

import MetodosOrdenacao.Main.Algoritmo;

public class Array {
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Métodos -------------------------------------	
	
		//  **CRIA O ARRAY ORDENADO**
	
		public int[] Ordenado(int tamanho) {
			int[] array = new int[tamanho];
			for (int i = 0; i < tamanho; i++) {
				array[i] = i;
			}
			return array;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//   **CRIA O ARRAY INVERTIDO**

		public int[] Invertido(int tamanho) {
			int[] array = new int[tamanho];
			for (int i = 0; i < tamanho; i++) {
				array[i] = tamanho - i - 1;
			}
			return array;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//   **CRIA O ARRAY RANDÔMICO**

		public int[] Randomico(int tamanho) {
			int[] array = new int[tamanho];
			Random random = new Random();
			for (int i = 0; i < tamanho; i++) {
				array[i] = random.nextInt(tamanho);
			}
			return array;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//   **CALCULA O TEMPO DE EXECUÇÃO**
		
		public void TempodeExecucao(String tipo, Algoritmo metodo, int[] array) {
	        System.out.println("\n" + tipo);
	        int[] copy = Arrays.copyOf(array, array.length);
	        long startTime = System.currentTimeMillis();
	        metodo.sort(copy);
	        long endTime = System.currentTimeMillis();
	        System.out.println("Tempo: " + (endTime - startTime) + " ms");
	        System.out.println("--------------------");
	    }

}

