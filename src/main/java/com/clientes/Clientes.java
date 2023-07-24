package com.clientes;
 
import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="id, razonSocialDelCliente" // Muestra únicamente numero y nombre en la misma línea
)


@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"numero; rif; nit; razonSocialDelCliente; " +
"telefonoPrincipal, telefonoSecundario; direccionDelCliente; correoDelCliente;" +
"activo;"
)

//@Tab(name = "Activos", baseCondition = "${activo} = true", properties="rif, nit")
//@Tab(name = "InActivos", baseCondition = "${activo} = false", properties="rif, razonSocialDelCliente")

@Tab(name = "Activos", baseCondition = "${activo} = true")
@Tab(name = "InActivos", baseCondition = "${activo} = false")
public class Clientes extends Incrementable4 {
	
	@Column(length = 6)
	@DefaultValueCalculator(CalculadorConsecutivoClientes.class) // A�o actual	//@ReadOnly // El usuario no puede modificar el valor
	@ReadOnly 	
	@SearchKey
	int numero;
	
	@Required
	String rif;

	String nit;
	
	@Required
	String razonSocialDelCliente;
	
	@Required
	String direccionDelCliente;
	
	@Telephone
	@Required
	String telefonoPrincipal;
	
	@Telephone
	String telefonoSecundario;

	@Email 
	String correoDelCliente;
		
}





