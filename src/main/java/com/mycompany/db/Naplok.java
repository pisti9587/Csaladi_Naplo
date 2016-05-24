/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gégény István
 */


@Entity
@Table(name = "TestNaplok2")
    
public class Naplok{
    
	@Id
	@Column(name = "id")
        @SequenceGenerator(name ="IDgenerator", sequenceName="felhasznalo_id_s2", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "IDgenerator")
	private Integer id;

	@Column(name = "felhasznalonev")
	private String felhasznalonev;
	@Column(name = "cim")
	private String cim;
	@Column(name = "jegyzet")
	private String jegyzet;

    public Naplok() {
    }

	public Naplok(Integer id, String felhasznalonev,String cim, String jegyzet) {
		this.id = id;
        this.felhasznalonev = felhasznalonev;
        this.jegyzet=jegyzet;
        this.cim=cim;
	}
	
	public void mod(String jegyzet){
		this.setJegyzet(jegyzet);
	}
	
    public Integer getId() {
        return id;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public String getCim() {
        return cim;
    }
    
    public String getJegyzet() {
        return jegyzet;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }
        
    public void setJegyzet(String jegyzet) {
        this.jegyzet = jegyzet;
    }    
    
}
