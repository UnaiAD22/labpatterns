package adapter;

import java.util.Comparator;
import java.util.Iterator;

import domain.*;
import factory.SymptomFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Covid19Pacient p = new Covid19Pacient("Asier", 20, new SymptomFactory());
		// Creamos los sintomas
		Symptom s1 = new Symptom("Tos", 10, 3);
		Symptom s2 = new Symptom("Fiebre", 7, 4);
		Symptom s3 = new Symptom("Vomito", 6, 3);
		Symptom s4 = new Symptom("Dolor abdominal", 3, 2);
		Symptom s5 = new Symptom("Astenia", 1, 6);

		// Añadimos los sintomas
		p.addSymptom(s1, 1);
		p.addSymptom(s2, 2);
		p.addSymptom(s3, 3);
		p.addSymptom(s4, 4);
		p.addSymptom(s5, 5);

		InvertedIterator i = new Covid19Adapter(p);

		Comparator<Symptom> symptomNameComparator = new SymptomNameComparator();

		Comparator<Object> objectSymptomNameComparator = (symptom1, symptom2) -> symptomNameComparator
				.compare((Symptom) symptom1, (Symptom) symptom2);

		Iterator<Object> iteratorByName = Sorting.sortedIterator(i, objectSymptomNameComparator);
		System.out.println("Ordenado por el nombre del sintoma:");
		while (iteratorByName.hasNext()) {
			Symptom symptom = (Symptom) iteratorByName.next();
			System.out.println("Sintoma: " + symptom.getName() + ", Severidad: " + symptom.getSeverityIndex());
		}


		System.out.println();

		Comparator<Symptom> severityIndexComparator = new SeverityIndexComparator();

		Comparator<Object> objectSeverityIndexComparator = (symptom1, symptom2) -> severityIndexComparator
				.compare((Symptom) symptom1, (Symptom) symptom2);

		Iterator<Object> iteratorBySeverity = Sorting.sortedIterator(i, objectSeverityIndexComparator);
		System.out.println("Ordenado de menor a mayor por el indice de severidad:");
		while (iteratorBySeverity.hasNext()) {
			Symptom symptom = (Symptom) iteratorBySeverity.next();
			System.out.println("Sintoma: " + symptom.getName() + ", Severidad: " + symptom.getSeverityIndex());
		}

	}

}
