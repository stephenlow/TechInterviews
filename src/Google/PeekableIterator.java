package Google;

/*
 * Google Interview Question: 
 * First Question: Implement Iterator class with peek() functionality in Java. Where peek gets top element
 * Was given Iterator API
 * Second Question: System Design - app search results in apps, apples, application
 */

import java.util.Iterator;

public class PeekableIterator<E> implements Iterator<E> {
	
	private final Iterator<E> iterator;
	private boolean isPeek = false;
	private E nextPeek = null;
	
	public PeekableIterator(Iterator<E> iterator){
		this.iterator = iterator;
		
	}
	
	@Override
	public boolean hasNext(){
		return iterator.hasNext();
	}
	
	@Override
	public E next(){
		if(isPeek){
			isPeek = false;
			return peek();
		}
		
		return iterator.next();
	}
	
	@Override
	public void remove(){
		iterator.remove();
	}
	
	public E peek(){
		if(hasNext()){
			if(isPeek == false){
				nextPeek = next();
				isPeek = true;
			}
			
		}
		else{
			nextPeek = null;
		}
		
		return nextPeek;
	}

}

/*
 * boolean	hasNext()
Returns true if the iteration has more elements.
E	next()
Returns the next element in the iteration.
void	remove()
Removes from the underlying collection the last element returned by this iterator (optional operation).
 */
