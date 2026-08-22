package co.edu.uptc.structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class DoubleList<E> implements List<E> {
	private DoubleNode<E> head;
	
	
	public DoubleList() {
		this.head = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		DoubleNode<E> newNode = new DoubleNode<E>(e);
		if(head == null){
			head = newNode;
		}else{
			DoubleNode<E> aux = head;
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			newNode.setPrevious(aux);
			aux.setNext(newNode);
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListIterator<E>() {

			private DoubleNode<E> current = head;
			private DoubleNode<E> previous = null;
			private DoubleNode<E> lastReturned = null;
			private int nextIndex = 0;
			private boolean lastOperationWasNext = false;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = current;
				E value = current.getValue();
				previous = current;
				current = current.getNext();
				nextIndex++;
				lastOperationWasNext = true;
				return value;
			}

			@Override
			public boolean hasPrevious() {
				return previous != null;
			}

			@Override
			public E previous() {
				if (!hasPrevious()) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = previous;
				E value = previous.getValue();
				current = previous;
				previous = previous.getPrevious();
				nextIndex--;
				lastOperationWasNext = false;
				return value;
			}

			@Override
			public int nextIndex() {
				return nextIndex;
			}

			@Override
			public int previousIndex() {
				return nextIndex - 1;
			}

			@Override
			public void remove() {
				if (lastReturned == null) {
					throw new IllegalStateException();
				}

				DoubleNode<E> before = lastReturned.getPrevious();
				DoubleNode<E> after = lastReturned.getNext();

				if (before == null) {
					head = after;
				} else {
					before.setNext(after);
				}

				if (after != null) {
					after.setPrevious(before);
				}

				if (lastOperationWasNext) {
					previous = before;
					nextIndex--;
				} else {
					current = after;
					previous = before;
				}
				lastReturned = null;
			}

			@Override
			public void set(E e) {
				if (lastReturned == null) {
					throw new IllegalStateException();
				}
				lastReturned.setValue(e);
			}

			@Override
			public void add(E e) {
				DoubleNode<E> newNode = new DoubleNode<E>(e);
				newNode.setPrevious(previous);
				newNode.setNext(current);
				if (previous == null) {
					head = newNode;
				} else {
					previous.setNext(newNode);
				}
				if (current != null) {
					current.setPrevious(newNode);
				}
				previous = newNode;
				nextIndex++;
				lastReturned = null;
			}
		};
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "DoubleList [head=" + head + "]";
	}

	public String toStringReverse() {
		StringBuilder reverse = new StringBuilder();
		if(head != null){
			DoubleNode<E> aux = head;
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			while(aux != null){
				reverse.append(aux.getValue() + " -> ");
				aux = aux.getPrevious();
			}
		}
		return "DoubleList [" + reverse + "]";
	}
}
