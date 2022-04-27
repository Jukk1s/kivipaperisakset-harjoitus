package kivipaperisakset;

/**
 * Tämä luokka pyörittää kivi-paperi-sakset -"peliä".
 * Peli kestää niin kauan, että jompikumpi pelaajista voittaa kolmesti.
 *
 * @author Jukka Hallikainen
 */
public class Peli {
	private Pelaaja pelaaja1;
	private Pelaaja pelaaja2;
    static final String[] vaihtoehdot = {"KIVI", "PAPERI", "SAKSET"};
    static final int KIVI = 0;
	static final int PAPERI = 1;
	static final int SAKSET = 2;
	int tasapelit = 0;
	int eraNro = 0;
	boolean peliLoppui = false;
	
	public Peli(Pelaaja p1, Pelaaja p2) {
		this.pelaaja1 = p1;
		this.pelaaja2 = p2;
	}
	
	/**
	 * Pitää peliä käynnissä ja kutsuu apumetodeja,
	 * kunnes lopetusehto täyttyy.
	 */
    public void aloitaPeli() {
        
        do {    	
        	eraNro++;  
        	
        	System.out.println("========= Erä: " + eraNro + " ==========\n");
        	
        	String valitut[] = arvoPelaajienValinnat();
        	
            pelaaja1.setValinta(valitut[0]);
            System.out.println("- Pelaaja 1 : " + pelaaja1.getValinta() + " -\n");
        
            pelaaja2.setValinta(valitut[1]);
            System.out.println("- Pelaaja 2 : " + pelaaja2.getValinta() + " -\n");	
        	
        	if (tarkistaVoittaja() != null) {
        		tarkistaVoittaja().lisaaVoitto();
        	} else {
        		tasapelit++;
        	}
            
            System.out.println("Tasapelit: " + tasapelit);
            System.out.println("Pelaaja 1:n voitot: " + pelaaja1.getVoitot());
            System.out.println("Pelaaja 2:n voitot: " + pelaaja2.getVoitot() + "\n");
            
            if ((pelaaja1.getVoitot() >= 3) || (pelaaja2.getVoitot() >= 3)) {
                peliLoppui = true;
            }      
            
        } while (!peliLoppui);
        
        System.out.println("\n~~~ KOLME VOITTOA - PELI PÄÄTTYI ~~~");
    }
    
    /**
     * Arpoo pelaajille valinnat satunnaislukugeneraattorilla.
     * 
     * @return Kaksialkioinen String-taulukko, esim. ["PAPERI", "SAKSET"]
     */
	public String[] arvoPelaajienValinnat() {   
		String valinnat[] = new String[2];
		int random = (int) (Math.random() * 3);
		int random2 = (int) (Math.random() * 3);
		
		valinnat[0] = vaihtoehdot[random];
		valinnat[1] = vaihtoehdot[random2];
        
        return valinnat;
	}
	
	/**
	 * Tarkistaa löytyykö voittajaa, kun vertaillaan kummankin pelaajan valintaa.
	 * 
	 * @return Voittanut Pelaaja-objekti
	 */
	public Pelaaja tarkistaVoittaja() {
		
		if (pelaaja1.getValinta() == vaihtoehdot[KIVI]) {
    		if (pelaaja2.getValinta() == vaihtoehdot[SAKSET]) {
    			return pelaaja1;
    		} else if (pelaaja2.getValinta() == vaihtoehdot[PAPERI]) {
    			return pelaaja2;
    		}
    		
    	} else if (pelaaja1.getValinta() == vaihtoehdot[PAPERI]) {
    		if (pelaaja2.getValinta() == vaihtoehdot[KIVI]) {
    			return pelaaja1;
    		} else if (pelaaja2.getValinta() == vaihtoehdot[SAKSET]) {
    			return pelaaja2;
    		}
    			    		
    	} else if (pelaaja1.getValinta() == vaihtoehdot[SAKSET]) {
    		if (pelaaja2.getValinta() == vaihtoehdot[PAPERI]) {
    			return pelaaja1;
    		} else if (pelaaja2.getValinta() == vaihtoehdot[KIVI]) {
    			return pelaaja2;
    		}    			 		
    	}
		return null;
	}
}