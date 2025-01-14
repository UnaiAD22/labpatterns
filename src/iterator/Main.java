package iterator;

import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import adapter2.ShowPacientTableGUI;
import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptomFactory;

	public class Main {

		public static void main(String[] args) {
			Covid19Pacient p=new Covid19Pacient("Ane", 29, new SymptomFactory()); //Cambiar el nombre de os sintomas
			/*p.addSymptom(new Symptom("s1", 10, 10), 1);
			p.addSymptom(new Symptom("s2", 10, 10), 2);
			p.addSymptom(new Symptom("s3", 10, 10), 3);
			p.addSymptom(new Symptom("s4", 10, 10), 4);
			p.addSymptom(new Symptom("s5", 10, 10), 5);*/
			
			p.addSymptom(new Symptom("Disnea", 10, 10), 2);
			p.addSymptom(new Symptom("Cafalea", 10, 10), 1);
			p.addSymptom(new Symptom("Astenia", 10, 10), 3);
			
			ShowPacientTableGUI gui = new ShowPacientTableGUI(p);
			gui.setVisible(true);
			
			/*Iterator i=p.iterator();
			while(i.hasNext())
				System.out.println(i.next());*/

		}

	}

