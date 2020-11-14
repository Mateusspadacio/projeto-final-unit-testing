package padrao;

public class CalcularMediaAluno {

	private double notaCorte = 7;
	
	public double calcularMedia(double nota1, double nota2) throws Exception {
		if (!isNotaValida(nota1)) {
			throw new Exception("Nota1 precisa esta entre 0 e 10");
		}
		
		if (!isNotaValida(nota2)) {
			throw new Exception("Nota2 precisa esta entre 0 e 10");
		}
		
		double total = (nota1 + nota2) / 2;
		
		return total;
	}
	
	public boolean alunoAprovado(double nota) throws Exception {
		if (!isNotaValida(nota)) {
			throw new Exception("Nota precisa esta entre 0 e 10");
		}
		
		if (!isNotaValida(getNotaCorte())) {
			throw new Exception("Nota de corte precisa esta entre 0 e 10");
		}
		
		return nota >= getNotaCorte();
	}

	private boolean isNotaValida(double nota) {
		return nota >= 0 && nota <= 10;
	}
	
	public double getNotaCorte() {
		return notaCorte;
	}

	public void setNotaCorte(double notaCorte) {
		this.notaCorte = notaCorte;
	}
	
}
