package model;

public class LineLinkedList {
		
	private int position;
	private LineLinkedList next;
	
	public LineLinkedList(int pos) {
		this.setPosition(pos);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public LineLinkedList getNext() {
		return next;
	}

	public void setNext(LineLinkedList next) {
		this.next = next;
	}
	
	
	
}
