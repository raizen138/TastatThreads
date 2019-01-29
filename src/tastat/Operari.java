package tastat;

import java.util.Set;

public class Operari{
	
	protected int idOperari;
	protected String nomOperari;
	protected int numPastissos;
	
	Operari(){
		idOperari = Generador.getNextOperari();
		numPastissos = 0;
	}
	
	public int getNumPastissos() {
		return numPastissos;
	}

	public void setNumPastissos(int numPastissos) {
		this.numPastissos = numPastissos;
	}

	Operari(String nom){
		this();
		nomOperari = nom;
	}

	@Override
	public String toString() {
		return (idOperari + ": " + getNomOperari());
	}

	public int getIdOperari() {
		return idOperari;
	}

	public String getNomOperari() {
		return nomOperari;
	}

	public void setNomOperari(String nomOperari) {
		this.nomOperari = nomOperari;
	}
}