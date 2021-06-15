import java.util.HashSet;
import java.util.Set;

public class Grafico {
	private Set<Punto> punti;

	public Grafico(Punto primoPunto) {
		punti = new HashSet<Punto>();
		if (primoPunto != null)
			punti.add(primoPunto);
	}
	
	public void aggiungiPunto(Punto punto) throws GraficoException {
		if (punto == null)
			return;
		if (punti.contains(punto))
			throw new GraficoException();
		punti.add(punto);
	}
	
	public void visualizza() {
		System.out.println(punti);
	}
	
	public void trasforma (TrasformazioneGeometrica trasformazione) {
		if (trasformazione == null)
			return;
		
		punti = trasformazione.trasforma(punti);
	}
	
	public int getNumeroPunti() {
		return punti.size();
	}
}
