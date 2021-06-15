
public class Traslazione extends TrasformazioneGeometrica {
	private int deltaX, deltaY;

	public Traslazione(int deltaX, int deltaY) {
		super();
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	@Override
	protected Punto trasforma(Punto originale) {
		return new Punto(originale.getEtichetta(), originale.getX() + deltaX, originale.getY() + deltaY);
	}

	

}
