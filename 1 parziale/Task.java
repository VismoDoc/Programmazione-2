
public class Task {
	private String titolo;
	private int data;
	private boolean eseguito;
	private int durata;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		if (titolo != null && titolo != " ")
			this.titolo = titolo;
		else
			this.titolo = "Da specificare";
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		if (data >= DataUtil.getDataDiOggi())
			this.data = data;
		else
			this.data = DataUtil.getDataDiOggi();
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		if (durata >= 1 && durata <= 8)
			this.durata = durata;
		else
			this.durata = 1;
	}

	public Task(String t, int dat, int dur) {
		setTitolo(t);
		setData(dat);
		setDurata(dur);
		this.eseguito = false;
	}

	public Task(String t, int dur) {
		this(t, DataUtil.getDataDiOggi(), dur);
	}

	public void eseguito() {
		this.eseguito = true;
	}

	public boolean isEseguito() {
		return eseguito;
	}

	@Override
	public String toString() {
		return "Task [titolo=" + titolo + ", data=" + data + ", eseguito=" + eseguito + ", durata=" + durata + "]";
	}

	public boolean equals(Task task) {
		if (task == null)
			return false;
		else if (this == task)
			return true;
		else if (getTitolo().equalsIgnoreCase(task.getTitolo()) && getData() == task.getData()
				&& getDurata() == task.getDurata())
			return true;
		return false;
	}

}
