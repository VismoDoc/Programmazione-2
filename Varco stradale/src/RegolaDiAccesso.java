
public abstract class RegolaDiAccesso {
	private String descrizione;

	public RegolaDiAccesso(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public abstract boolean multa(Veicolo veicolo);

}
