import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestEsame {

	
	@Test
	public void testVeicoloKO() {
		try {
			SolutionOf_Veicolo v = new SolutionOf_Veicolo(null,"diesel");
			fail();
		} catch (VeicoloException e) {}

		try {
			SolutionOf_Veicolo v = new SolutionOf_Veicolo("","diesel");
			fail();
		} catch (VeicoloException e) {}
		
		try {
			SolutionOf_Veicolo v = new SolutionOf_Veicolo("AA111BB",null);
			fail();
		} catch (VeicoloException e) {}

		try {
			SolutionOf_Veicolo v = new SolutionOf_Veicolo("AA111BB","benz");
			fail();
		} catch (VeicoloException e) {}

}

	
	@Test
	public void testVeicoloOK() throws VeicoloException {
		SolutionOf_Veicolo v1 = new SolutionOf_Veicolo("AA111B","diesel");
		assertTrue("AA111B".equals(v1.getTarga()));
		assertTrue("diesel".equals(v1.getCarburante()));
		
		SolutionOf_Veicolo v2 = new SolutionOf_Veicolo("AA111B","benzina");
		assertTrue(v1.equals(v2));
		assertTrue(v1.hashCode()==v2.hashCode());
		
		assertTrue(v1.compareTo(v2)==0);
		
		SolutionOf_Veicolo v3 = new SolutionOf_Veicolo("BA111B","benzina");
		SolutionOf_Veicolo v4 = new SolutionOf_Veicolo("AA111A","diesel");
		assertTrue(v1.compareTo(v3)<0);
		assertTrue(v1.compareTo(v4)>0);
		
	}
	
	@Test
	public void testRegolaDiesel() throws VeicoloException {
		SolutionOf_RegolaAccessoVietatoMotoriDiesel r = new SolutionOf_RegolaAccessoVietatoMotoriDiesel("Accesso vietato ai diesel");
		SolutionOf_Veicolo v1 = new SolutionOf_Veicolo("AA111B","diesel");
		SolutionOf_Veicolo v2 = new SolutionOf_Veicolo("BA111B","benzina");
		assertTrue(r.multa(v1));
		assertFalse(r.multa(v2));
	}
	
	@Test
	public void testRegolaPagamentiKO() throws VeicoloException {
		SolutionOf_RegolaAccessoAPagamento r = new SolutionOf_RegolaAccessoAPagamento("Accesso a pagamento");
			r.registraPagamento(null);
			r.registraPagamento("");
			r.registraPagamento("AA111AA");
			try{
				r.registraPagamento("AA111AA");
				fail();
			}catch(VeicoloException e) {}		
	}
	
	@Test
	public void testRegolaPagamentiOK() throws VeicoloException {
		SolutionOf_RegolaAccessoAPagamento r = new SolutionOf_RegolaAccessoAPagamento("Accesso a pagamento");
			r.registraPagamento("AA111AA");
			r.registraPagamento("AA111BB");
			SolutionOf_Veicolo v1 = new SolutionOf_Veicolo("AA111BB","diesel");
			SolutionOf_Veicolo v2 = new SolutionOf_Veicolo("AA111CC","benzina");
			assertFalse(r.multa(v1));
			assertTrue(r.multa(v2));
	}
	
	
	@Test
	public void testVarcoNoRegola() throws VeicoloException {
		SolutionOf_Varco v = new SolutionOf_Varco(null);
		SolutionOf_Veicolo v1 = new SolutionOf_Veicolo("AA111BB","diesel");
		SolutionOf_Veicolo v2 = new SolutionOf_Veicolo("AA111CC","benzina");
		v.convalidaEntrata(v1);
		v.convalidaEntrata(v2);
		assertTrue(v.getMultati().size()==0);
	}
	
	@Test
	public void testVarcoRegolaDiesel() throws VeicoloException {
		SolutionOf_Varco v = new SolutionOf_Varco(new SolutionOf_RegolaAccessoVietatoMotoriDiesel("no accesso diesel"));
		SolutionOf_Veicolo v1 = new SolutionOf_Veicolo("AA111BB","diesel");
		SolutionOf_Veicolo v2 = new SolutionOf_Veicolo("AA111CC","benzina");
		SolutionOf_Veicolo v3 = new SolutionOf_Veicolo("BB111BB","diesel");
		SolutionOf_Veicolo v4 = new SolutionOf_Veicolo("BB111CC","benzina");
		v.convalidaEntrata(v1);
		v.convalidaEntrata(v2);
		v.convalidaEntrata(v3);
		v.convalidaEntrata(v4);
		assertTrue(v.getMultati().size()==2);
		assertTrue(v.toString().contains("AA111BB"));
		assertTrue(v.toString().contains("BB111BB"));
	}
	
	@Test
	public void testVarcoRegolaPagamenti() throws VeicoloException {
		SolutionOf_RegolaAccessoAPagamento r = new SolutionOf_RegolaAccessoAPagamento("pagamento richiesto");
		SolutionOf_Varco v = new SolutionOf_Varco(r);
		SolutionOf_Veicolo v1 = new SolutionOf_Veicolo("AA111BB","diesel");
		SolutionOf_Veicolo v2 = new SolutionOf_Veicolo("AA111CC","benzina");
		SolutionOf_Veicolo v3 = new SolutionOf_Veicolo("BB111BB","diesel");
		SolutionOf_Veicolo v4 = new SolutionOf_Veicolo("BB111CC","benzina");
		r.registraPagamento("AA111CC");
		r.registraPagamento("BB111BB");
		v.convalidaEntrata(v1);
		v.convalidaEntrata(v2);
		v.convalidaEntrata(v3);
		v.convalidaEntrata(v4);
		assertTrue(v.getMultati().size()==2);
		assertTrue(v.toString().contains("AA111BB"));
		assertTrue(v.toString().contains("BB111CC"));
	}
}
