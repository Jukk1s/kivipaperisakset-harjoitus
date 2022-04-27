
package kivipaperisakset;

/**
 * Tämä luokka edustaa pelin pelaajaa.
 *
 * @author Jukka Hallikainen
 */
public class Pelaaja {
    int voitot;
    String valinta;
    
    public Pelaaja() {
    	this.voitot = 0;
    }

    public void setValinta(String valinta) {
    	if (valinta.equals("KIVI") || valinta.equals("PAPERI") || valinta.equals("SAKSET")) {
    		this.valinta = valinta;
    	}
    }
    
    public String getValinta() {
    	return valinta;
    }

    public void lisaaVoitto() {
        voitot++;
    }

    public int getVoitot() {
        return voitot;
    }
}
