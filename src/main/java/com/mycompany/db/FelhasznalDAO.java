package com.mycompany.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class FelhasznalDAO {
    public static void felhasznaloHozzaad(String nev, String pont){
        
        Adatbazis felh=new Adatbazis(null,nev,pont);
        
        EntityManager em = EgysegesEntitasKezelo.getEntityManeger();
        em.getTransaction().begin();
        em.persist(felh);
        em.getTransaction().commit();
        
    }
    
    public static List<Adatbazis> lekerfelhasznalo(){
        
        EntityManager em = EgysegesEntitasKezelo.getEntityManeger();
        TypedQuery<Adatbazis> query=em.createQuery("SELECT f from Adatbazis f",Adatbazis.class);
        return query.getResultList();
        
    }
    
    
 public static void jegyzetHozzaad(String felhaszn,String cim, String jegyzet){
        
        Naplok napl=new Naplok(null,felhaszn,cim,jegyzet);
        
        EntityManager em = EgysegesEntitasKezelo.getEntityManeger();
        em.getTransaction().begin();
        em.persist(napl);
        em.getTransaction().commit();
        
    }
    
    public static List<Naplok> lekerjegyzet(){
        
        EntityManager em = EgysegesEntitasKezelo.getEntityManeger();
        TypedQuery<Naplok> query=em.createQuery("SELECT f from Naplok f",Naplok.class);
        return query.getResultList();
        
    }
    
    public static void mod(Naplok l){
    	EntityManager em = EgysegesEntitasKezelo.getEntityManeger();
    	em.merge(l);
    	em.getTransaction().commit();
    	em.close(); 
    	
    }
}


