import java.util.Stack;


public class EvaluateReversePolishNotation {
    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {

        for(String token : tokens){
            //check if token is operation
            if(isOperator(token)){
                executeOperation(token);
            } else {
                // if token is not operation just push it to stack
                int val = Integer.parseInt(token);
                stack.push(val);
            }
        }
        return stack.pop();
    }

    public boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public void executeOperation(String operation){
        //take two last element from stack and do operation
        int operand1 = stack.pop();
        int operand2 = stack.pop();
        if (operation.equals("+")){
            stack.push(operand2 + operand1);
        } else if (operation.equals("-")){
            stack.push(operand2 - operand1);
        } else if (operation.equals("*")){
            stack.push(operand2 * operand1);
        } else if (operation.equals("/")){
            stack.push(operand2 / operand1);
        }
    }

    public static void main(String[] args) {

        String a[]={"4","13","5","/","+"};
        EvaluateReversePolishNotation ob =new EvaluateReversePolishNotation();
        int j=ob.evalRPN(a);
        System.out.print(j);


    }
}

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
