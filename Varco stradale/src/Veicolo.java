
public class Veicolo implements Comparable<Veicolo>{
	private String targa, carburante;

	public String getTarga() {
		return targa;
	}

	public String getCarburante() {
		return carburante;
	}

	public Veicolo(String targa, String carburante) throws VeicoloException {
		super();
		if (targa == null || targa.equals(""))
			throw new VeicoloException();
		this.targa = targa;
		this.carburante = carburante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((targa == null) ? 0 : targa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veicolo other = (Veicolo) obj;
		if (targa == null) {
			if (other.targa != null)
				return false;
		} else if (!targa.equals(other.targa))
			return false;
		return true;
	}

	@Override
	public int compareTo(Veicolo v) {
		return targa.compareTo(v.getTarga());
	}
	
	

}
