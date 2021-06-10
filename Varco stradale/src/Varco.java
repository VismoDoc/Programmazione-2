import java.util.Set;
import java.util.TreeSet;

public class Varco {
	
	public RegolaDiAccesso regolaAccesso;
	public Set<Veicolo> multati;
	
	public Varco(RegolaDiAccesso regolaAccesso) {
		super();
		multati = new TreeSet<Veicolo>();
		this.regolaAccesso = regolaAccesso;
	}
	
	
	public void convalidaEntrata(Veicolo veicolo) {
		if (regolaAccesso != null && regolaAccesso.multa(veicolo))
			multati.add(veicolo);
	}


	public Set<Veicolo> getMultati() {
		return multati;
	}


	@Override
	public String toString() {
		return "Varco [regolaAccesso=" + regolaAccesso + ", multati=" + multati + "]";
	}
	
}
