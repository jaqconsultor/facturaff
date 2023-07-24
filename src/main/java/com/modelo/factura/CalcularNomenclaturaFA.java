package com.modelo.factura; // En el paquete 'calculadores'
 
import java.util.*;

import javax.persistence.*;

import org.openxava.calculators.*; // Para usar 'ICalculator'
import org.openxava.jpa.*;
 
public class CalcularNomenclaturaFA implements ICalculator {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -2570076809989924497L;

	public Object calculate() throws Exception {
    	String numero;
    	 Query query = XPersistence.getManager().createQuery(
                 "select max(f.numero) from " +
                 " Facturas " + 
                 " f ");
         Long ultimoNumero = (Long) query.getSingleResult();
         Long nNumero;
         nNumero = ultimoNumero == null ? 1 : ultimoNumero + 1;

        Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
        
		long year = (long) (cal.get(Calendar.YEAR));
        long mes = (long) (cal.get(Calendar.MONTH));
        long dia = (long) (cal.get(Calendar.DAY_OF_MONTH));
        
        numero = "FAC/" + nNumero.toString() + "/" +  year + "/" + mes + "/" + dia ; 
        
        return numero;
    }
}