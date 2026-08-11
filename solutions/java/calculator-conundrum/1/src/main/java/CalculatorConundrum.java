
import java.util.Arrays;

class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        String[] operationsArr = new String[] {
            "+","-","*","/"
        };

        int result = 0;

        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        } else if (operation.equals("")) {
            throw new IllegalArgumentException("Operation cannot be empty");
        } else if (!Arrays.asList(operationsArr).contains(operation)) {
            throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        } else if (operand2 == 0 && operation.equals("/")) {
            throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
        } else {
            switch (operation) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                     result =  operand1 - operand2;
                    break;
                case "*":
                     result =  operand1 * operand2;
                    break;
                case "/":
                    result = (operand1 / operand2); 
                    break;
            }
        }

        return String.format("%d %s %d = %d", operand1, operation, operand2, result);


    }
}
