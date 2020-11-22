package EncriptadoVigenere;

public class pruebaEncriptado {

	public static void main(String[] args) {
		 Modelo mo = new Modelo();
	        Vista vi = new Vista();
	        Controlador c = new Controlador(mo, vi);
	        c.arrancar(); // Arranca la interfaz ( vista )

	}

}
