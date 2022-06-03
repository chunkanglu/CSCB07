package lab2;

public class Polynomial {
	private double[] coefficients;

	public Polynomial() {
		coefficients = new double[1];;
	}

	public Polynomial(double[] coefficients) {
		this.coefficients = new double[coefficients.length]; 
		for(int i=0; i<coefficients.length; i++){
			this.coefficients[i] = coefficients[i];
		}
	}

	public Polynomial add(Polynomial p) {
		Polynomial shorter;
		Polynomial longer;
		if(p.coefficients.length >= this.coefficients.length){
			longer = p;
			shorter = this;
		}
		else {
			longer = this;
			shorter = p;
		}

		double[] new_coe = new double[longer.coefficients.length];
		for(int i=0; i<longer.coefficients.length; i++){
			new_coe[i] = longer.coefficients[i];
			if(i < shorter.coefficients.length){
				new_coe[i] += shorter.coefficients[i];
			}
		}
		return new Polynomial(new_coe);
	}

	public double evaluate(double x) {
		double ans = 0;
		for(int i=0; i<coefficients.length; i++){
			ans += coefficients[i] * Math.pow(x, i);
		}
		return ans;
	}

	public boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}

}
