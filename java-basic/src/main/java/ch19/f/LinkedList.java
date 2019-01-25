// 특정 클래스에 의해서만 사용되는 클래스가 있다면 그 클래스 안에 정의하라!
package ch19.f;

// Array 클래스는 LinkedList 클래스에서만 사용한다.
// 그래서 패키지 멤버 클래스에서 중첩 클래스로 옮겼다.
// 즉 LinkedList 클래스 안에 Array 클래스를 정의하였다.
public class LinkedList {
  
  public static final int FORWARD = 1;
  public static final int REVERSE = 2;
  
  protected Node head;
  protected Node tail;
  protected int size;
  
  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }
  
  // LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에 
  // ArrayList 처럼 한 번에 큰 메모리를 준비할 필요가 없다.
  // => 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다.
  //
  public void add(Object value) {
    tail.value = value;
    
    // 새 노드를 준비한다.
    Node node = new Node();
    
    // 마지막 노드의 다음으로 새 노드를 가리키게 한다.
    tail.next = node;
    
    // 새 노드의 이전으로 마지막 노드를 가리키게 한다.
    node.prev = tail;
    
    // tail이 새로 추가된 노드를 가리키게 한다.
    tail = node;
    
    // 항목 개수를 증가시킨다.
    size++;
  }
  
  public int size() {
    return size;
  }
  
  // ArrayList와 달리 해당 인덱스를 찾아 가려면 링크를 따라가야 하기 때문에 
  // 조회 속도가 느리다.
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = head;
    
    // 해당 인덱스로 이동한다.
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    // cursor가 가리키는 노드의 주소를 리턴?
    // => 노드의 값을 리턴
    return cursor.value;
  }
  
  public Object[] toArray(int direction) {
    
    // Array 클래스는 LinkedList 인스턴스에 들어 있는 값을 사용하며,
    // 배열을 만들어 주는 도우미 클래스이다.
    
    // Array의 도움을 받으려면 다음과 같이 
    //항상 Array 객체에게 LinkedList 객체를 넘겨야 한다   
    Array helper = new Array(this); // 
    
    if (direction == FORWARD) {
      return helper.copy();
    } else {
      return helper.reverseCopy();
    }
    
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index >= size) 
      return null;
    
    Node cursor = head;
    
    // 교체할 값이 들어 있는 노드로 이동한다.
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    // 변경 전에 이전 값을 보관한다.
    Object old = cursor.value;
    
    // 값을 변경한다.
    cursor.value = value;
    
    // 이전 값을 리턴한다. 쓰든 안쓰든 호출하는 사람이 알아서 할 일이다.
    // 다만 변경 전 값을 활용할 경우를 대비해 리턴하는 것이다.
    return old;
  }
  
  // 값을 삽입하는 경우에는 ArrayList 방식 보다 효율적이다.
  // 사입 위치에 있는 노드를 찾은 후에 새 노드를 앞, 뒤 노드에 연결하면 된다.
  public int insert(int index, Object value) {
    if (index < 0 || index >= size)
      return -1;
    
    // 새 노드를 만들어 값을 담는다.
    Node node = new Node(value);
    
    // 삽입할 위치에 있는 원래 노드를 찾는다.
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    // 새 노드가 찾은 노드를 가리키게 한다.
    node.next = cursor;
    
    // 찾은 노드의 이전 노드 주소를 새 노드의 이전 노드 주소로 설정한다.
    node.prev = cursor.prev;
    
    // 찾은 노드의 이전 노드로 새 노드를 가리키게 한다.
    cursor.prev = node;
    
    if (node.prev != null) {
      // 이전 노드의 다음 노드로 새 노드를 가리키게 한다.
      node.prev.next = node;
    } else {
      // 맨 앞에 노드를 추가할 때는 head를 변경해야 한다.
      head = node;
    }
    
    // 크기를 늘린다.
    size++;
    
    return 0;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    // index 위치에 있는 노드를 찾는다.
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    if (cursor.prev != null) {
      // 찾은 노드의 이전 노드가 다음 노드를 가리키게 한다.
      cursor.prev.next = cursor.next;
    } else {
      // 맨 처음 노드를 삭제할 때
      head = cursor.next;
    }
    
    // 찾은 노드의 다음 노드가 이전 노드를 가리키게 한다.
    cursor.next.prev = cursor.prev;
    
    // JVM(Garbage Collection)이 가비지를 효과적으로 계산할 수 있도록 
    // 가비지가 된 객체는 다른 객체를 가리키지 않도록 한다.
    Object old = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
    
    // 크기를 줄인다.
    size--;
    
    // 호출한 쪽에서 필요하면 사용하라고 삭제된 값을 리턴해 준다.
    return old;
  }
  
  // 중첩 클래스는 크게 static이나 non-static이냐로 나눌 수 있는데.
  // 바깥 클래스의 특정 인스턴스를 사용하지 않는다면 static class로 선언하라!
  // 그러나 바깥 클래스의 특정 인스턴스를 사용한다면 그 인스턴스에 종속되기 때문에
  // non-static nested class로 선언하라!
  // => 다음 Array 클래스는 LinkedList의 특정 인스턴스의 값을 사용해야 하기 때문에
  //    non-static 클래스로 선언한다.
  // => 내부에서만 사용할 클래스라면 비공개로 처리하라
  public class Array {
    // 이제 Array 클래스는 LinkedList의 인스턴스 멤버가 되었다.
    // => 즉 인스턴스 필드나, 메서드처럼 특정 인스턴스에 대해 주소를 받는다는 것이다.
    // => 따라서 바깥 클래스의 인스턴스를 마음대로 사용할 수 있다. 그냥 인스턴스 메서드라 생각하라.
    //
    // LinkedList list; <= 이 코드 필요 없다.
    
    /*
     * public Array(LinkedList list) {
      this.list = list;
    }
    */
    
    public Object[] copy() {
      // 바깥 클래스의 인스턴스 주소는 다음과 같이 사용해야 한다.
      //    바깥 클래스명.this.인스턴스멤버
      // 만약 바깥 클래스의 인스턴스 멤버명이 내부 클래스의 멤버 이름과 충돌하지 않는다면
      //    바깥 클래스명.this를 생략해도 된다.
      Object[] arr = new Object[LinkedList.this.size()];
      for (int i = 0; i < size(); i++) {
        arr[i] = get(i);
      }
      return arr;
    }
    
    // 입력된 순서의 반대로 배열을 만든다.
    public Object[] reverseCopy() {
      // 다음과 같이 내부 멤버에 같은 이름이 없다면 바깥 클래스의 인스턴스 멤버를 사용할 때
      // LinkedList.this 를 생략해도 된다.
      // 그냥 LinkedList의 메서드라 생각하고 작성하라!
      Object[] arr = new Object[size()];
      
      for (int i = size() - 1, j = 0; i >= 0; i--, j++) {
        arr[j] = get(i);
      }
      
      return arr;
      
    }

  }


}
