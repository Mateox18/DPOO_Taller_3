package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Iterator;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private ArrayList<Tiquete> tiquetesSinUsar; 
	private ArrayList<Tiquete> tiquetesUsados; 
	
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<Tiquete> ();
		this.tiquetesUsados = new ArrayList<Tiquete> ();
	}
	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetesSinUsar.add(tiquete);
	}
	public int calcularValorTotalTiquetes() {
		int total = 0;
		for (Tiquete tiquete: this.tiquetesUsados) {
			total += tiquete.getTarifa();
		}
		for (Tiquete tiquete: this.tiquetesSinUsar) {
			total += tiquete.getTarifa();
		}
		return total;
		
	}
	public ArrayList<Tiquete> getTiquetesSinUsar() {
		return tiquetesSinUsar;
	}
	public abstract String getIdentificador();
	public abstract String getTipoCliente();
	public void usarTiquetes(Vuelo vuelo) {
		Iterator<Tiquete> it = this.tiquetesSinUsar.iterator();

		while (it.hasNext()) {
		    Tiquete t = it.next();
		    if (t.getVuelo().equals(vuelo)) {
		    	t.marcarComoUsado();
		        it.remove(); 
		        this.tiquetesUsados.add(t);
		    }
		}
	}
}
