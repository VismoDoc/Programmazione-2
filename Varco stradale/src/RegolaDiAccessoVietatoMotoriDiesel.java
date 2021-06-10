
public class RegolaDiAccessoVietatoMotoriDiesel extends RegolaDiAccesso {

	
	public RegolaDiAccessoVietatoMotoriDiesel(String descrizione) {
		super(descrizione);
	}

	@Override
	public boolean multa(Veicolo veicolo) {
		return Carburante.carburanteValido(veicolo.getCarburante());
	}

}
