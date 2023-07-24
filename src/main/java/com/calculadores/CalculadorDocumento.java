package com.calculadores; // En el paquete 'calculadores'
 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorDocumento implements ICalculator {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 332256298429394128L;

	public Object calculate() throws Exception {
        /*Query query = XPersistence.getManager().createQuery(
                "select DTYPE from " +
                " DocumentoComercial " + 
                " f ");
            String docc = (String) query.getSingleResult();
            //numero = docc == null ? "DC" : ultimoNumero + 1;
        return docc;*/
        return "FA";
    }
}