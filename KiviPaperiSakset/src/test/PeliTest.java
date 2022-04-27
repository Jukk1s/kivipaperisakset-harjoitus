package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Peli;

class PeliTest {
	
	Peli peli;
	Pelaaja pelaaja1;
	Pelaaja pelaaja2;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testTarkistaVoittaja() {
		pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
        peli = new Peli(pelaaja1, pelaaja2);
        
		String failText = "Voittaja väärin";
		
		pelaaja1.setValinta("KIVI");
		pelaaja2.setValinta("SAKSET");
		assertEquals(pelaaja1, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("SAKSET");
		pelaaja2.setValinta("PAPERI");
		assertEquals(pelaaja1, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("PAPERI");
		pelaaja2.setValinta("KIVI");
		assertEquals(pelaaja1, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("SAKSET");
		pelaaja2.setValinta("KIVI");
		assertEquals(pelaaja2, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("PAPERI");
		pelaaja2.setValinta("SAKSET");
		assertEquals(pelaaja2, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("KIVI");
		pelaaja2.setValinta("PAPERI");
		assertEquals(pelaaja2, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("KIVI");
		pelaaja2.setValinta("KIVI");
		assertEquals(null, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("PAPERI");
		pelaaja2.setValinta("PAPERI");
		assertEquals(null, peli.tarkistaVoittaja(), failText);
		
		pelaaja1.setValinta("SAKSET");
		pelaaja2.setValinta("SAKSET");
		assertEquals(null, peli.tarkistaVoittaja(), failText);
	}
	
	@Test
	public void testArvoPelaajienValinnat() {
		pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
        peli = new Peli(pelaaja1, pelaaja2);
        boolean virhe = false;
        
		String failText = "Metodi palauttaa virheellisen taulukon";
		
		String taulukko[] = peli.arvoPelaajienValinnat();
		
		if (!(taulukko[0].equals("KIVI") || taulukko[0].equals("PAPERI") || taulukko[0].equals("SAKSET")
				|| taulukko[1].equals("KIVI") || taulukko[1].equals("PAPERI") || taulukko[1].equals("SAKSET"))) {
			virhe = true;
		}
		assertEquals(false,virhe,failText);
		
	}

}
