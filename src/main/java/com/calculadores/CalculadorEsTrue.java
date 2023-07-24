package com.calculadores; // En el paquete 'calculadores'
 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorEsTrue implements ICalculator {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Object calculate() throws Exception {
        Boolean ultimoNumero = true;
        return ultimoNumero;
    }
}