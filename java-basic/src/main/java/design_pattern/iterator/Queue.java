package design_pattern.iterator;

public class Queue<E> extends LinkedList<E> {

  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size == 0;
  }
  
//자신이 보유한 데이터를 꺼내주는 일을 하는 객체를 알려주는 메서드
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      int index = 0;

      @Override
      public boolean hasNext() {
       return index < size();
      }

      @Override
      public E next() {
        return (E) get(index++);
      }
      
    };
  }
  
}
