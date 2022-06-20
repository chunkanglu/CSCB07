package lab4;

import java.util.List;

public abstract class SpecialNumber {
	public abstract SpecialNumber add(SpecialNumber n) throws Lab4Exception;
	public abstract SpecialNumber divideByInt(int i) throws Lab4Exception;
	
	/**
	 * Averages a list of items of type SpecialNumber.
	 * @param l the List of SpecialNumber
	 * @return new SpecialNumber representing the average of the List
	 * @throws Lab4Exception
	 */
	public static SpecialNumber computeAverage(List<SpecialNumber> l) throws Lab4Exception{
		if(l == null || l.isEmpty()) {
			throw new Lab4Exception("List cannot be empty");
		}
		
		int n = l.size();
		SpecialNumber out = l.get(0);
		for(int i=1; i<n; i++) {
			out = out.add(l.get(i));
		}
		return out.divideByInt(n);
	}
}
