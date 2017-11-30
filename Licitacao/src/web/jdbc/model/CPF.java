package web.jdbc.model;

public class CPF {
	private String cpf;
	
	public CPF(String cpf) {
		setCpf(cpf);
	}
	public CPF() {
		
	}
	
	//metodo getter setter
	public String getCpf() { return cpf; }
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
