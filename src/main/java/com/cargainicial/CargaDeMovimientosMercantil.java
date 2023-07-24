package com.cargainicial;
 
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="id, descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class CargaDeMovimientosMercantil extends Incrementable4 {

    LocalDate fechaDelMovimiento;

    String conceptoDelMovimiento;
    
    String numeroDeReferencia;
    
    Double montoDeGastos;
    
    Double montoDeIngresos;
    
}





