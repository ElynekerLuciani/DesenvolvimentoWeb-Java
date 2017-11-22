package web.jdbc.model;

public class Licitacao {
	private int idLicitacao;
	private Empresa empLicitacao = new Empresa();
	private String descricao;
	private Categoria catLicitacao = new Categoria();
	private String dataInicio;
	private String dataTermino;
	private float precoMedio;

}
