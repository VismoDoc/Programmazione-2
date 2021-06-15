import java.util.ArrayList;

public class DisegnoGeometrico {
	public ArrayList<Poligono> poligoni;

	public DisegnoGeometrico() {
		poligoni = new ArrayList<Poligono>();
	}

	public void aggiungiPoligono(Poligono poligono) {
		poligoni.add(poligono);
	}
	
	public double calcolaAreaTotale() throws NoPoligoniExpcetion {
		if (poligoni.size() == 0)
			throw new NoPoligoniExpcetion();
		
		double areaTotale = 0;
		
		for (Poligono tmp : poligoni)
			areaTotale += tmp.calcolaArea();
		return areaTotale;
	}
}
