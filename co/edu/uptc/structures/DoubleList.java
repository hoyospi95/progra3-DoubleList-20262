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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
	    if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
	        throw new IndexOutOfBoundsException("Rango no es válido");
	    }

	    DoubleList<E> result = new DoubleList<>();
	    DoubleNode<E> aux = head;
	    
	    for (int i = 0; i < fromIndex; i++) {
	        aux = aux.getNext();
	    }
	    
	    for (int i = fromIndex; i < toIndex; i++) {
	        result.add(aux.getValue()); 
	        aux = aux.getNext();
	    }
	    
	    return result;
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
