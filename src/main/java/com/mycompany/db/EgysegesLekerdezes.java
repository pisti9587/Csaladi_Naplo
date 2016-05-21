/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gégény István
 */
public class EgysegesLekerdezes {
    
    public List<Adatbazis> taroltFelhasznalok() {
    	EgysegesEntitasKezelo es = new EgysegesEntitasKezelo();
    	
    	List<Adatbazis> felhaszn = new ArrayList<>();
		felhaszn=es.em.createNamedQuery("Adatbazis.findAll" , Adatbazis.class).getResultList();
		es.em.close();
		
		return felhaszn; 
    	
	
	}
    
    public List<Naplok> eddigiJegyzetek() {
		EgysegesEntitasKezelo es = new EgysegesEntitasKezelo();
		
		List<Naplok> naplo = new ArrayList<>();
		naplo=es.em.createNamedQuery("Naplok.findAll" , Naplok.class).getResultList();
		es.em.close();
		
		return naplo; 
	} 
}
