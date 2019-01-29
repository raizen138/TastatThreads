package tastat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		// 1.- Generació d'un magatzem petitó
		Magatzem elMeuMagatzem = new Magatzem(new ArrayList<Producte>(), new ArrayList<Client>(),
				new ArrayList<Comanda>(), new ArrayList<Proveidor>(), new ArrayList<Operari>(), 
				new ArrayList<DiariMoviments>(), new ArrayList<OrdreCompra>());

		Deque cuaMissatges = new ArrayDeque<Missatge>();

		generarClients(elMeuMagatzem.getClients());
		generarProveidors(elMeuMagatzem.getProveidors());
		generarOperaris(elMeuMagatzem.getOperaris());
		generarProductes(elMeuMagatzem);
		generarComandes(elMeuMagatzem);

		System.out.println("Veure Magatzem:");
		System.out.println(elMeuMagatzem);

		// 2.- Veure la composició dels productes del magatzem
		for (Producte p : elMeuMagatzem.getProductes())
			if (p.getTipus() == Tipus.VENDIBLE)
				System.out.println(p.veureComposicio());

		// 3.- Veure magatzem ordenat per nom producte
		elMeuMagatzem.getProductes().sort(null);
		System.out.println("3.- Magatzem ordenat per nomProducte");
		System.out.println(elMeuMagatzem);

		// 4.- Veure magatzem ordenat per stock

		System.out.println("3.- Magatzem ordenat per Stock");
		elMeuMagatzem.getProductes().sort(null);
		System.out.println(elMeuMagatzem);
		
		// 5.- Veure les comandes
		System.out.println("5.- Veure les comandes");
		elMeuMagatzem.veureComandes();
		
	}

	private static void generarClients(List<Client> lc) {

		lc.add(new Client("La Canasta", 39.1174353, -5.7933869));
		lc.add(new Client("Baires", 41.5442476, 2.0604163));
		lc.add(new Client("Pierre Herme", 48.8513876, 2.3304912));
		lc.add(new Client("Aux Pains de Papy", 51.5293753, -0.1903852));
		lc.add(new Client("La Santiaguesa", 40.9284811, -5.2618384));

		lc.add(new Client("MIX", 41.5525456, 2.0682696));
		lc.add(new Client("La Flor Negra", 39.0492284, -5.6562213));
		lc.add(new Client("Bead Barn", 0.2041477, -10.7433573));
		lc.add(new Client("Smeterling Patisserie", -34.59267, -58.3898747));
		lc.add(new Client("Es Ruiz", -34.6254113, -58.4426792));
	}

	private static void generarProveidors(List<Proveidor> lp) {
		lp.add(new Proveidor("UNOproveidor", 300));
		lp.add(new Proveidor("DOSproveidor", 500));
		lp.add(new Proveidor("TRESproveidor", 100));
	}

	private static void generarOperaris(List<Operari> lop) {
		lop.add(new Operari("Aniceto"));
		lop.add(new Operari("Bonifacio"));
		lop.add(new Operari("Carolina"));
	}

	private static void generarProductes(Magatzem mgz) {

		Proveidor pv1 = mgz.getProveidors().get(0);
		Proveidor pv2 = mgz.getProveidors().get(1);
		Proveidor pv3 = mgz.getProveidors().get(2);

		Producte pliv = new Producte("pLiviano", UnitatMesura.UNITAT, 0, null, 1500);
		Producte pllim = new Producte("pLlimona", UnitatMesura.UNITAT, 0, null, 1000);
		Producte peri = new Producte("pErizo", UnitatMesura.UNITAT, 0, null, 1000);
		Producte pvel = new Producte("pVelvet", UnitatMesura.UNITAT, 0, null, 1400);

		Date dataCaducitat;

		Producte p3 = new Producte("sucre", UnitatMesura.GRAMS, 100000, pv3);
		dataCaducitat = Tools.sumarDies(new Date(), 10);
		p3.afegirLot(40000, dataCaducitat);
		p3.afegirLot(30000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(dataCaducitat, 20);
		p3.afegirLot(70000, dataCaducitat);
		mgz.add(p3);

		Producte p4 = new Producte("ous", UnitatMesura.UNITAT, 240, pv3);
		p4.afegirLot(480, dataCaducitat);
		mgz.add(p4);

		Producte p5 = new Producte("farina", UnitatMesura.GRAMS, 30000, pv3);
		p5.afegirLot(10000, dataCaducitat);
		p5.afegirLot(20000, dataCaducitat);
		mgz.add(p5);

		Producte p6 = new Producte("llevadura", UnitatMesura.GRAMS, 5000, pv2);
		p6.afegirLot(200, (new Date()));
		dataCaducitat = Tools.sumarDies(new Date(), -5);
		p6.afegirLot(400, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 5);
		p6.afegirLot(100, dataCaducitat);
		mgz.add(p6);

		Producte pSec = new Producte("Secret", UnitatMesura.UNITAT, 0, pv2);
		pSec.setStock(100);

		Producte p8 = new Producte("nabius", UnitatMesura.GRAMS, 4000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p8.afegirLot(2000, dataCaducitat);
		p8.setProveidor(pv2);
		mgz.add(p8);

		Producte p9 = new Producte("llimona", UnitatMesura.GRAMS, 4000, pv2);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p9.afegirLot(2000, dataCaducitat);
		mgz.add(p9);

		Producte p11 = new Producte("albahaca", UnitatMesura.GRAMS, 4000, pv2);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p11.afegirLot(2000, dataCaducitat);
		mgz.add(p11);

		Producte p14 = new Producte("mantequilla", UnitatMesura.GRAMS, 2000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p14.afegirLot(2000, dataCaducitat);
		mgz.add(p14);

		Producte p15 = new Producte("cacau", UnitatMesura.GRAMS, 4000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p15.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p15.afegirLot(2000, dataCaducitat);
		mgz.add(p15);

		Producte p16 = new Producte("cafe", UnitatMesura.GRAMS, 4000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p16.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p16.afegirLot(2000, dataCaducitat);
		mgz.add(p16);

		Producte p17 = new Producte("xocolata", UnitatMesura.GRAMS, 3000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 80);
		p17.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 100);
		p17.afegirLot(2000, dataCaducitat);
		mgz.add(p17);

		Producte p18 = new Producte("margarina", UnitatMesura.GRAMS, 4000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p18.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p18.afegirLot(2000, dataCaducitat);
		mgz.add(p18);

		Producte p19 = new Producte("vahinilla", UnitatMesura.GRAMS, 4000, pv3);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p19.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 180);
		p19.afegirLot(2000, dataCaducitat);
		mgz.add(p19);

		Producte p20 = new Producte("vinagresidra", UnitatMesura.GRAMS, 4000, pv2);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p20.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p20.afegirLot(2000, dataCaducitat);
		mgz.add(p20);

		Producte p21 = new Producte("formatge", UnitatMesura.GRAMS, 2000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p21.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p21.afegirLot(2000, dataCaducitat);
		mgz.add(p21);

		Producte p22 = new Producte("bicarbonat", UnitatMesura.GRAMS, 4000, pv2);
		dataCaducitat = Tools.sumarDies(new Date(), 500);
		p22.afegirLot(5000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 500);
		p22.afegirLot(2000, dataCaducitat);
		mgz.add(p22);

		Producte p23 = new Producte("surollet", UnitatMesura.GRAMS, 2000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p23.afegirLot(2000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 150);
		p23.afegirLot(2000, dataCaducitat);
		mgz.add(p23);

		Producte p24 = new Producte("sal", UnitatMesura.GRAMS, 2000, pv1);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p24.afegirLot(3000, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 10);
		p16.afegirLot(500, dataCaducitat);
		mgz.add(p24);

		Producte p25 = new Producte("codonyat", UnitatMesura.GRAMS, 500, pv3);
		dataCaducitat = Tools.sumarDies(new Date(), 50);
		p25.afegirLot(200, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 10);
		p25.afegirLot(200, dataCaducitat);
		mgz.add(p25);

		pliv.setTipus(Tipus.VENDIBLE);
		pllim.setTipus(Tipus.VENDIBLE);
		peri.setTipus(Tipus.VENDIBLE);
		pvel.setTipus(Tipus.VENDIBLE);

		pliv.afegirFabricacioPas(p3, 115, 1, 2);
		pliv.afegirFabricacioPas(p4, 4, 2, 2);
		pliv.afegirFabricacioPas(p5, 115, 3, 3);
		pliv.afegirFabricacioPas(p6, 10, 2, 6);
		pliv.afegirFabricacioPas(p9, 40, 2, 4);
		pliv.afegirFabricacioPas(pSec, 1, 3, 6);

		pllim.afegirFabricacioPas(p3, 4, 1, 3);
		pllim.afegirFabricacioPas(p6, 8, 1, 3);
		pllim.afegirFabricacioPas(p9, 1, 2, 4);
		pllim.afegirFabricacioPas(pSec, 1, 3, 6);
		pllim.afegirFabricacioPas(p11, 20, 1, 5);

		peri.afegirFabricacioPas(p3, 170, 1, 3);
		peri.afegirFabricacioPas(p4, 3, 1, 3);
		peri.afegirFabricacioPas(p5, 130, 2, 4);
		peri.afegirFabricacioPas(pSec, 1, 3, 6);
		peri.afegirFabricacioPas(p14, 170, 4, 5);
		peri.afegirFabricacioPas(p15, 170, 2, 3);
		peri.afegirFabricacioPas(p16, 40, 1, 2);
		peri.afegirFabricacioPas(p17, 50, 2, 5);
		peri.afegirFabricacioPas(p18, 150, 2, 3);

		pvel.afegirFabricacioPas(p3, 500, 1, 3);
		pvel.afegirFabricacioPas(p4, 2, 2, 3);
		pvel.afegirFabricacioPas(p5, 250, 2, 4);
		pvel.afegirFabricacioPas(pSec, 2, 4, 7);
		pvel.afegirFabricacioPas(p14, 225, 1, 3);
		pvel.afegirFabricacioPas(p15, 15, 2, 3);
		pvel.afegirFabricacioPas(p19, 30, 1, 2);
		pvel.afegirFabricacioPas(p20, 100, 3, 3);
		pvel.afegirFabricacioPas(p21, 230, 1, 4);
		pvel.afegirFabricacioPas(p22, 170, 2, 3);
		pvel.afegirFabricacioPas(p23, 240, 1, 4);
		pvel.afegirFabricacioPas(p24, 30, 3, 6);

		mgz.add(pliv);
		mgz.add(pllim);
		mgz.add(peri);
		mgz.add(pvel);
	}

	private static void generarComandes(Magatzem mgz) {

		Producte pliv = null, pllim = null, peri = null, pvel = null;
		for (Producte p : mgz.getProductes()) {
			if (p.getNomProducte().equals("pLiviano"))
				pliv = p;
			if (p.getNomProducte().equals("pLlimona"))
				pllim = p;
			if (p.getNomProducte().equals("pErizo"))
				peri = p;
			if (p.getNomProducte().equals("pVelvet"))
				pvel = p;
		}

		int nC = (int) (Math.random() * 4) + 1;
		int q;

		for (int i = 0; i < nC; i++)
			for (Client c : mgz.getClients()) {
				Comanda m1 = new Comanda(c);
				q = (int) (Math.random() * 100);
				m1.getLinies().add(new ComandaLinia(pliv, (int) (Math.random() * 100)));
				m1.getLinies().add(new ComandaLinia(pllim, (int) (Math.random() * 30)));
				m1.getLinies().add(new ComandaLinia(peri, (int) (Math.random() * 60)));
				m1.getLinies().add(new ComandaLinia(pvel, (int) (Math.random() * 50)));
				mgz.getComandes().add(m1);
			}
	}
}
