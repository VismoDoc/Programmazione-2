
public class Rettangolo implements Poligono {
	private double base, altezza;
	
	public Rettangolo(double base, double altezza) {
		super();
		this.base = base;
		this.altezza = altezza;
	}

	@Override
	public double calcolaArea() {
		return base * altezza;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == null || obj == null || !(obj instanceof Poligono))
			return false;
		else if (this.calcolaArea() == ((Rettangolo)obj).calcolaArea())
			return true;
		else if (((Rettangolo)obj).calcolaArea() - this.calcolaArea() < 0.001 &&
				((Rettangolo)obj).calcolaArea() - this.calcolaArea() > 0.000 || 
				this.calcolaArea() - ((Rettangolo)obj).calcolaArea() < 0.001 &&
				this.calcolaArea() - ((Rettangolo)obj).calcolaArea() > 0.000)
			return true;
		return false;
	}
	
}
