package adapter2;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	  protected Covid19Pacient pacient;
	  protected String[] columnNames =
	    new String[] {"Symptom", "Weight" };

	  public Covid19PacientTableModelAdapter(Covid19Pacient p) {
	    this.pacient=p;
	    Iterator<Symptom> iP = pacient.getSymptoms().iterator(); //Hemos serializado los sintomas del cliente
	    while(iP.hasNext()) {
	    	symptoms.add(iP.next());
	    }
	  }

	  public int getColumnCount() {
	    // Challenge!
		 return 2;
	  }

	  public String getColumnName(int i) {
	    // Challenge!
		  return columnNames[i];
	  }

	  public int getRowCount() {
	    // Challenge!
		  return pacient.getSymptoms().size();
		  //return symptoms.size();
	  }

	  public Object getValueAt(int row, int col) {
	    // Challenge!
		  //return "value";
		  Symptom s = symptoms.get(row);
		  if(col==0) return s.getName(); //Devolver sintoma
		  if(col==1) return pacient.getWeight(s); //Devolver el peso del sintoma del paciente
		  return null;
	  }
	}
