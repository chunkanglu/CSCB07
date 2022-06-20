package lab4;

import java.lang.Comparable;

/**
 * Represents a Rational Number.
 * 
 * @author Chun Kang Lu
 *
 */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
	int numerator;
	int denominator;
	
	public RationalNumber(int numerator, int denominator)throws Lab4Exception {
		if(denominator == 0) {
			throw new Lab4Exception("Denominator cannot be zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public RationalNumber add(SpecialNumber n) throws Lab4Exception {
		if(! (n instanceof RationalNumber)) {
			throw new Lab4Exception("Cannot add an incompatible type");
		}
		RationalNumber x = (RationalNumber) n;
		return new RationalNumber(x.denominator * this.numerator + this.denominator * x.numerator, this.denominator * x.denominator);
	}
	
	@Override
	public RationalNumber divideByInt(int i) throws Lab4Exception {
		if(i == 0) {
			throw new Lab4Exception("Cannot divide by zero");
		}
		return new RationalNumber(this.numerator, this.denominator * i);
	}
	
	public int compareTo(RationalNumber n) {
		double call = (double)this.numerator / this.denominator;
		double arg = (double)n.numerator / n.denominator;
		if(call > arg) return 1;
		else if(call < arg) return -1;
		else return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof RationalNumber)) return false;
		RationalNumber n = (RationalNumber) obj;
		return this.compareTo(n) == 0;
	}
	
	@Override
	public int hashCode() {
		return (int)((double)this.numerator / this.denominator * 100);
	}
}
