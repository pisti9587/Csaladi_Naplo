/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db;

import java.util.List;

/**
 *
 * @author Gégény István
 */
public class EddigiJegyzetek {
    
    public List<Naplok> eddigiJegyzetek() {
		NaploEntitasKezelo es = new NaploEntitasKezelo();
		return es.em.createNamedQuery("Naplok.findAll" , Naplok.class).getResultList();
	}
    
}
