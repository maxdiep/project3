import java.util.ArrayList;
import java.util.Arrays;

class HeapImpl<T extends Comparable<? super T>> implements Heap<T> {
	private static final int INITIAL_CAPACITY = 372;
	private T [] _storage;
	private int _numElements;

	@SuppressWarnings("unchecked")
	public HeapImpl () {
		_storage = (T[]) new Comparable[INITIAL_CAPACITY];
		_numElements = 0;
	}

	@SuppressWarnings("unchecked")
	public void add (T data) {
		if (_numElements == _storage.length) {
			_storage = Arrays.copyOf(_storage, _storage.length * 2);
		}
		_storage[_numElements] = data;
		int index = _numElements++;
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (_storage[index].compareTo(_storage[parentIndex]) > 0) {
				T temp = _storage[index];
				_storage[index] = _storage[parentIndex];
				_storage[parentIndex] = temp;
				index = parentIndex;
			} else {
				break;
			}
		}
	}

	public T removeFirst() {
		if (_numElements == 0) {
			return null;
		}
		T first = _storage[0];
		_storage[0] = _storage[--_numElements];
		_storage[_numElements] = null;

		int index = 0;
		while (true) {
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;

			if (leftChildIndex >= _numElements) {
				break;
			}

			int largerChildIndex = leftChildIndex;
			if (rightChildIndex < _numElements && _storage[rightChildIndex].compareTo(_storage[largerChildIndex]) > 0) {
				largerChildIndex = rightChildIndex;
			}

			if (_storage[largerChildIndex].compareTo(_storage[index]) > 0) {
				T temp = _storage[index];
				_storage[index] = _storage[largerChildIndex];
				_storage[largerChildIndex] = temp;
				index = largerChildIndex;
			} else {
				break;
			}
		}
		return first;
	}

	public int size () {
		return _numElements;
	}
}
