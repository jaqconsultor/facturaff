package com.modelo.factura;
 
import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.calculadores.*;
import com.clientes.*;
import com.extensiones.*;

import lombok.*;
 
@Entity @Getter @Setter
/*@View( extendsView="super.DEFAULT", // La vista por defecto
members="pedidos { pedidos } "
)*/
/*
@View( name="SinClienteNiPedidos", // Una vista llamada SinClienteNiPedidos
members=                       // que no incluye cliente ni pedidos
    "anyo, fecha;" +   // Ideal para usarse desde Pedido
    "detalles;" +
    "observaciones"
)*/
/*@View(members= // Esta vista no tiene nombre, por tanto ser� la vista usada por defecto
"anyo, tipoDeDocumento, fecha;" + // Separados por coma significa en la misma l�nea
"cliente;" + // Punto y coma significa nueva l�nea
"detalles;" +
"observaciones"
)*/
//@Tab(baseCondition = "${eliminado} = false") // Tab sin nombre, es el de por defecto
//@Tab(name="Eliminado", baseCondition = "${eliminado} = true") // Tab con nombre

@View(members= // Esta vista no tiene nombre, por tanto ser� la vista usada por defecto
"numero, fechaDeEmision, fechaDeVencimiento; numeroControl, deContado;" + // Separados por coma significa en la misma l�nea
"cliente;" + // Punto y coma significa nueva l�nea
"detalles;" +
"porcentajeIVA, iva, importeTotal"
)
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="numero, fecha, numeroControl, iva, cliente.id, cliente.descripcion" // Muestra únicamente numero y nombre en la misma línea
)

public class Facturas extends Incrementable4 {
	
	@Column(length = 6)
	@DefaultValueCalculator(CalculadorConsecutivo.class) // A�o actual	//@ReadOnly // El usuario no puede modificar el valor
	@ReadOnly
	@SearchKey
	int numero;
	
	@ReadOnly
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fecha;

    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaDeEmision;

    LocalDate fechaDeVencimiento;

    Boolean deContado; 
    
	@Column(length = 20)
    String numeroControl;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    @ReferenceView("Simple") // La vista llamada 'Simple' se usar� para visualizar esta referencia
    Clientes cliente;
    
    @ElementCollection
    @ListProperties(
            "producto.numero, producto.descripcion, cantidad, precioPorUnidad, " +
            "importe+[" +
            	"facturas.porcentajeIVA," +
            	"facturas.iva," +
            	"facturas.importeTotal" +
            "]" 
        )	
    Collection<Detalle> detalles;

    @Digits(integer=2, fraction=0) // Para indicar su tama�o
    @DefaultValueCalculator(CalculadorPorcentajeIVA.class)
    BigDecimal porcentajeIVA;
    
    @ReadOnly
    @Calculation("sum(detalles.importe) * porcentajeIVA / 100")
    BigDecimal iva;
  
    @ReadOnly
    @Calculation("sum(detalles.importe) + iva")    
    BigDecimal importeTotal;


    public String toString() {
        return "/" + numero;
    }

	
}

	
	
