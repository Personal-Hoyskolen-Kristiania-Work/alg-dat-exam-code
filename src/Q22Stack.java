// this stack is mostly built from the description of stacks in the task and slides
// it's also somewhat inspired from some gfg code

public class Q22Stack {
    static int top = -1;
    static int stackSize = 100;
    static int[] stack = new int[stackSize];
    public static void main(String[] args) {
        // trying to pop and look at min element from empty stack
        System.out.println("Output from empty stack with pop and getMin:");
        System.out.println(pop());
        System.out.println(getMin()); // expected value -1 for empty

        // fill stack with values, tries to add one too much but get overflow condition
        System.out.println("Adding elements to stack, with one overflow condition triggering:");
        for (int i = 0; i < stackSize + 1; i++){
            push(i);
        }

        // looking at min element from full stack
        System.out.println("Get min on full stack:");
        System.out.println(getMin()); //expected value 0 for first element in stack

        // empty stack, tries to remove one extra, but get underflow condition
        System.out.println("Pop method on all stack elements, with one underflow:");
        for (int i = 0; i < stackSize + 1; i++){
            System.out.println( pop());
        }
    }

    private static void push(int value){
        if(top == stackSize - 1){
            System.out.println("Overflow");
        }else{
            top++;
            stack[top] = value;
        }
    }

    private static int pop(){
        if (top == -1){
            System.out.println("Underflow");
            return top;
        }else{
            top--;
            return stack[top+1];
        }
    }
    private static int getMin(){
        if (top == -1){
            System.out.println("Underflow");
            return top;
        }else{
            return stack[0];
        }
    }
}