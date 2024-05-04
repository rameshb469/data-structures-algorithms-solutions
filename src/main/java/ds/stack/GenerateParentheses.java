package ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 */
public class GenerateParentheses {

    private static Stack<String> stack = new Stack<>();

    public static List<String> generateParenthesis(int n) {

        List<String> rs = new ArrayList<>();

        backtracking(0, 0, n, rs);

        return rs;
    }

    private static void backtracking(int openN, int closeN, int n, List<String> results){

        // base condition

        if (openN == n && closeN == n){
            results.add(stack.stream().collect(Collectors.joining("")));
        }

        // we will open parenthesis till openN < n
        if (openN < n){
            stack.push("{");
            backtracking(openN+1, closeN, n, results);
            stack.pop();
        }

        // we can add closing parenthesis openN > closeN
        if (closeN < openN){
            stack.push("}");
            backtracking(openN, closeN+1, n, results);
            stack.pop();
        }
    }
}
