
package devsought;

import java.util.concurrent.ThreadLocalRandom;

public class JavaPassByValueExample2 {

    public static void main(String... args) {
        int random = ThreadLocalRandom.current().nextInt(1, 100);
        System.out.println(random);
        JavaPassByValueExample2 byValueExample1 = new JavaPassByValueExample2();
        byValueExample1.processTaskOne("Param1Value", "Param2Value", random);

    }

    public void processTaskOne(String param1, String param2, int val) {
        //print out parameters
        System.out.println("Param1:" + param1 + ", Param2:" + param2 + ", Value:" + val);
        //simulate some work
        boolean[] exceptionOccured = {false};
        System.out.println("Before subtask execution(exceptionOccured)=" + exceptionOccured[0]);
        processSubTaskOne(param2, val, exceptionOccured);
        System.out.println("After subtask execution(exceptionOccured)=" + exceptionOccured[0]);
        if (exceptionOccured[0]) {
            System.err.println("There was an error processing subtask");
        } else {
            System.out.println("Processed subtask successfully.");
        }

    }

    private void processSubTaskOne(String param, int val, boolean[] exceptionOccured) {
        try {
            if (val > 50) {
                //throw exception
                throw new Exception("Subtask One val out of range:" + val);
            } else {
                //normal value range processing
                System.out.println("Normal processing for param:" + param + " value " + val);
            }
        } catch (Exception ex) {
            System.err.println("Error occured in subtask with param " + param + " of value " + val + ", Error message:" + ex.getMessage());
            exceptionOccured[0] = true;
        }

    }
}
