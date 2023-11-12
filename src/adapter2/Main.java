package adapter2;

import domain.Covid19Pacient;
import factory.SymptomFactory;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient pacient=new Covid19Pacient("aitor", 35, new SymptomFactory());
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacient);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);
		
		Covid19Pacient pacient2=new Covid19Pacient("ane", 29, new SymptomFactory());
		pacient2.addSymptomByName("fiebre", 3);
		pacient2.addSymptomByName("dolor de garganta", 2);
		pacient2.addSymptomByName("expectoracion", 1);
		
		gui=new ShowPacientTableGUI(pacient2);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);
	}

}
