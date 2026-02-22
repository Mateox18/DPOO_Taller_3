package uniandes.dpoo.aerolinea.modelo;

import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;


public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String, Tiquete> tiquetes;
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		super();
		this.fecha = fecha;
		this.avion = avion;
		this.ruta = ruta;
		this.tiquetes = new HashMap<String, Tiquete>();
	}
	public String getFecha() {
		return fecha;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public Avion getAvion() {
		return avion;
	}
	public Map<String, Tiquete> getTiquetes() {
		return tiquetes;
	}
	@Override
	public boolean equals(Object obj) {
		 Vuelo otro = (Vuelo) obj;
		    
		 return fecha.equals(otro.fecha) &&
		           ruta.equals(otro.ruta);
	}
	public int vender_tiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException{
		int resultado = calculadora.calcularTarifa(this, cliente);
		int total = 0;
		int tiqVen = this.getTiquetes().size() + cantidad ;
		if (this.getAvion().getCapacidad() < tiqVen) {
			throw new VueloSobrevendidoException(this);
		}
		for(int i = 0; i < cantidad; i ++) {
			Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, resultado);
			tiquetes.put(tiquete.getCodigo(), tiquete);
		}
		return total;
	}
}
