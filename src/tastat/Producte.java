package tastat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Producte implements Comparable<Producte> {

	protected int codiProducte;
	protected String nomProducte;
	protected int stock;
	protected int stockMinim;
	protected UnitatMesura unitat;
	protected List<ProducteFabricacio> fabricacio;
	protected List <LotDesglossat> lots;
	protected Tipus tipus;
	protected Proveidor proveidor;
	protected double preuVenda;
	protected double pes;
	protected int quantitatCompra;

	Producte() {
		codiProducte = Generador.getNextProducte();
		lots = new ArrayList<LotDesglossat>();
		fabricacio = new ArrayList<ProducteFabricacio>();
		
		tipus = Tipus.INGREDIENT;
		stockMinim = 0;
		stock = 0;
		quantitatCompra = 100;
	}

	Producte(String nomProducte){
		this();
		this.nomProducte = nomProducte;
	}
	
	Producte(String nomProducte, UnitatMesura u, int sm){
		this(nomProducte);
		this.setUnitatMesura(u);
		this.stockMinim = sm;
	};
	
	Producte(String nomProducte, UnitatMesura u, int sm, Proveidor pv){
		this(nomProducte, u, sm);
		proveidor = pv;
	};
	
	Producte(String nomProducte, UnitatMesura u, int sm, Proveidor pv, double preu){
		this(nomProducte, u, sm, pv);
		preuVenda = preu;
	};

	
	public UnitatMesura getUnitat() {
		return unitat;
	}

	public void setUnitat(UnitatMesura unitat) {
		this.unitat = unitat;
	}

	public List<LotDesglossat> getLots() {
		return lots;
	}

	public void setLots(List<LotDesglossat> lots) {
		this.lots = lots;
	}

	public double getPes() {
		return pes;
	}

	public void setPes(double pes) {
		this.pes = pes;
	}

	public void setCodiProducte(int codiProducte) {
		this.codiProducte = codiProducte;
	}

	public void setComposicio(List<ProducteFabricacio> fabricacio) {
		this.fabricacio = fabricacio;
	}

	
	public void afegirLot (int quantitat, Date dataCaducitat) {
		int qLot = Generador.getNextLot();
		lots.add(new LotDesglossat(qLot,dataCaducitat,quantitat));
	}
	
	public String veureLots() {
		String cadena = "";
		for(LotDesglossat ld: lots) {
			cadena+="   "+ ld + "\n";
		}
		return cadena;
	}
	
	public String getNomProducte() {
		return nomProducte;
	}

	public void setNomProducte(String nom) {
		nomProducte = nom;
	}

	@Override
	public String toString() {
		String cadena = "Producte: " + codiProducte + "\t - " + nomProducte + "\tStock Total: " + getStock() + " " + unitat ;
		cadena = cadena + "\tStockMínim:" + stockMinim + "\t" + tipus;
		return cadena;
	}

	
	
	public void setTipus(Tipus tipus) {
		this.tipus = tipus;
	}
	
	public Tipus getTipus() {
		return tipus;
	}
	
	public void setProveidor(Proveidor pv) {
		this.proveidor = pv;
	}
	
	public Proveidor getProveidor() {
		return proveidor;
	}
	
	
	public UnitatMesura getUnitatMesura() {
		return unitat;
	}

	public void setUnitatMesura(UnitatMesura unitatm) {
		unitat = unitatm;
	}

	void setStock(int q) {
		stock = q;
	}

	public void setStockMinim(int stockM) {
		stockMinim = stockM;
		if (stockM!=0)	quantitatCompra = stockM*2; 
	}

	public int getStockMinim() {
		return stockMinim;
	}

	public void setPreuVenda(double preuVenda) {
		this.preuVenda = preuVenda;
	}

	public double getPreuVenda() {
		return preuVenda;
	}

	public List <ProducteFabricacio> getFabricacio() {
		return fabricacio;
	}

	public void afegirFabricacioPas(Producte p, int q, int tempsMin, int tempsMax) {
		
		ProducteFabricacio pf = new ProducteFabricacio(p,q,tempsMin,tempsMax);
		
		fabricacio.add(pf);
	}

	public String veureComposicio() {
		String cadena = "";
		cadena = getNomProducte() + " --> ";
		for (ProducteFabricacio pf : this.getFabricacio()) 
			cadena += pf.getProducte().getNomProducte() + "(" + pf.getProducte().getNomProducte() + ") ";
		return cadena;
	}
	
	@Override
	public int compareTo(Producte p) {
		return (getNomProducte().compareTo(p.getNomProducte()));
	}

	public int getCodiProducte() {
		return codiProducte;
	}

	private int calcularStockLote() {
		int q =0;
		for(LotDesglossat l:lots) {
			q+=l.getQuantitat();
		}
		return q;
	}
	
	
	public int getStock() {
		return(stock + this.calcularStockLote());
	}
	
	public String veureLotsOrdenats() {
		lots.sort(null);
		String cadena = "";
		for(LotDesglossat ld: lots) {
			cadena+="   "+ ld + "\n";
		}
		return cadena;
	}
	
}