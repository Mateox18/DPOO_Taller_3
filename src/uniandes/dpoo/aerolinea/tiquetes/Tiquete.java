package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private String codigo;
	private int tarifa;
	private Boolean usado;
	private Cliente cliente;
	private Vuelo vuelo;
	public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
		super();
		this.codigo = codigo;
		this.vuelo = vuelo;
		this.usado = false;
		this.tarifa = tarifa;
		this.cliente = cliente;
	}
	public Boolean esUsado() {
		return usado;
	}
	public void marcarComoUsado() {
		this.usado = true;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getTarifa() {
		return tarifa;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	
}
