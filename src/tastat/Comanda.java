package tastat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda {
	
	protected int idComanda;
	protected Client client;
	protected Date dataComanda;
	protected Date dataLliurament;   
	protected ComandaEstat estat;	//PENDENT - PREPARAT - TRANSPORT - LLIURAT
	protected Double portes;		//preu de transport
	protected List <ComandaLinia> linies;
	
	Comanda() {
		idComanda = Generador.getNextComanda();
		dataComanda = new Date();
		dataLliurament = Tools.sumarDies(new Date(), 1);
		estat = ComandaEstat.PENDENT;
		portes = 0.0;
		linies = new ArrayList<ComandaLinia>();
	}

	Comanda(Client client) {
		this();
		this.client = client;
	};	
	
	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDataComanda() {
		return dataComanda;
	}

	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}

	public Date getDataLliurament() {
		return dataLliurament;
	}

	public void setDataLliurament(Date dataLliurament) {
		this.dataLliurament = dataLliurament;
	}

	public ComandaEstat getEstat() {
		return estat;
	}

	public void setEstat(ComandaEstat estat) {
		this.estat = estat;
	}

	public Double getPortes() {
		return portes;
	}

	public void setPortes(Double portes) {
		this.portes = portes;
	}

	public void setLinies(List<ComandaLinia> linies) {
		this.linies = linies;
	}

	List <ComandaLinia> getLinies (){
		return linies;
	}
	
	@Override 
	public String toString() {
		String cadena = "Comanda: " + getIdComanda() + " Client: " + getClient().getNomClient() + " " + getEstat() + "\n";
		for(ComandaLinia cl:getLinies()) 
			cadena = cadena + "  --> Producte: " + cl.getProducte().getNomProducte() + " Quantitat: " + cl.getQuantitat() + "\n";
		return cadena;
	}
}