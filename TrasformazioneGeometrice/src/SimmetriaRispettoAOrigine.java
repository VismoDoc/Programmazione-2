
public class SimmetriaRispettoAOrigine extends TrasformazioneGeometrica {

	@Override
	protected Punto trasforma(Punto originale) {
		Punto nuovo = new Punto(originale.getEtichetta(), originale.getX() * (-1), originale.getY() * (-1));
		return nuovo;
	}

}
