package tastat;

public class Generador{
	private static int lotActual=0;
	private static int producteActual = 0;
	private static int clientActual = 0;
	private static int proveidorActual = 0;
	private static int comandaActual = 0;
	private static int diariMovimentsActual = 0;
	private static int ordreCompraActual = 0;
	private static int operariActual = 0;
	
	public static int getNextLot() {
		return ++lotActual;
	}
	
	public static int getNextProducte() {
		return ++producteActual;
	}
	
	public static int getNextClient() {
		return ++clientActual;
	}

	public static int getNextComanda() {
		return ++comandaActual;
	}
	
	public static int getNextProveidor() {
		return ++proveidorActual;
	}
	
	public static int getNextDiariMoviment() {
		return ++diariMovimentsActual;
	}
	
	public static int getNextOrdreCompra() {
		return ++ordreCompraActual;
	}
	
	public static int getNextOperari() {
		return ++operariActual;
	}
}
