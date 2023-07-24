package com.calculadores; // En el paquete calculadores
 
//Para usar getManager()
import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.productos.*;

import lombok.*;
 
public class CalculadorPrecioPorUnidad implements ICalculator {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 7254556281034435350L;
	@Getter @Setter
    int numeroProducto;
 
    @Override
    public Object calculate() throws Exception {
        Catalogo producto = getManager() // getManager() de XPersistence
            .find(Catalogo.class, numeroProducto); // Busca el producto
        return producto.getPrecioDeVenta();    // Retorna su precio
    }
 
}