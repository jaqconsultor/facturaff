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
public class CargaDeMovimientosPaypal extends Incrementable4 {

    LocalDate fecha;

    String hora;

    String nombre;
    
    String tipo;
    
    Double bruto;
    
    Double comision;
	
    Double neto;
    
    String cantidad;
    
    String correoElectronicoDelRemitente;
    
    String correoElectronicoDelDestinatario;
    
    String iddetransacci�n;
    
    String poblacionociudad;
    
    String pais;
    
    String numerodetelefonodecontacto;
    
    String codigopostal;
    
    String codigodepais;
    
    String asunto;
    
    String nota;

    String repercusionesenelsaldo;
    
    String direccion;

    String saldo;
 
    String direcciondeenvio;

    String estado;
 
    String divisa;

    String zonahoraria;

    
}





