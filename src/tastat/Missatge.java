package tastat;

import java.util.Set;

public class Missatge{
	
	protected Operari operari;
	protected String missatge;

	Missatge(Operari o, String m){
		operari = o;
		missatge = m;
	}
	
	@Override
	public String toString() {
		return (operari.getNomOperari() + ": " + missatge);
	}

}