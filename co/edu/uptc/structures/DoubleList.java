package co.edu.uptc.structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

import org.w3c.dom.Node;

public class DoubleList<E> implements List<E> {
	private DoubleNode<E> head;


	public DoubleList() {
		this.head = null;
	}

	@Override
	public int size() {
		int i = 0;
		DoubleNode<E> aux = head;
		while(aux != null) {
			i++;
			aux = aux.getNext();
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object o) {
		DoubleNode <E> aux = head;
		if (o==null ? aux==null : o.equals(aux)) {
			aux = aux.getNext();
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> iterator = new Iterator<E>() {
			DoubleNode<E> temporalNode = head;

			@Override
			public boolean hasNext() {
				if(temporalNode.getNext() != null){
					return true;
				}
				return false;
			}

			@Override
			public E next() {
				if(!hasNext()){
					return temporalNode.getValue();
				}
				E outro = temporalNode.getValue();
				temporalNode = temporalNode.getNext();
				return outro;
			}
		};
		return iterator;
	}

	@Override
	public Object[] toArray() {
		int size = size();
		Object[] array = new Object[size];
		DoubleNode<E> aux = head;
		for(int i = 0; i < size; i++){
			array[i] = aux.getValue();
			aux = aux.getNext();
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		DoubleNode<E> newNode = new DoubleNode<E>(e);
		if (head == null) {
			head = newNode;
		} else {
			DoubleNode<E> aux = head;
			while (aux.getNext() != null) {
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
		if (c == null) new NullPointerException();

		for (Object object : c) {
			if (object == null) throw new NullPointerException();
		}

		for (Object object : c) {
			if(!contains(object)) return false;
		}

		return true;
	}

    /**
     * Agrega todos los elementos de una colección al final de esta lista.
     * <p>
     *
     * @param c colección que se quiere agregar a esta lista
     * @return {@code true} si los elementos de la colección se agregaron;
     * {@code false} si la colección está vacía
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E element : c) {
            add(element);
        }
        return true;
    }

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (head == null || c == null) {
			return false;
		}

		boolean isChange = false;
		DoubleNode<E> aux = head;

		while (aux != null) {
			DoubleNode<E> current = aux.getNext();
			for (Iterator<?> i = c.iterator(); i.hasNext();) {
				Object item = i.next();
				if (item.equals(aux.getValue())) {
					isChange = true;
					if (aux == head) {
						head = aux.getNext();
						if (head != null) {
							head.setPrevious(null);
						}
					} else {
						DoubleNode<E> previusNode = aux.getPrevious();
						DoubleNode<E> nextNode = aux.getNext();

						previusNode.setNext(aux.getNext());
						if (nextNode != null) {
							nextNode.setPrevious(aux.getPrevious());
						}

					}
					break;
				}
			}
			aux = current;

		}
		return isChange;
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
	public E get(int index) throws IndexOutOfBoundsException {
		DoubleNode <E> current = head;
		for(int i =0; i<index; i++){
			current = current.getNext();
		}
		return current.getValue();
	}

	@Override
	public E set(int index, E element) {
		DoubleNode<E> current = head;
		int counter = 0;
		while(current != null){
			if(counter == index){
				E replaced = current.getValue();
				current.setValue(element);
				return replaced;
			}
			current = current.getNext();
			counter++;
		}
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
		DoubleNode<E> current = head;
		int index = 0;
		while (current != null) {
			if (java.util.Objects.equals(current.getValue(), o)) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		
		DoubleNode<E> actual = head;
		int i = 0;
		while (actual != null) {
			if (actual.getValue().equals(o)) {
				return 0;
			} else {
				i++;
				actual = actual.getNext();
			}

		}
		return i;

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
		if (head != null) {
			DoubleNode<E> aux = head;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			while (aux != null) {
				reverse.append(aux.getValue() + " -> ");
				aux = aux.getPrevious();
			}
		}
		return "DoubleList [" + reverse + "]";
	}
}
