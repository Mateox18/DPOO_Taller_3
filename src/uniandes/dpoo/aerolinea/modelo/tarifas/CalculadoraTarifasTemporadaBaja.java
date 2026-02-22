package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final double DESCUENTO_GRANDES = 0.2;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_PEQ = 0.02;
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		int costo = 0;
		
		Ruta ruta = vuelo.getRuta();
		Aeropuerto origen  = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(origen, destino);
		if (cliente.getTipoCliente().equals("CORPORATIVO")) {
			costo = COSTO_POR_KM_CORPORATIVO * distancia; 
		}
		else
			costo = COSTO_POR_KM_NATURAL * distancia;
		return costo;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		if (cliente.getTipoCliente().equals("CORPORATIVO")) {
			if(((ClienteCorporativo) cliente).getTamanoEmpresa() == 1) {
				return DESCUENTO_PEQ;
			}
			else if(((ClienteCorporativo) cliente).getTamanoEmpresa() == 2) {
				return DESCUENTO_MEDIANAS;
			}
			else if(((ClienteCorporativo) cliente).getTamanoEmpresa() == 3) {
				return DESCUENTO_GRANDES;
			}
		}
		return 0;
	}

}
