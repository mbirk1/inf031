public class QuickSortThreaded extends QuickSort implements Runnable{
	private int[] numbers;
	private int leftIndex;
	private int rightIndex;
	public QuickSortThreaded(int[] numbers, int leftIndex, int rightIndex) {
		this.numbers = numbers;
		this.leftIndex = leftIndex;
		this.rightIndex = rightIndex;
	}

	/**
	 * sortiert das uebergebene Array in aufsteigender Reihenfolge
	 * gemaess dem QuickSort-Algorithmus (parallel!)
	 */
	public static void sort(int[] numbers) {
		QuickSortThreaded left =new QuickSortThreaded(numbers, 0, numbers.length/2);
		QuickSortThreaded right = new QuickSortThreaded(numbers, numbers.length/2, numbers.length);
		Thread t1 = new Thread(left);
		Thread t2 = new Thread(right);

		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}catch (InterruptedException e){}
		QuickSort.sort(numbers);
	}

	/**
	 * der Quicksort-Algorithmus wird auf dem Array zwischen den
	 * angegebenen Indizes ausgefuehrt
	 */
	protected void quickSort(int[] numbers, int leftIndex, int rightIndex) {
		super.quickSort(numbers, leftIndex, rightIndex);
	}

	@Override
	public void run() {
		this.quickSort(numbers, leftIndex, rightIndex);
	}
}
