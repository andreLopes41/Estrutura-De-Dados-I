package MetodosOrdenacao;

public class Main {
    public static void main(String[] args) {
        int[] arrays = {100000, 1000000};
        
        TestarOrdenacao metodo = new TestarOrdenacao();
        Array array = new Array();

        for (int tam : arrays) {
            int[] ordenado = array.Ordenado(tam);
            int[] invertido = array.Invertido(tam);
            int[] randomico = array.Randomico(tam);

            System.out.println("╔═══════════╗");
            System.out.println("║   Array   ║");
            System.out.println("   " + tam);
            System.out.println("╚═══════════╝");
            
            metodo.Ordenar("BUBBLE SORT", BubbleSort::bubbleSort, ordenado, invertido, randomico);
            metodo.Ordenar("BUCKET SORT", BucketSort::bucketSort, ordenado, invertido, randomico);
            metodo.Ordenar("INSERION SORT", InsertionSort::insertionSort, ordenado, invertido, randomico);
            metodo.Ordenar("MERGE SORT", MergeSort::mergeSort, ordenado, invertido, randomico);
            metodo.Ordenar("QUICK SORT", QuickSort::quickSort, ordenado, invertido, randomico);
            metodo.Ordenar("SELECTION SORT", SelectionSort::selectionSort, ordenado, invertido, randomico);
            metodo.Ordenar("HEAP SORT", HeapSort::heapSort, ordenado, invertido, randomico);

            System.out.println("=============================================");
        }
    }

    interface Algoritmo {
        void sort(int[] values);
    }
}
