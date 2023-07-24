package com.cargainicial;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="id, descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class CargaDeMovimientosBanesco extends Incrementable2 {
	
    String fecha;

    String referencia;
        
    String monto;
    
    Double balance;
	
}





