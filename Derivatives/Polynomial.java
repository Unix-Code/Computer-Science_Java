import java.util.*;
public class Polynomial {
    private double[] coef;  // coefficients
    private int deg;     // degree of polynomial (0 for the zero polynomial)

    // a * x^b
    public Polynomial(double a, int b) {
        coef = new double[b+1];
        coef[b] = a;
        deg = degree();
    }
    
    public Polynomial(String polynomial) {
        Polynomial temp = interpret(polynomial);
        this.coef = temp.coef;
        this.deg = temp.deg;
    }
    
    // return the degree of this polynomial (0 for the zero polynomial)
    public int degree() {
        int d = 0;
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] != 0) {
                d = i;
            }
        }
        return d;
    }

    // return c = a + b
    public Polynomial plus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
        for (int i = 0; i <= a.deg; i++){
            c.coef[i] += a.coef[i]; 
        }
        for (int i = 0; i <= b.deg; i++) {
            c.coef[i] += b.coef[i];
        }
        c.deg = c.degree();
        return c;
    }

    // return (a - b)
    public Polynomial minus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
        for (int i = 0; i <= a.deg; i++) {
            c.coef[i] += a.coef[i];
        }
        for (int i = 0; i <= b.deg; i++) {
            c.coef[i] -= b.coef[i];
        }
        c.deg = c.degree();
        return c;
    }

    // return (a * b)
    public Polynomial times(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, a.deg + b.deg);
        for (int i = 0; i <= a.deg; i++) {
            for (int j = 0; j <= b.deg; j++) {
                c.coef[i+j] += (a.coef[i] * b.coef[j]);
            }
        }
        c.deg = c.degree();
        return c;
    }

    // return a(b(x))  - compute using Horner's method
    public Polynomial compose(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, 0);
        for (int i = a.deg; i >= 0; i--) {
            Polynomial term = new Polynomial(a.coef[i], 0);
            c = term.plus(b.times(c));
        }
        return c;
    }

    // do a and b represent the same polynomial?
    public boolean eq(Polynomial b) {
        Polynomial a = this;
        if (a.deg != b.deg) {
            return false;
        }
        for (int i = a.deg; i >= 0; i--) {
            if (a.coef[i] != b.coef[i]) {
                return false;
            }
        }
        return true;
    }

    // use Horner's method to compute and return the polynomial evaluated at x
    public double evaluate(double x) {
        double p = 0;
        for (int i = deg; i >= 0; i--) {
            p = coef[i] + (x * p); 
        }
        return p;
    }
    // differentiate this polynomial and return it
    public Polynomial differentiate() {
        if (deg == 0) {
            return new Polynomial(0, 0);
        }
        Polynomial deriv = new Polynomial(0, deg - 1);
        deriv.deg = deg - 1;
        for (int i = 0; i < deg; i++) {
            deriv.coef[i] = (i + 1) * coef[i + 1];
        }
        return deriv;
    }

    // convert to string representation
    public String toString() {
        if (deg ==  0) {
            return "" + coef[0];
        }
        if (deg ==  1) {
            return coef[1] + "x + " + coef[0];
        }
        String s = coef[deg] + "x^" + deg;
        for (int i = deg-1; i >= 0; i--) {
            if (coef[i] == 0){
                continue;
            }
            else if (coef[i]  > 0) {
                s += " + " + ( coef[i]);
            }
            else if (coef[i]  < 0) {
                s += " - " + (-coef[i]);
            }
            if (i == 1) {
                s += "x";
            }
            else if (i >  1) {
                s += "x^" + i;
            }
        }
        return s;
    }

    public Polynomial interpret(String polynomial) {
        ArrayList<String> monoms = new ArrayList<String>(Arrays.asList(polynomial.split("[ ]+")));
        ArrayList<String[]> sTemp = new ArrayList<String[]>();
        ArrayList<Polynomial> monomials = new ArrayList<Polynomial>();
        Polynomial end = new Polynomial(0, 0);
        //deals with signs
        for (int i = 0; i < monoms.size(); i++) {
            if (monoms.get(i).equals("-")) {
                monoms.set(i+1, "-" + monoms.get(i+1));
                monoms.remove(i);
                i--;
            }
            if (monoms.get(i).equals("+")) {
                monoms.remove(i);
            }
        }
        // System.out.println(monoms);

        //removes x's
        for (int i = 0; i < monoms.size(); i++) {
            StringBuilder sb = new StringBuilder(monoms.get(i));
            String sFinal = monoms.get(i);

            if (monoms.get(i).indexOf('x') != -1) {
                /*****This One *****
                 *        ||
                 *        \/
                 */
                if (monoms.get(i).endsWith("x") == true) {
                    monoms.set(i, monoms.get(i) + "^1");
                }

                sb.deleteCharAt(monoms.get(i).indexOf('x'));
                sFinal = sb.toString();
            }
            else {
                sFinal = monoms.get(i) + "^0";
            }
            monoms.set(i, sFinal);
        }
        // System.out.println(monoms);

        //splits by ^'s ([0] is coeff and [1] is degree)
        for (int i = 0; i < monoms.size(); i++) {
            sTemp.add(monoms.get(i).split("[//^]+"));
        }
        // System.out.println(sTemp);

        //creates monomials
        for (int i = 0; i < sTemp.size(); i++) {
            if (sTemp.get(i).length == 1) {
                monomials.add(new Polynomial(Double.parseDouble(sTemp.get(i)[0]), 1));
            }
            else {
                // System.out.println((sTemp.get(i).length > 1) ? sTemp.get(i)[0] + " " + sTemp.get(i)[1] : sTemp.get(i)[0] + " 1");
                monomials.add(new Polynomial(Double.parseDouble(sTemp.get(i)[0]), Integer.parseInt(sTemp.get(i)[1])));
            }
        }
        // System.out.println(monomials);

        //constructs polynomial from monomials
        for (int i = 0; i < monomials.size(); i++) {
            end = end.plus(monomials.get(i));
        }

        return end;       
    }

    /*
     * Test Program
     */
    public static void main(String[] args) { 
        Polynomial zero = new Polynomial(0, 0);

        Polynomial p1   = new Polynomial(4, 3);
        Polynomial p2   = new Polynomial(3, 2);
        Polynomial p3   = new Polynomial(1, 0);
        Polynomial p4   = new Polynomial(2, 1);
        //Polynomial p    = p1.plus(p2).plus(p3).plus(p4);   // 4x^3 + 3x^2 + 2x + 1
        Polynomial p = zero.interpret("4x^3 + 3x^2 + 2x + 1");

        Polynomial q1   = new Polynomial(3, 2);
        Polynomial q2   = new Polynomial(5, 0);
        Polynomial q    = q1.plus(q2);                     // 3x^2 + 5

        Polynomial r    = p.plus(q);
        Polynomial s    = p.times(q);
        Polynomial t    = p.compose(q);

        System.out.println("zero(x) =     " + zero);
        System.out.println("p(x) =        " + p);
        System.out.println("q(x) =        " + q);
        System.out.println("p(x) + q(x) = " + r);
        System.out.println("p(x) * q(x) = " + s);
        System.out.println("p(q(x))     = " + t);
        System.out.println("0 - p(x)    = " + zero.minus(p));
        System.out.println("**p(3)        = " + p.evaluate(3));
        System.out.println("p'(x)       = " + p.differentiate());
        System.out.println("p''(x)      = " + p.differentiate().differentiate());
    }
}