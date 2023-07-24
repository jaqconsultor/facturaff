package com.embebidas;
 
import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
public class RedesSociales {
 
    @URL
	@Column(length = 255) // Los miembros se anotan igual que en las entidades
    String paginaWeb;

    @EmailList
    @Column(length = 150)
    String correoPrincipal;
    
    @URL
    @Column(length = 150)
    String canalDeYoutube;

    @URL
    @Column(length = 150)
    String instagram;
 
    @URL
    @Column(length = 150)
    String twitter;
 
    @Column(length = 150)
    String skype;

    @URL
    @Column(length = 150)
    String telegram;
    
    @Column(length = 150)
    String whatssapp;
    
}