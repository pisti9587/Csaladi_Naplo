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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gégény István
 */


@Entity
@Table(name = "TestNaplok")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Naplok.findAll", query = "SELECT u FROM Naplok u"), })     
public class Naplok implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "felhasznalonev")
	private String felhasznalonev;
	@Column(name = "cim")
	private String cim;
	@Column(name = "jegyzet")
	private String jegyzet;

	public Naplok() {
		
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
