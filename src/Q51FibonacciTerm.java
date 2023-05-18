// the recursive version is a modified version from gfg
// the iterative version is inspired by the version I found at this site: https://dev.to/khalilsaboor/fibonacci-recursion-vs-iteration--474l
// I got the code for checking the execution time here: https://www.tutorialspoint.com/how-to-measure-execution-time-for-a-java-method

public class Q51FibonacciTerm {
    // adjust how many iterations and recursive calls is done by the methods
    // I did some time measurements, thinking it could indicate a little of the other resource usage as well
    // at 5 as a limit, the recursion method is the fastest to complete, but I tested 20, and by then it fell behind by an extra 0
    private static int rounds = 5;

    public static void main(String[] args) {
        // run method for iterative fibonacci term function, and take the time
        long iterativeTimeStart = System.nanoTime();
        iterativeFib(rounds);
        long iterativeTimeEnd = System.nanoTime();
        // calculate the time for iterative method by removing the beginning from the end result and print it out
        System.out.println("Execution time, iterative nanoseconds: " + (iterativeTimeEnd - iterativeTimeStart));

        // run recursive method for fibonacci term function, and take the time
        long recursiveTimeStart = System.nanoTime();
        for(int i = 0; i < rounds; i++){
            System.out.println(recursiveFib(i));
        }
        long recursiveTimeEnd = System.nanoTime();
        // calculate the time for recursive method by removing the beginning from the end result and print it out
        System.out.println("Execution time, recursive nanoseconds: " + (recursiveTimeEnd - recursiveTimeStart));
    }

    // function that scale up values by iterating and adding values to three variables
    // will not start to cause memory problems before you run out of space on the variables
    private static void iterativeFib(int limit){
        int singlePrevNumb, doublePrevNumb, currentNumb; // variables used for keeping track of growth and end result
        singlePrevNumb = currentNumb = 0;
        for(int i = 0; i < limit; i++){
            System.out.println(currentNumb);
            doublePrevNumb = singlePrevNumb;
            singlePrevNumb = currentNumb;
            currentNumb = doublePrevNumb + singlePrevNumb;
            // initial increase of value
            if (currentNumb == 0){
                currentNumb++;
            }
        }
    }

    // function that scale up values by calling itself two more times every time it's called
    // forget chrome stealing some memory, this will eat your memory for breakfast, as it scales out like some binary search tree made out of calls to itself
    static int recursiveFib(int limit) {
        // stop condition
        if (limit == 0) {
            return 0;
        }

        // stop condition
        if (limit == 1){
            return 1;
        }

        // recursion function
        else {
            return (recursiveFib(limit - 1) + recursiveFib(limit - 2));
        }
    }
}
