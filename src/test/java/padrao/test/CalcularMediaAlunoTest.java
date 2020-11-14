package padrao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

import padrao.CalcularMediaAluno;

@RunWith(MockitoJUnitRunner.class)
public class CalcularMediaAlunoTest {

	@Test
	public void calcularMediaAluno() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		double atual = 0;
		double esperado = 5;
		
		atual = calcularMediaAluno.calcularMedia(5, 5);
		
		assertEquals(esperado, atual, 0);
	}
	
	@Test
	public void calcularMediaAlunoComNota1MenorQue0() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		Exception atual = null;
		String esperado = "Nota1 precisa esta entre 0 e 10";
		
		atual = assertThrows(Exception.class, () -> calcularMediaAluno.calcularMedia(-1, 5));
		
		assertEquals(esperado, atual.getMessage());
	}
	
	@Test
	public void calcularMediaAlunoComNota1MaiorQue10() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		Exception atual = null;
		String esperado = "Nota1 precisa esta entre 0 e 10";
		
		atual = assertThrows(Exception.class, () -> calcularMediaAluno.calcularMedia(11, 5));
		
		assertEquals(esperado, atual.getMessage());
	}
	
	@Test
	public void calcularMediaAlunoComNota2MenorQue0() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		Exception atual = null;
		String esperado = "Nota2 precisa esta entre 0 e 10";
		
		atual = assertThrows(Exception.class, () -> calcularMediaAluno.calcularMedia(5, -1));
		
		assertEquals(esperado, atual.getMessage());
	}
	
	@Test
	public void calcularMediaAlunoComNota2MaiorQue10() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		Exception atual = null;
		String esperado = "Nota2 precisa esta entre 0 e 10";
		
		atual = assertThrows(Exception.class, () -> calcularMediaAluno.calcularMedia(5, 11));
		
		assertEquals(esperado, atual.getMessage());
	}
	
	@Test
	public void alunoAprovado() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		boolean atual = false;
		
		atual = calcularMediaAluno.alunoAprovado(8);
		
		assertTrue(atual);
	}
	
	@Test
	public void alunoReprovado() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		boolean atual = true;
		
		atual = calcularMediaAluno.alunoAprovado(6);
		
		assertFalse(atual);
	}
	
	@Test
	public void alunoReprovadoComNotaMenorQue0() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		Exception atual = null;
		String esperado = "Nota precisa esta entre 0 e 10";
		
		atual = assertThrows(Exception.class, () -> calcularMediaAluno.alunoAprovado(-1));
		
		assertEquals(esperado, atual.getMessage());
	}
	
	@Test
	public void alunoAprovadoComNotaMaiorQue10() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		Exception atual = null;
		String esperado = "Nota precisa esta entre 0 e 10";
		
		atual = assertThrows(Exception.class, () -> calcularMediaAluno.alunoAprovado(11));
		
		assertEquals(esperado, atual.getMessage());
	}
	
	@Test
	public void alunoAprovadoComNotaDeCorteMaiorQue8() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		calcularMediaAluno.setNotaCorte(8);
		boolean atual = false;
		
		atual = calcularMediaAluno.alunoAprovado(9);
		
		assertTrue(atual);
	}
	
	@Test
	public void reprovarAlunoComNotaDeCorteIgualA6() throws Exception {
		CalcularMediaAluno calcularMediaAluno = new CalcularMediaAluno();
		boolean atual = true;
		final String METHOD = "getNotaCorte";

		CalcularMediaAluno spy = PowerMockito.spy(calcularMediaAluno);
		PowerMockito.when(spy, METHOD).thenReturn(6d);

		atual = spy.alunoAprovado(5);

		assertFalse(atual);

		PowerMockito.verifyPrivate(spy, Mockito.times(2)).invoke(METHOD);
	}
	
}
