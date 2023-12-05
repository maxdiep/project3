import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class HeapTester {
	private void permute (int[] array) {
		final Random random = new Random();
		for (int i = array.length - 1; i >= 0; i--) {
			final int j = random.nextInt(i+1);
			final int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	@Test
	public void testShuffled () {
		final int N = 1000;
		final int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = i;
		}
		permute(numbers);

		final HeapImpl<Integer> heap = new HeapImpl<Integer>();
		for (int i = 0; i < N; i++) {
			heap.add(numbers[i]);
		}
		assertEquals(N, heap.size());
		for (int i = N-1; i >= 0; i--) {
			assertEquals((Integer) i, heap.removeFirst());
		}
		assertEquals(0, heap.size());
	}
}
