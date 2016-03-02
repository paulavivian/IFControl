package ifrn.nc.ifcontrol.negocio;

public class Usuario {

	private String matricula;
	private String nome;
	private String senha;

	public Usuario() {

	}

	public Usuario(String matricula, String nome, String senha) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

}
