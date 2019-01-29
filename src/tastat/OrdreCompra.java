package tastat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdreCompra {
	
	protected int idOrdre;
	protected Proveidor proveidor;
	protected Date dataOrdre;
	protected OrdreEstat estat;	//PENDENT - LLIURAT
	protected Producte producte;
	protected int quantitat;
	
	OrdreCompra() {
		idOrdre = Generador.getNextOrdreCompra();
		dataOrdre = new Date();
		estat = OrdreEstat.PENDENT;
	}

	OrdreCompra(Proveidor prov, Producte prod, int q) {
		this();
		this.proveidor = prov;
		producte = prod;
		quantitat = q;		
	}

	public int getIdOrdre() {
		return idOrdre;
	}

	public void setIdOrdre(int idOrdre) {
		this.idOrdre = idOrdre;
	}

	public Proveidor getProveidor() {
		return proveidor;
	}

	public void setProveidor(Proveidor proveidor) {
		this.proveidor = proveidor;
	}

	public Date getDataOrdre() {
		return dataOrdre;
	}

	public void setDataOrdre(Date dataOrdre) {
		this.dataOrdre = dataOrdre;
	}

	public OrdreEstat getEstat() {
		return estat;
	}

	public void setEstat(OrdreEstat estat) {
		this.estat = estat;
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
	};	
}