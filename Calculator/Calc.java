public class Calc {
    public static void main(String[] args) {
        double firstArg;
        double secondArg;
        if (args.length == 3) {
            firstArg = Double.parseDouble(args[0]);
            secondArg = Double.parseDouble(args[2]);
            choose(args[1], firstArg, secondArg);
        }
        else { 
            System.out.println("Error: Invalid Number of Arguments");
        }
    }

    public static void choose(String op, double uno, double dos) {
        double result = 0;

        if ( op.equals("+")) { 
            result = sum(uno, dos);
        }
        else if ( op.equals("*")) {
            result = multiply(uno, dos);
        }
        else if ( op.equals("x")) {
            result = multiply(uno, dos);
        }
        else if ( op.equals("/")) {
            result = divide(uno, dos);
        }
        else if ( op.equals("-")) {
            result = subtract(uno, dos);
        }
        else {
            System.out.println("Error: Unknown Operator " + op);
            return;
        }

        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("0.##########");
        String sResult = decimalFormat.format(result);
        String sFirst = decimalFormat.format(uno);
        String sSecond = decimalFormat.format(dos);
        System.out.format("%s %s %s = %s", sFirst, op, sSecond, sResult);

    }

    public static double sum(double first, double second) {
        double sum;
        sum = first + second;
        return sum;
    }

    public static double multiply(double first, double second) {
        double product;
        product = first * second;
        return product;
    }

    public static double divide(double first, double second) {
        double quotient;
        quotient = first / second;
        return quotient;
    }

    public static double subtract(double first, double second) {
        double difference;
        difference = first - second;
        return difference;
    }
}

