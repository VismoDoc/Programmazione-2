
public class ToDoList {
	public Task toDo[];

	public ToDoList(int n) {
		if (n <= 0)
			toDo = new Task[5];
		else
			toDo = new Task[n];
	}

	public int getDurataTaskGiorno(int data) {
		int tot = 0;
		for (int i = 0; i < toDo.length; i++) {
			if (toDo[i] != null && toDo[i].getData() == data)
				tot += toDo[i].getDurata();
		}
		return tot;
	}

	public int getPosizioneTask(Task task) {
		for (int i = 0; i < toDo.length; i++) {
			if (toDo[i] != null && toDo[i].equals(task))
				return i;
		}
		return -1;
	}

	public boolean aggiungiTask(Task task) {
		if (task == null)
			return false;
		else if (getDurataTaskGiorno(task.getData()) >= 8)
			return false;
		else if (getPosizioneTask(task) != -1)
			return false;
		else {
			for (int i = 0; i < toDo.length; i++) {
				if (toDo[i] == null) {
					toDo[i] = task;
					return true;
				}
			}
			return false;
		}
	}

	public boolean aggiungiTask(String titolo, int durata) {
		Task tmp = new Task(titolo, DataUtil.getDataDiOggi(), durata);
		return this.aggiungiTask(tmp);
	}

	public boolean rimuoviTask(Task task) {
		for (int i = 0; i < toDo.length; i++) {
			if (toDo[i] != null && toDo[i].equals(task)) {
				toDo[i] = null;
				return true;
			}
		}
		return false;
	}
}
