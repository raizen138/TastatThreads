package tastat;

public class ComandaLinia {
	protected Producte producte;
	protected int quantitat;
	protected double preuVenda;
    protected int quantitatPreparada;
    protected int quantitatPendent;
    
	ComandaLinia(Producte p, int q, double preu) {
		producte = p;
		quantitat = q;
		preuVenda = preu;
		quantitatPreparada = 0;
		quantitatPendent = q;
	}
	
	ComandaLinia(Producte p, int q){
		producte = p;
		quantitat = q;
		preuVenda = p.getPreuVenda();
		quantitatPreparada = 0;
		quantitatPendent = q;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;		
	}

	public double getPreuVenda() {
		return preuVenda;
	}

	public void setPreuVenda(double preuVenda) {
		this.preuVenda = preuVenda;
	}

	public int getQuantitatPreparada() {
		return quantitatPreparada;
	}

	public void setQuantitatPreparada(int quantitatPreparada) {
		this.quantitatPreparada = quantitatPreparada;
	}

	public int getQuantitatPendent() {
		return quantitatPendent;
	}

	public void setQuantitatPendent(int quantitatPendent) {
		this.quantitatPendent = quantitatPendent;
	}

}