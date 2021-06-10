import java.util.HashSet;
import java.util.Set;

public class RegolaDiAccessoAPagamento extends RegolaDiAccesso {
	private Set<String> RegistroTarghePaganti;

	public RegolaDiAccessoAPagamento(String descrizione) {
		super(descrizione);
		RegistroTarghePaganti = new HashSet<String>();
	}
	
	public void registraPagamento(String targa) throws  VeicoloException {
		if (targa != null || !targa.equals(""))
			RegistroTarghePaganti.add(targa);
		else if (RegistroTarghePaganti.contains(targa))
			throw new VeicoloException();
	}

	@Override
	public boolean multa(Veicolo veicolo) {
		return RegistroTarghePaganti.contains(veicolo.getTarga());
	}

}
