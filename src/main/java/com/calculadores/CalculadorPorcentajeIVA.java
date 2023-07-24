package com.calculadores; // En el paquete 'calculadores'
 
import org.openxava.calculators.*; // Para usar 'ICalculator'

import com.modelo.*;
 
public class CalculadorPorcentajeIVA implements ICalculator {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -2954743583236824682L;

	public Object calculate() throws Exception {
        return PreferenciasFacturacion.getPorcentajeIVADefecto();
    }
}