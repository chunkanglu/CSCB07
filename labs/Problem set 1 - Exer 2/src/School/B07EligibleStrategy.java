package School;

public class B07EligibleStrategy implements EligibleStrategy {

	@Override
	public boolean isEligibile(Student s) {
		return s.passedCSCA48 && (s.cgpa >= 3.5) && s.inCSCPOSt && (!s.passedCSC207);
	}

}
