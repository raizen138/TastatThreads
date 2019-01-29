package tastat;

public class ProducteFabricacio  {
	private Producte producte;
	private int quantitat = 1;
	private int tempsMin = 0;
	private int tempsMax = 100;
	
	ProducteFabricacio(Producte p, int  q) {
		this(p,q,0,100);		
	};
	ProducteFabricacio(Producte p, int  q, int tm, int tM) {
		producte = p;
		quantitat = q;
		tempsMin = tm;
		tempsMax = tM;
	};
	
	public Producte getCodiProducte() {
		return producte;
	}

	public void setCodiProducte(int codiProducte) {
		this.producte = producte;
	}

	public int getTempsMin() {
		return tempsMin;
	}

	public void setTempsMin(int tempsMin) {
		this.tempsMin = tempsMin;
	}

	public int getTempsMax() {
		return tempsMax;
	}

	public void setTempsMax(int tempsMax) {
		this.tempsMax = tempsMax;
	}

	public void setProducte(Producte p) {
		producte = p;
	}
	
	public Producte getProducte() {
		return producte;
	}
	
	public void setQuantitat (int q) {
		quantitat = q;
	}
	
	public int getQuantitat () {
		return quantitat;
	}
	
	@Override
	public 	String toString() {
		return (producte.getCodiProducte() + " " + producte.nomProducte + ": " + quantitat);
	}
	
}