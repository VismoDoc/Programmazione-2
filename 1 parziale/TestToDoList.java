import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestToDoList {

// **********************************    Test su Task
	// Creazione
	@Test
	public void testTaskCreazione1() {
		Task task = new Task("Lavare auto", 20210430, 1);
		assertEquals(new String("Lavare auto"), task.getTitolo());
		assertEquals(20210430, task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	@Test
	public void testTaskCreazione2() {
		Task task = new Task(null, 20210430, 1);
		assertEquals(new String("Da specificare"), task.getTitolo());
		assertEquals(20210430, task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	@Test
	public void testTaskCreazione3() {
		Task task = new Task("Lavare auto", 20210401, 1);
		assertEquals(new String("Lavare auto"), task.getTitolo());
		assertEquals(DataUtil.getDataDiOggi(), task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	@Test
	public void testTaskCreazione4() {
		Task task = new Task("Lavare auto", 20210430, 0);
		assertEquals(new String("Lavare auto"), task.getTitolo());
		assertEquals(20210430, task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	@Test
	public void testTaskCreazione5() {
		Task task = new Task("Lavare auto", 20210430, 9);
		assertEquals(new String("Lavare auto"), task.getTitolo());
		assertEquals(20210430, task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	
	@Test
	public void testTaskCreazione6() {
		Task task = new Task("Lavare auto", 1);
		assertEquals(new String("Lavare auto"), task.getTitolo());
		assertEquals(DataUtil.getDataDiOggi(), task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	@Test
	public void testTaskCreazione7() {
		Task task = new Task(null, 1);
		assertEquals(new String("Da specificare"), task.getTitolo());
		assertEquals(DataUtil.getDataDiOggi(), task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	
	@Test
	public void testTaskCreazione8() {
		Task task = new Task("Lavare auto", 0);
		assertEquals(new String("Lavare auto"), task.getTitolo());
		assertEquals(DataUtil.getDataDiOggi(), task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	@Test
	public void testTaskCreazione9() {
		Task task = new Task("Lavare auto", 9);
		assertEquals(new String("Lavare auto"), task.getTitolo());
		assertEquals(DataUtil.getDataDiOggi(), task.getData());
		assertEquals(1, task.getDurata());
		assertFalse(task.isEseguito());
	}
	
	
	// eseguito
	@Test
	public void testTaskEseguito() {
		Task task = new Task("Lavare auto", 20210430, 2);		
		assertFalse(task.isEseguito());
		task.eseguito();
		assertTrue(task.isEseguito());
	}
	
	// equals
	@Test
	public void testTaskEquals1() {
		Task task1 = new Task("Lavare auto", 20210430, 1);
		Task task2 = new Task("Lavare auto", 20210430, 1);
		assertTrue(task1.equals(task2));
	}

	@Test
	public void testTaskEquals2() {
		Task task1 = new Task("Lavare auto", 20210430, 1);
		Task task2 = new Task("LAvare auto", 20210430, 1);
		assertTrue(task1.equals(task2));
	}

	@Test
	public void testTaskEquals3() {
		Task task1 = new Task("Lavare auto", 20210430, 1);
		Task task2 = new Task("LAvare auto", 20210430, 1);
		task1.eseguito();
		assertTrue(task1.equals(task2));
	}

	@Test
	public void testTaskEquals4() {
		Task task1 = new Task("Lavare auto", 20210430, 1);
		assertFalse(task1.equals(null));
	}
	
	@Test
	public void testTaskEquals5() {
		Task task1 = new Task("Lavare auto", 20210430, 1);
		Task task2 = new Task(new String("Lavare auto"), 20210430, 1);		
		assertTrue(task1.equals(task2));
	}

	
// **********************************    Test su ToDoList	
	// aggiungiTask con oggetto
	@Test
	public void testToDoListAggiungiTaskOggetto1() {
		ToDoList todo = new ToDoList(3);
		boolean esito = todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		assertTrue(esito);		
	}
	
	@Test
	public void testToDoListAggiungiTaskOggetto2() { //aggiungo null
		ToDoList todo = new ToDoList(3);
		boolean esito = todo.aggiungiTask(null);
		assertFalse(esito);		
	}
	
	@Test
	public void testToDoListAggiungiTaskOggetto3() { //Due task uguali
		ToDoList todo = new ToDoList(3);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		boolean esito = todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		assertFalse(esito);		
	}
	
	@Test
	public void testToDoListAggiungiTaskOggetto4() { //numero task superiori alla capienza
		ToDoList todo = new ToDoList(2);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		todo.aggiungiTask(new Task("Yoga", 20210430, 2));
		boolean esito = todo.aggiungiTask(new Task("Lezione", 20210430, 2));
		assertFalse(esito);		
	}
	
	@Test
	public void testToDoListAggiungiTaskOggetto5() { //task per un giorno con durata superiore a 8
		ToDoList todo = new ToDoList(3);
		todo.aggiungiTask(new Task("Spesa", 20210430, 2));
		todo.aggiungiTask(new Task("Lezione", 20210430, 6));
		boolean esito = todo.aggiungiTask(new Task("Yoga", 20210430, 1));
		assertFalse(esito);		
	}
	
	
	/// aggiungiTask senza oggetto 
		@Test
		public void testToDoListAggiungiTaskNoOggetto1() {
			ToDoList todo = new ToDoList(3);
			boolean esito = todo.aggiungiTask("Spesa", 1);
			assertTrue(esito);		
		}				
		
		@Test
		public void testToDoListAggiungiTaskNoOggetto2() { //Due task uguali
			ToDoList todo = new ToDoList(3);
			todo.aggiungiTask("Spesa", 1);
			boolean esito = todo.aggiungiTask("Spesa", 1);
			assertFalse(esito);		
		}
		
		@Test
		public void testToDoListAggiungiTaskNoOggetto3() { //numero task superiori alla capienza
			ToDoList todo = new ToDoList(2);
			todo.aggiungiTask("Spesa", 1);
			todo.aggiungiTask("Yoga", 2);
			boolean esito = todo.aggiungiTask("Lezione", 2);
			assertFalse(esito);		
		}
		
		@Test
		public void testToDoListAggiungiTaskNoOggetto4() { //task per un giorno con durata superiore a 8
			ToDoList todo = new ToDoList(3);
			todo.aggiungiTask("Spesa", 2);
			todo.aggiungiTask("Lezione", 6);
			boolean esito = todo.aggiungiTask("Yoga", 1);
			assertFalse(esito);		
		}
	
	
	// getDurataTaskGiorno
	@Test
	public void testToDoListDurataTaskGiorno1() { 
		ToDoList todo = new ToDoList(4);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		todo.aggiungiTask(new Task("Yoga", 20210430, 2));
		int durata = todo.getDurataTaskGiorno(20210430);
		assertEquals(3, durata);		
	}
	
	@Test
	public void testToDoListDurataTaskGiorno2() { 
		ToDoList todo = new ToDoList(4);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		todo.aggiungiTask(new Task("Yoga", 20210430, 2));
		int durata = todo.getDurataTaskGiorno(DataUtil.getDataDiOggi());
		assertEquals(0, durata);		
	}
	
	// getPosizioneTask(Task task)
	@Test
	public void testToDoListPosizioneTask1() { 
		ToDoList todo = new ToDoList(4);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		todo.aggiungiTask(new Task("Yoga", 20210430, 2));
		int posizone = todo.getPosizioneTask(new Task("Yoga", 20210430, 2));
		assertEquals(1, posizone);		
	}
	
	@Test
	public void testToDoListPosizioneTask2() { 
		ToDoList todo = new ToDoList(4);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		todo.aggiungiTask(new Task("Yoga", 20210430, 2));
		int posizone = todo.getPosizioneTask(new Task("Lezione", 20210430, 2));
		assertEquals(-1, posizone);		
	}
	
	
	//rimuovi task
	@Test
	public void testToDoListTimuoviTask1() { 
		ToDoList todo = new ToDoList(3);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		todo.aggiungiTask("Lezione", 6);
		boolean esito = todo.rimuoviTask(new Task("Spesa", 20210430, 1));
		assertTrue(esito);	
		assertEquals(0, todo.getDurataTaskGiorno(20210430));
	}
	
	@Test
	public void testToDoListTimuoviTask2() { 
		ToDoList todo = new ToDoList(3);
		todo.aggiungiTask(new Task("Spesa", 20210430, 1));
		todo.aggiungiTask("Lezione", 6);
		boolean esito = todo.rimuoviTask(new Task("Yoga", 20210430, 1));
		assertFalse(esito);	
		assertEquals(1, todo.getDurataTaskGiorno(20210430));
	}
}
