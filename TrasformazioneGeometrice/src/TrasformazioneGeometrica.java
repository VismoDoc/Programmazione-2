import java.util.HashSet;
import java.util.Set;

public abstract class TrasformazioneGeometrica {
	
	protected abstract Punto trasforma(Punto originale);
	
	public Set<Punto> trasforma (Set<Punto> originali){
		Set<Punto> nuovi = new HashSet<>();
		for (Punto punto : originali) {
			nuovi.add(trasforma(punto));
		}
		return nuovi;
	}
}
