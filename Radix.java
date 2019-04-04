public class Radix {
  public static void radixsort(int[] data) {
    int max = 0;
    MyLinkedList<Integer> set = new MyLinkedList<Integer>();
    for (int x = 0; x < data.length; x++) {
      max = (int)Math.floor(Math.max(max,Math.log10(data[x])));
      set.add(data[x]);
    }
    max++;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[19];
    for (int x = 0; x < buckets.length; x++) {
      buckets[x] = new MyLinkedList<Integer>();
    }
    int temp;
    for (int x = 0; x < max; x++) {
      while (set.size() > 0) {
        temp = set.removeFront();
        buckets[9+((temp/(int)Math.pow(10,x))%10)].add(temp);
      }
      for (int i = 0; i < buckets.length; i++) {
        set.extend(buckets[i]);
        buckets[i].clear();
      }
    }
    int count = 0;
    while (set.size() > 0) {
      data[count] = set.removeFront();
      count++;
    }
  }
}
