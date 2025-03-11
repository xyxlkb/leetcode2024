package org.jwk;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PostfixCalculator {
    public double evaluate(String expression) {
        // 检查输入是否为空或null
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("输入表达式不能为空");
        }

        // 分割并过滤无效的空字符串
        List<String> tokens = Arrays.stream(expression.split("\\s+"))
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());

        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("输入表达式无效");
        }

        Deque<Double> stack = new ArrayDeque<>();

        for (String token : tokens) {
            try {
                // 尝试解析为数字
                double num = Double.parseDouble(token);
                stack.push(num);
            } catch (NumberFormatException e) {
                // 检查是否为有效运算符
                if (!isValidOperator(token)) {
                    throw new IllegalArgumentException("无效的运算符或操作数: " + token);
                }
                processOperator(stack, token);
            }
        }

        // 检查栈中是否只剩一个结果
        if (stack.size() != 1) {
            throw new IllegalArgumentException("表达式不完整或格式错误");
        }

        return stack.pop();
    }

    private boolean isValidOperator(String token) {
        return token.matches("[+\\-*/!]");
    }

    private void processOperator(Deque<Double> stack, String operator) {
        switch (operator) {
            case "!":
                handleFactorial(stack);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                handleBinaryOperator(stack, operator);
                break;
            default:
                throw new IllegalArgumentException("不支持的运算符: " + operator);
        }
    }

    private void handleFactorial(Deque<Double> stack) {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("阶乘运算符缺少操作数");
        }

        double num = stack.pop();
        // 检查是否为非负整数
        if (num < 0 || num != Math.floor(num)) {
            throw new IllegalArgumentException("阶乘操作数必须是非负整数: " + num);
        }

        int n = (int) num;
        try {
            double result = factorial(n);
            stack.push(result);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("阶乘计算错误: " + e.getMessage());
        }
    }

    private double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1.0;
        }

        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            // 检查溢出
            if (Double.isInfinite(result)) {
                throw new ArithmeticException("阶乘结果溢出: " + n);
            }
        }
        return result;
    }

    private void handleBinaryOperator(Deque<Double> stack, String operator) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("运算符 " + operator + " 缺少操作数");
        }

        double b = stack.pop();
        double a = stack.pop();

        switch (operator) {
            case "+":
                stack.push(a + b);
                break;
            case "-":
                stack.push(a - b);
                break;
            case "*":
                stack.push(a * b);
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("除以零");
                }
                stack.push(a / b);
                break;
        }
    }

    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();

        // 测试用例
        String[] testExpressions = {
                "3 4 +",        // 7
                "5 3 -",        // 2
                "2 3 *",        // 6
                "6 2 /",       // 3
                "5 !",         // 120
                "3 4 + 2 *",   // 14
                "4 0.5 +",     // 4.5
                "-2 3 +",      // 1
                "20 !"         // 2432902008176640000
        };

        for (String expr : testExpressions) {
            try {
                double result = calculator.evaluate(expr);
                System.out.printf("表达式: %-15s 结果: %.1f%n", expr, result);
            } catch (Exception e) {
                System.out.printf("表达式: %-15s 错误: %s%n", expr, e.getMessage());
            }
        }

        // 异常测试
        String[] errorExpressions = {
                "3 4 a +",     // 无效字符
                "5 ! 2",       // 栈剩余元素
                "0 0 /",       // 除以零
                "2.5 !",       // 小数阶乘
                "-3 !",        // 负数阶乘
                "+",           // 操作数不足
                ""             // 空输入
        };

        for (String expr : errorExpressions) {
            try {
                calculator.evaluate(expr);
            } catch (Exception e) {
                System.out.printf("表达式: %-15s 错误: %s%n", expr, e.getMessage());
            }
        }
    }
}