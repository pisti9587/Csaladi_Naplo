package com.mycompany.beadando.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.db.Adatbazis;
import com.mycompany.db.EgysegesEntitasKezelo;
import com.mycompany.db.FelhasznalDAO;

public class FelhasznaloTest {

    @Test
    public void hozzaad() {
        Adatbazis a = new Adatbazis(null, "felhasznalonev", "jelszo");

    }

    @Test
    public void lekerdez() {
        Adatbazis a = new Adatbazis(null, "felhasznalonev", "jelszo");

        assertEquals("felhasznalonev", a.getFelhasznalonev());
        assertEquals("jelszo", a.getJelszo());

    }

    @BeforeClass
    public static void sqlBeallitas() throws Exception {
        EgysegesEntitasKezelo.em = (EntityManager) Persistence.createEntityManagerFactory("egysegest").createEntityManager();
    }

    @Test
    public void torles() {

        Adatbazis a = new Adatbazis(null, "felhasznalonev", "jelszo");

        EgysegesEntitasKezelo.em.remove(a);
    }

}
