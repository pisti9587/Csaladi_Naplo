package com.mycompany.beadando.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;


import com.mycompany.db.EgysegesEntitasKezelo;
import com.mycompany.db.FelhasznalDAO;
import com.mycompany.db.Naplok;

public class NaploTest {

    @Test
    public void hozzaad() {
        Naplok a = new Naplok(null, "felhasznalonev", "cim", "szöveg");

    }

    @Test
    public void lekerdez() {
        Naplok a = new Naplok(null, "felhasznalonev", "cim", "szoveg");

        assertEquals("felhasznalonev", a.getFelhasznalonev());
        assertEquals("cim", a.getCim());
        assertEquals("szoveg",a.getJegyzet());

    }

   

}
