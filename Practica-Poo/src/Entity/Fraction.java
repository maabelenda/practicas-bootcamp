package Entity;

public class Fraction {

    private long denominator;

    private long numerator;

    private int sign;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
        this.sign = 1;
    }

    public Fraction(long numerator, long denominator) {
        if(denominator == 0) {

        }
        if(denominator * numerator < 0) {
            this.sign = -1;
        } else {
            this.sign = 1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {

        return (this.sign > 0 ? "" : "-") + this.numerator + "/" + this.denominator;
    }

    public Fraction sum(Fraction fraction) {
        if(fraction == null || fraction.getDenominator() == 0 || this.denominator == 0) {
            return null;
        }
        if(fraction.getDenominator() != this.denominator) {
            Fraction f1 = new Fraction(this.numerator*fraction.getDenominator(), this.denominator*fraction.getDenominator());
            Fraction f2 = new Fraction(this.denominator*fraction.getNumerator(), this.denominator*fraction.getDenominator());
            return sumSameDenominator(f1, f2);
        }
        return sumSameDenominator(this, fraction);
    }

    public Fraction sum(long number) {
        if(this.denominator == 0) {
            return null;
        }
        return new Fraction(this.numerator + this.denominator*number, this.denominator);
    }

    private Fraction sumSameDenominator(Fraction f1, Fraction f2){
        return new Fraction(f1.getNumerator()+f2.getNumerator(), f1.getDenominator());
    }

    public Fraction subtract(Fraction fraction) {
        if(fraction == null || fraction.getDenominator() == 0 || this.denominator == 0) {
            return null;
        }
        if(fraction.getDenominator() != this.denominator) {
            Fraction f1 = new Fraction(this.numerator*fraction.getDenominator(), this.denominator*fraction.getDenominator());
            Fraction f2 = new Fraction(this.denominator*fraction.getNumerator(), this.denominator*fraction.getDenominator());
            return subtractSameDenominator(f1, f2);
        }
        return subtractSameDenominator(this, fraction);
    }

    public Fraction subtract(long number) {
        if(this.denominator == 0) {
            return null;
        }
        return new Fraction(this.numerator - this.denominator*number, this.denominator);
    }

    private Fraction subtractSameDenominator(Fraction f1, Fraction f2) {
        return new Fraction(f1.getNumerator()-f2.getNumerator(), f1.getDenominator());
    }

    public Fraction multiply(Fraction fraction) {
        if(fraction == null || fraction.getDenominator() == 0 || this.denominator == 0) {
            return null;
        }
        return new Fraction(this.numerator*fraction.getNumerator(),this.denominator*fraction.getDenominator());
    }

    public Fraction multiply(long number) {
        if(this.denominator == 0) {
            return null;
        }
        return new Fraction(this.numerator * number, this.denominator);
    }

    public Fraction divide(Fraction fraction) {
        if(fraction == null || fraction.getDenominator() == 0 || this.denominator == 0) {
            return null;
        }
        return new Fraction(this.numerator*fraction.getDenominator(),this.denominator*fraction.getNumerator());
    }

    public Fraction divide(long number) {
        if(this.denominator == 0) {
            return null;
        }
        return new Fraction(this.numerator, this.denominator*number);
    }

    public long getDenominator() {
        return denominator;
    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}
