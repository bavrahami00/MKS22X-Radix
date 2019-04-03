public class MyLinkedList<E> {
  class Node {
    private E data;
    private Node next;
    public Node(E value, Node n) {
      data = value;
      next = n;
    }
    public Node next() {
      return next;
    }
    public void setNext(Node other) {
      next = other;
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
    start = new Node(null,null);
    end = start;
  }
  public int size() {
    return size;
  }
  public void clear() {
    size = 0;
    start = new Node(null,null);
    end = start;
  }
  public boolean add(E value) {
    size++;
    if (size == 1) {
      start.setData(value);
      return true;
    }
    Node next = new Node(value,null);
    end.setNext(next);
    end = next;
    return true;
  }
  public void extend(MyLinkedList<E> other) {
    if (other.size != 0) {
      end.setNext(other.start);
      end = other.end;
    }
    if (size == 0) {
      start = other.start;
    }
    size += other.size();
  }
  public E removeFront() {
    size--;
    E ans = start.getData();
    if (size == 1) {
      start = new Node(null,null);
      end = start;
    }
    else if (size == 2) {
      
    }
    else {
      start = start.next();
    }
    return ans;
  }
}
