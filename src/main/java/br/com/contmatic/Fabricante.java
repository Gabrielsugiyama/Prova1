package br.com.contmatic;

public class Fabricante {

	private String nome;

	private String cnpj;

	private int id;

	private Produto produto;

	private Endereco endereco;

	public int getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			for (int i = 0; i < nome.length(); i++) {
				if (Character.isLetter(nome.charAt(i))) {
					this.nome = nome;
				} else {
					throw new IllegalArgumentException("Erro o nome pode conter apenas letras");
				}
			}
		}
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "Fabricante [id=" + id + ", produto=" + produto + "]";
	}

}
