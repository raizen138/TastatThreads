package tastat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Magatzem {
	
	private List<Producte> magatzem = new ArrayList <Producte>();
	private List<Client>  clients = new ArrayList <Client> ();
	private List<Comanda> comandes = new ArrayList <Comanda>();
    private List<Proveidor> proveidors = new ArrayList <Proveidor>(); 
    private List<Operari> operaris = new ArrayList <Operari>(); 
    private List<DiariMoviments> moviments = new ArrayList <DiariMoviments>();
    private List<OrdreCompra> compres = new ArrayList<OrdreCompra>();
	
    Magatzem(){
	}
	
	Magatzem(List<Producte> lp, List<Client> lc, List<Comanda> lm, List<Proveidor> lpv, List<Operari> lop, List<DiariMoviments> ldm, List<OrdreCompra>loc){
		magatzem = lp;
		clients = lc;
		comandes = lm;
		proveidors = lpv;
		operaris = lop;
		moviments = ldm;
		compres = loc;
	}
	
	boolean afegirQuantitatProducte(int codiProducte, int quantitat){
		boolean trobat = false;
		for (Producte p: magatzem) {
			if (p.getCodiProducte() == codiProducte) {
				p.setStock(p.getStock() + quantitat);
				trobat = true;
				break;
			}
		}
		return trobat;
	}
	
	boolean afegirProducte(Producte prod) {
		boolean trobat = false;
		for (Producte p: magatzem) {
			if (p.getCodiProducte() == prod.getCodiProducte()) {
				trobat = true;
				break;
			}
		}
		if (trobat) 
			return false;
		else {
			magatzem.add(prod);
			return true;
		}
	}
	
	public List <Producte>getProductes(){
		return magatzem;
	}
	
	public List <Client> getClients(){
		return clients;
	}
	
	public List<Comanda> getComandes(){
		return comandes;
	}
	
	public List<Proveidor> getProveidors(){
		return proveidors;
	}
	
	public List<Operari> getOperaris(){
		return operaris;
	}
	
	public Deque<LotDesglossat> apilarCaducats () {
		Iterator<LotDesglossat> it = null;		
		Deque<LotDesglossat> pila = new ArrayDeque<LotDesglossat>();
		LotDesglossat ldg;
		Date avui = new Date();
		for (Producte p: magatzem) {
			it = p.lots.iterator();
			while (it.hasNext()) {
				ldg = it.next();
				if(ldg.getDataCaducitat().compareTo(avui)<0) {
					pila.push((ldg));
					it.remove();
				}
			}
		}
		return pila;
	}
		
	
	public boolean add(Producte p) {
		magatzem.add(p);
		return true;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for (Producte p : magatzem)
			s +=  "\n" + p;
		s += "\nTotal " + magatzem.size() + " Refer�ncies";
		return s;
	}
	
	public void veureComandes() {
		for(Comanda c :this.getComandes()) {
			System.out.println(c);
		}
	}
}
