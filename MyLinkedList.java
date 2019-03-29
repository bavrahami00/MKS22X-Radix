public class MyLinkedList<E> {
  class Node {
    private E data;
    private Node next,prev;
    public Node(E value, Node p,Node n) {
      data = value;
      next = n;
      prev = p;
    }
    public Node next() {
      return next;
    }
    public Node prev() {
      return prev;
    }
    public void setNext(Node other) {
      next = other;
    }
    public void setPrev(Node other) {
      prev = other;
    }
    public String toString() {
      return "" + data;
    }
    public E getData() {
      return data;
    }
    public E setData(E i) {
      data = i;
      return i;
    }
  }
  private int size;
  private Node start,end;
  public String toString() {
    if (size == 0) {
      return "[]";
    }
    Node cur = start;
    String t = "[";
    for (int x = 0; x < size-1; x++) {
      t += cur.getData() + ", ";
      cur = cur.next();
    }
    t += end + "]";
    return t;
  }
  public MyLinkedList() {
    size = 0;
    start = new Node(0,null,null);
    end = start;
  }
  public void clear() {
    size = 0;
    start = new Node(0,null,null);
    end = start;
  }
  public boolean add(E value) {
    if (size == 0) {
      start = new Node(value,null,null);
      end = start;
      size++;
      return true;
    }
    Node next = new Node(value,end,null);
    end.setNext(next);
    end = next;
    size++;
    return true;
  }
  public void extend(MyLinkedList<E> other) {
    if (size != 0) {
      other.start.setPrev(end);
    }
    if (other.size != 0) {
      end.setNext(other.start);
      end = other.end;
    }
    if (size == 0) {
      start = other.start;
    }
    size += other.size();
    other.size = 0;
  }
  public E removeFront() {
    E ans = start.getData();
    if (size == 1) {
      start = new Node(0,null,null);
      end = start;
    }
    else if (size == 2) {
      end.setPrev(null);
      start = end;
    }
    else {
      end.setPrev(null);
      start = start.getNext();
    }
    return ans;
  }
}
