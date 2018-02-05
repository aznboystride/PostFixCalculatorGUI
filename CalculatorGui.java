import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * Created by Pey on 12/6/17.
 */
public class CalculatorGui extends JFrame {

    private JTextField result, infix, postfix;
    private JButton zero, one, two, three, four, five, six, seven, eight, nine,
            plus, sub, mult, div, exp, mod, openPar, closePar, equals, del, sign, dec;
    private JPanel contentPanel;
    private boolean justLaunched;

    private Stack stack = new Stack();
    private char opList[] = {'+', '-', '*', '/', '^', '%', '('};

    public CalculatorGui(String title) {
        super(title);
        justLaunched = true;
        initializeMainFrame();

        initializeContentPanel();
        setVisible(true);
    }

    private void initializeMainFrame() {
        setSize(new Dimension( 400,  630));
        setResizable(false);
    }

    private void initializeContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setLayout(new FlowLayout());
        sendTextField();
        createAndSendButtons();
        setContentPane(contentPanel);
    }

    private void sendTextField() {
        infix = new JTextField("0", 18);
        infix.setFont(new Font("Verdana", Font.CENTER_BASELINE,20));
        infix.setBackground(Color.black);
        infix.setForeground(Color.CYAN);
        infix.setEditable(false);
        infix.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        infix.setPreferredSize(new Dimension( 77, 30));
        contentPanel.add(infix);

        postfix = new JTextField("", 18);
        postfix.setFont(new Font("Verdana", Font.CENTER_BASELINE,20));
        postfix.setBackground(Color.black);
        postfix.setForeground(Color.red);
        postfix.setEditable(false);
        postfix.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        postfix.setPreferredSize(new Dimension( 77, 30));
        contentPanel.add(postfix);

        result = new JTextField("", 18);
        result.setFont(new Font("Verdana", Font.CENTER_BASELINE,20));
        result.setBackground(Color.black);
        result.setForeground(Color.green);
        result.setEditable(false);
        result.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        result.setPreferredSize(new Dimension( 77, 30));
        contentPanel.add(result);
    }

    private void createAndSendButtons() {

        Color orange = Color.orange;
        Color black = Color.BLACK;
        Color white = Color.WHITE;
        Color gray = Color.LIGHT_GRAY;

        zero = new JButton("0");
        zero.setForeground(white);
        zero.setBackground(orange);
        zero.setOpaque(true);
        zero.setBorderPainted(false);
        one = new JButton("1");
        one.setForeground(white);
        one.setBackground(orange);
        one.setOpaque(true);
        one.setBorderPainted(false);
        two = new JButton("2");
        two.setForeground(white);
        two.setBackground(orange);
        two.setOpaque(true);
        two.setBorderPainted(false);
        three = new JButton("3");
        three.setForeground(white);
        three.setBackground(orange);
        three.setOpaque(true);
        three.setBorderPainted(false);
        four = new JButton("4");
        four.setForeground(white);
        four.setBackground(orange);
        four.setOpaque(true);
        four.setBorderPainted(false);
        five = new JButton("5");
        five.setBackground(orange);
        five.setForeground(white);
        five.setOpaque(true);
        five.setBorderPainted(false);
        six = new JButton("6");
        six.setForeground(white);
        six.setBackground(orange);
        six.setOpaque(true);
        six.setBorderPainted(false);
        seven = new JButton("7");
        seven.setForeground(white);
        seven.setBackground(orange);
        seven.setOpaque(true);
        seven.setBorderPainted(false);
        eight = new JButton("8");
        eight.setBackground(orange);
        eight.setForeground(white);
        eight.setOpaque(true);
        eight.setBorderPainted(false);
        nine = new JButton("9");
        nine.setForeground(white);
        nine.setBackground(orange);
        nine.setOpaque(true);
        nine.setBorderPainted(false);
        plus = new JButton("+");
        plus.setForeground(white);
        plus.setBackground(orange);
        plus.setOpaque(true);
        plus.setBorderPainted(false);
        sub = new JButton("-");
        sub.setBackground(orange);
        sub.setForeground(white);
        sub.setOpaque(true);
        sub.setBorderPainted(false);
        mult = new JButton("*");
        mult.setForeground(white);
        mult.setBackground(orange);
        mult.setOpaque(true);
        mult.setBorderPainted(false);
        exp = new JButton("^");
        exp.setBackground(orange);
        exp.setForeground(white);
        exp.setOpaque(true);
        exp.setBorderPainted(false);

        mod = new JButton("%");
        mod.setForeground(black);
        mod.setBackground(gray);
        mod.setOpaque(true);
        mod.setBorderPainted(false);

        openPar = new JButton("(");
        openPar.setForeground(black);
        openPar.setBackground(gray);
        openPar.setOpaque(true);
        openPar.setBorderPainted(false);

        closePar = new JButton(")");
        closePar.setForeground(black);
        closePar.setBackground(gray);
        closePar.setOpaque(true);
        closePar.setBorderPainted(false);

        div = new JButton("/");
        div.setForeground(white);
        div.setBackground(orange);
        div.setOpaque(true);
        div.setBorderPainted(false);

        equals = new JButton("=");
        equals.setForeground(white);
        equals.setBackground(orange);
        equals.setOpaque(true);
        equals.setBorderPainted(false);

        del = new JButton("AC");
        del.setForeground(black);
        del.setBackground(gray);
        del.setOpaque(true);
        del.setBorderPainted(false);

        sign = new JButton("(-)");
        sign.setForeground(black);
        sign.setBackground(gray);
        sign.setOpaque(true);
        sign.setBorderPainted(false);

        dec = new JButton(".");
        dec.setForeground(white);
        dec.setBackground(Color.darkGray);
        dec.setOpaque(true);
        dec.setBorderPainted(false);

        setAllNormalButtonSize();
        setAllWideButtonSize();
        addActions();
        setAllNumbersColor();
        setAllFontSize();
        addAllButtonsToContentPanel();
    }

    private void addAllButtonsToContentPanel() {
        contentPanel.add(del);
        contentPanel.add(sign);
        contentPanel.add(mod);
        contentPanel.add(div);
        contentPanel.add(seven);
        contentPanel.add(eight);
        contentPanel.add(nine);
        contentPanel.add(mult);
        contentPanel.add(four);
        contentPanel.add(five);
        contentPanel.add(six);
        contentPanel.add(sub);
        contentPanel.add(one);
        contentPanel.add(two);
        contentPanel.add(three);
        contentPanel.add(plus);
        contentPanel.add(zero);
        contentPanel.add(dec);
        contentPanel.add(equals);
        contentPanel.add(openPar);
        contentPanel.add(closePar);
        contentPanel.add(exp);
    }

    private void setAllFontSize() {
        setFontSize(zero);
        setFontSize(one);
        setFontSize(two);
        setFontSize(three);
        setFontSize(four);
        setFontSize(five);
        setFontSize(six);
        setFontSize(seven);
        setFontSize(eight);
        setFontSize(nine);
        setFontSize(plus);
        setFontSize(sub);
        setFontSize(mult);
        setFontSize(div);
        setFontSize(exp);
        setFontSize(mod);
        setFontSize(dec);
        setFontSize(del);
        setFontSize(sign);
        setFontSize(equals);
        setFontSize(openPar);
        setFontSize(closePar);
    }

    private void setAllNumbersColor() {
        setNumbersColor(zero);
        setNumbersColor(one);
        setNumbersColor(two);
        setNumbersColor(three);
        setNumbersColor(four);
        setNumbersColor(five);
        setNumbersColor(six);
        setNumbersColor(seven);
        setNumbersColor(eight);
        setNumbersColor(nine);
        setNumbersColor(dec);
    }

    private void setAllWideButtonSize() {
        setWideButtonSize(zero);
        setWideButtonSize(exp);
    }

    private void setAllNormalButtonSize() {
        setNormalButtonSize(one);
        setNormalButtonSize(two);
        setNormalButtonSize(three);
        setNormalButtonSize(four);
        setNormalButtonSize(five);
        setNormalButtonSize(six);
        setNormalButtonSize(seven);
        setNormalButtonSize(eight);
        setNormalButtonSize(nine);
        setNormalButtonSize(plus);
        setNormalButtonSize(sub);
        setNormalButtonSize(mult);
        setNormalButtonSize(div);
        setNormalButtonSize(mod);
        setNormalButtonSize(dec);
        setNormalButtonSize(del);
        setNormalButtonSize(equals);
        setNormalButtonSize(sign);
        setNormalButtonSize(openPar);
        setNormalButtonSize(closePar);
    }

    private void setWideButtonSize(JButton button) {
        Dimension dim = new Dimension(189, 77);
        button.setPreferredSize(dim);
    }

    private void setNormalButtonSize(JButton button) {
        Dimension dim = new Dimension(93, 77);
        button.setPreferredSize(dim);
    }

    private void setFontSize(JButton zero) {
        zero.setFont(new Font("Verdana", Font.ITALIC, 24));
    }

    private void setNumbersColor(JButton button) {
        button.setBackground(Color.DARK_GRAY);
    }

    private void addActions() {
        NumberAction ob = new NumberAction();
        zero.addActionListener(ob);
        one.addActionListener(ob);
        two.addActionListener(ob);
        three.addActionListener(ob);
        four.addActionListener(ob);
        five.addActionListener(ob);
        six.addActionListener(ob);
        seven.addActionListener(ob);
        eight.addActionListener(ob);
        nine.addActionListener(ob);
        sign.addActionListener(ob);
        dec.addActionListener(ob);

        OperatorAction op = new OperatorAction();
        plus.addActionListener(op);
        sub.addActionListener(op);
        mult.addActionListener(op);
        div.addActionListener(op);
        exp.addActionListener(op);
        mod.addActionListener(op);
        del.addActionListener(op);
        openPar.addActionListener(op);
        closePar.addActionListener(op);
        equals.addActionListener(op);
    }

    public static void main(String[] args) {
        new CalculatorGui("5pts Extra Credit Calculator");
    }

    private class OperatorAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            JButton buttonPressed = (JButton) event.getSource();
            String currText = infix.getText();
            if(buttonPressed.equals(del)) {
                infix.setText("0");
                postfix.setText("");
                result.setText("");
                justLaunched = true;
            } else if(buttonPressed.equals(openPar)) {
                if(justLaunched) {
                    infix.setText("(");
                    justLaunched = false;
                } else {
                    infix.setText(currText + "(");
                }
            } else if(currText.length() != 0 && !lastCharacterIsOperator(currText) && !justLaunched) {
                if(buttonPressed.equals(plus)) {
                    if(justLaunched) {
                        justLaunched = false;
                        infix.setText("+");
                    } else
                        infix.setText(currText + "+");
                } else if(buttonPressed.equals(sub)) {
                    if(justLaunched) {
                        justLaunched = false;
                        infix.setText("-");
                    } else
                        infix.setText(currText + "-");

                } else if(buttonPressed.equals(mult)) {
                    if(justLaunched) {
                        justLaunched = false;
                        infix.setText("*");
                    } else
                        infix.setText(currText + "*");
                } else if(buttonPressed.equals(div)) {
                    if(justLaunched) {
                        justLaunched = false;
                        infix.setText("/");
                    } else
                        infix.setText(currText + "/");
                } else if(buttonPressed.equals(equals)) {
                    String res = "";
                    try {
                        String p = convertInfixToPostFix();
                        postfix.setText("POSTFIX = " + p);
                        infix.setText(  "INFIX      = " + infix.getText());
                        res = calculate(p);
                    } catch (ArithmeticException e) {
                        res = "UNDEFINED";
                    }
                    result.setText(     "RESULT   = " + res);
                    justLaunched = true;
                } else if(buttonPressed.equals(exp)) {
                    if(justLaunched) {
                        justLaunched = false;
                        infix.setText("^");
                    } else
                        infix.setText(currText + "^");
                } else if(buttonPressed.equals(mod)) {
                    if(justLaunched) {
                        justLaunched = false;
                        infix.setText("%");
                    } else
                        infix.setText(currText + "%");
                } else {
                    if(justLaunched) {
                        justLaunched = false;
                        infix.setText(")");
                    } else
                        infix.setText(currText + ")");
                }
            }
        }

        private boolean lastCharacterIsOperator(String text) {
            char lastCharFromText = text.charAt(text.length()-1);
            return isOperator(lastCharFromText);
        }
    }

    private String calculate(String currText) throws ArithmeticException {
        String str = "";
        double answer = 0;
        Stack stack = new Stack();
        for(int i = 0; i < currText.length(); i++) {
            char c = currText.charAt(i);
            if(Character.isWhitespace(c)) {
                stack.push(str);
                str = "";
            } else if(isNumeric(c)) {
                str += c;
            } else {
                if(str.length() != 0)
                    stack.push(str);
                str = "";
            }
            if(stack.size() > 1 && isOperator(c)) {
                char operator = c;
                String secondOperand = String.valueOf(stack.pop());
                String firstOperand = String.valueOf(stack.pop());
                if (c == '/' && secondOperand.equals("0"))
                    throw new ArithmeticException("Cannot divide by zero!");
                answer = operate(firstOperand, secondOperand, operator);
                stack.push(answer);
            }
        }
        return String.valueOf(stack.pop());
    }

    private double operate(String firstOperand, String secondOperand, char operator) {
        if(firstOperand.startsWith("~"))
            firstOperand = '-' + firstOperand.substring(1);
        if(secondOperand.startsWith("~"))
            secondOperand = '-' + secondOperand.substring(1);
        switch(operator)
        {
            case '+':
                return Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
            case '-':
                return Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
            case '*':
                return Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
            case '/':
                return Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
            case '^':
                return Math.pow(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
            case '%':
                return Double.parseDouble(firstOperand) % Double.parseDouble(secondOperand);
            default:
                return 0;
        }
    }

    private String convertInfixToPostFix() {
        String p = "";
        String in = infix.getText();

        for(int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if((stack.empty() && !isNumeric(c) || c == '(')) {
                if(c == '(' && i > 0 && (Character.isDigit(in.charAt(i-1)) || in.charAt(i-1) == ')')) {
                    stack.push('*');
                }
                stack.push(c);
                if(p.length() != 0 && !isOperator(p.charAt(p.length()-1)) && !Character.isWhitespace(p.charAt(p.length()-1)))
                    p += " ";
            } else if(isNumeric(c)) {
                p += c;
            } else if(c == ')') {
                while((char) stack.peek() != '(') {
                    p += stack.pop();
                }
                stack.pop();
            } else {
                while(!stack.empty() && peekIsHigherPrecedenceThan(c)) {
                    p += stack.pop();
                }
                if(c == '(' && i > 0 && (Character.isDigit(in.charAt(i-1)) || in.charAt(i-1) == ')')) {
                    stack.push('*');
                }
                stack.push(c);
                if(!isOperator(p.charAt(p.length()-1)) && !Character.isWhitespace(p.charAt(p.length()-1)))
                    p += " ";
            }
        }
        while(!stack.empty())
            p += stack.pop();
        return p;
    }

    private boolean peekIsHigherPrecedenceThan(char c) {
        char peek = (char) stack.peek();
        if(peek == c || peek == '^' || peek == '%' || ((peek == '+' || peek == '-') && (c == '+' || c == '-')) ||((peek == '*' || peek == '/') && (c == '+' || c == '-' || c == '*' || c == '/')))
            return true;
        return false;
    }

    private boolean isNumeric(char c) {
        return Character.isDigit(c) || c == '~' || c == '.';
    }

    private boolean isOperator(char c) {
        for(char op: opList)
            if(c == op)
                return true;
        return false;
    }

    private class NumberAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            JButton buttonPressed = (JButton) event.getSource();

            String currText = infix.getText();
            System.out.println(postfix.getText());
            if(buttonPressed.equals(one)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("1");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "1");
            } else if(buttonPressed.equals(two)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("2");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "2");
            } else if(buttonPressed.equals(three)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("3");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "3");
            } else if(buttonPressed.equals(four)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("4");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "4");
            } else if(buttonPressed.equals(five)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("5");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "5");
            } else if(buttonPressed.equals(six)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("6");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "6");
            } else if(buttonPressed.equals(seven)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("7");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "7");
            } else if(buttonPressed.equals(eight)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("8");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "8");
            } else if(buttonPressed.equals(nine)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("9");
                } else
                    if(infix.getText().length() > 0 && infix.getText().charAt(infix.getText().length()-1) != ')')
                        infix.setText(currText + "9");
            } else if(buttonPressed.equals(dec)) {
                if(justLaunched) {
                    justLaunched = false;
                    infix.setText("0.");
                } else {
                    char lastChar = currText.charAt(currText.length() - 1);
                    if (lastChar != '.' && lastChar != ')')
                        infix.setText(currText + ".");
                }
            } else if(buttonPressed.equals(sign)) {
                if(!justLaunched && currText != "0" && isNumeric(currText.charAt(currText.length()-1))) {
                    System.out.println(currText);
                    int lastIndOfCurrText = currText.length() - 1;
                    for(int k = lastIndOfCurrText; k >= 0; k--) {
                        char currentChar = currText.charAt(k);
                        if(isOperator(currentChar)) {
                            if(currText.charAt(k+1) == '~')
                                currText = currText.substring(0, k+1) + currText.substring(k+2);
                            else
                                currText = currText.substring(0, k+1) + '~' + currText.substring(k+1);
                            break;
                        } else if(k == 0) {
                            if(Character.isDigit(currentChar))
                                currText = '~' + currText;
                            else
                                currText = currText.substring(1);
                        }
                    }
                    infix.setText(currText);
                }
            } else {
                if(!currText.equals("0") && currText.length() > 0 && currText.charAt(currText.length()-1) != ')')
                    infix.setText(currText + "0");
            }
        }
    }
}