package com.bancos;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="id, descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class Bancos extends Incrementable2 {
	
	@Column(length = 6)
	@DefaultValueCalculator(CalculadorConsecutivoBancos.class) // A�o actual	//@ReadOnly // El usuario no puede modificar el valor
	@ReadOnly 	
	@SearchKey
	int numero;
		
}





