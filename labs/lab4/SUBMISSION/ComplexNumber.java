package lab4;

import java.lang.Math;
import java.lang.Comparable;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber>{
	double real;
	double imaginary;
	
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	@Override
	public ComplexNumber add(SpecialNumber n) throws Lab4Exception {
		if(! (n instanceof ComplexNumber)) {
			throw new Lab4Exception("Cannot add an incompatible type");
		}
		ComplexNumber x = (ComplexNumber) n;
		return new ComplexNumber(this.real + x.real, this.imaginary + x.imaginary);
	}
	
	@Override
	public ComplexNumber divideByInt(int i) throws Lab4Exception {
		if(i == 0) {
			throw new Lab4Exception("Cannot divide by zero");
		}
		return new ComplexNumber(this.real / i, this.imaginary / i);
	}
	
	public int compareTo(ComplexNumber n) {
		double call = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
		double arg = Math.sqrt(Math.pow(n.real, 2) + Math.pow(n.imaginary, 2));
		if(call > arg) return 1;
		else if(call < arg) return -1;
		else return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ComplexNumber)) return false;
		ComplexNumber n = (ComplexNumber) obj;
		return (this.real == n.real) && (this.imaginary == n.imaginary);
	}
	
	@Override
	public int hashCode() {
		return (int)(Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2)) * 100);
	}
}
