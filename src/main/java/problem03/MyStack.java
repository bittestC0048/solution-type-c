package problem03;

import java.util.Arrays;

public class MyStack {
	
	private String[] buffer;
	
	private int size;
	private int top;

	public MyStack( int size ) {
		buffer = new String[size];
		this.size = size;
		top = -1;
	}
	
	public void push(String item) {
		if(top + 1 == size) buffer = Arrays.copyOf(buffer, size());
		buffer[++top] = item;
	}

	public String pop() {
		if(isEmpty()) return "null";
		return buffer[top--];
	}

	public boolean isEmpty() {
		if(top == -1) return true;
		
		return false;
	}
	
	public int size() {
		return ++size;
	}
}