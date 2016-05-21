package com.mycompany.beadando.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.db.Adatbazis;
import com.mycompany.db.EgysegesEntitasKezelo;
import com.mycompany.db.EgysegesLekerdezes;

public class FelhasznaloTest {

	private static EgysegesEntitasKezelo es = new EgysegesEntitasKezelo();

	@Test
	public void beallitja() {
		Adatbazis a = new Adatbazis();
		a.setId(1);
		a.setFelhasznalonev("felhasznalonev");
		a.setJelszo("jelszo");
	}

	@Test
	public void visszaAdja() {
		Adatbazis a = new Adatbazis();
		a.setId(1);
		a.setFelhasznalonev("felhasznalonev");
		a.setJelszo("jelszo");

		assertEquals(1, a.getId().intValue());
		assertEquals("felhasznalonev", a.getFelhasznalonev());
		assertEquals("jelszo", a.getJelszo() );

	}

	@BeforeClass
	public static void sqlBeallitas() throws Exception {
		es.em = (EntityManager) Persistence.createEntityManagerFactory("egysegest").createEntityManager();
	}

	@Test
	public void adazbazisMuveletek() {

		Adatbazis b = new Adatbazis();
		b.setFelhasznalonev("Felhasznalo");
		b.setJelszo("jelszo");

		es.em.persist(b);
		es.em.clear();
		es.em.remove(b);
	}

	private List<Adatbazis> FelhasznaloLista = new ArrayList<>();
	private EgysegesLekerdezes felhasznalok = new EgysegesLekerdezes();

	@Test
	public void taroltFelhazsnalok() {

		Adatbazis b = new Adatbazis();
		b.setFelhasznalonev("Felhasznalo");
		b.setJelszo("jelszo");
		es.em.persist(b);

		FelhasznaloLista = felhasznalok.taroltFelhasznalok();
		for (Adatbazis l : FelhasznaloLista) {
			assertEquals("Felhasznalo", l.getFelhasznalonev());
			assertEquals("jelszo", l.getJelszo());
		}
		es.em.close();
	}

}
