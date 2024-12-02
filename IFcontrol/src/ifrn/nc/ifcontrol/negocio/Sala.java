package ifrn.nc.ifcontrol.negocio;

public class Sala {

	private String ip;
	private String nome;

	public Sala() {

		//teste

	}

	public Sala(String ip, String nome) {
		super();
		this.ip = ip;
		this.nome = nome;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
