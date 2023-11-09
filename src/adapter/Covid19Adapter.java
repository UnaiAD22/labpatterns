package adapter;

import java.util.Set;

import domain.*;

public class Covid19Adapter implements InvertedIterator {
	private Set<Symptom> symptoms;
	private Symptom[] symptomArray;
	private int currentIndex;

	public Covid19Adapter(Covid19Pacient p) {
		symptoms = p.getSymptoms();
		symptomArray = symptoms.toArray(new Symptom[0]);
		currentIndex = symptomArray.length - 1;
	}

	@Override
	public Object previous() {
		if (currentIndex >= 0) {
			return symptomArray[currentIndex--];
		}
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return currentIndex >= 0;
	}

	@Override
	public void goLast() {
		currentIndex = symptomArray.length - 1;
	}

}