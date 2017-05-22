import java.util.Stack;


public class M155_Min_Stack {
  Integer min;
  Stack<Integer> stack;

  M155_Min_Stack(){
    min = 0;
    stack = new Stack<Integer>();
    stack.push(0);
  }

  public void push(Integer x) {
    stack.push(x - min);
    if(x < min) min = x;
  }

  public void pop() {
    if(stack.isEmpty()) return;
    Integer x = stack.pop();
    if( x < 0 ) min = min - x;
  }

  public Integer top() {
    return stack.peek() > 0 ? stack.peek() + min : min;
  }

  public Integer getMin() {
    return min;
  }

  public static void main(String args[]){
    M155_Min_Stack ms = new M155_Min_Stack();

    ms.push(-2);
    ms.push(0);
    ms.push(-3);
    System.out.println("min: " + ms.getMin()); // return -3
    ms.pop(); // -3 pop out, min = -2.
    System.out.println("top: " + ms.top()); // return 0
    System.out.println("min: " + ms.getMin()); // return -2


  }
}
