package tastat;

import java.util.Date;

public class DiariMoviments {
	protected int numMoviment;
	protected Date moment;
	protected Producte producte;
	protected int lot;
	protected char tipusMoviment;
	protected int quantitat;
	protected String observacions;
	protected Comanda comanda;
	protected OrdreCompra ordreCompra;
	
	DiariMoviments(){
		numMoviment = Generador.getNextDiariMoviment();
		moment = new Date();
	}
	
	public int getNumMoviment() {
		return numMoviment;
	}

	public void setNumMoviment(int numMoviment) {
		this.numMoviment = numMoviment;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public char getTipusMoviment() {
		return tipusMoviment;
	}

	public void setTipusMoviment(char tipusMoviment) {
		this.tipusMoviment = tipusMoviment;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public String getObservacions() {
		return observacions;
	}

	public void setObservacions(String observacions) {
		this.observacions = observacions;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public OrdreCompra getOrdreCompra() {
		return ordreCompra;
	}

	public void setOrdreCompra(OrdreCompra ordreCompra) {
		this.ordreCompra = ordreCompra;
	}

	DiariMoviments(Producte p, int l, char tipusM, int q, String obs) {
		this();
		producte = p;
		lot = l;
		tipusMoviment = tipusM;
		quantitat = q;
		observacions = obs;
	}
	
}