package br.com.contmatic;

public class Fabricante {

	private String nome;

	private String cnpj;

	private Produto produto;

	private Endereco endereco;

	public Fabricante(String nome, String cnpj, Produto produto, Endereco endereco) {
		setNome(nome);
		setCnpj(cnpj);
		setProduto(produto);
		setEndereco(endereco);
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
		if (nome == null || nome.trim().isEmpty()) {
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
		if (cnpj == null || cnpj.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			for (int i = 0; i < cnpj.length(); i++) {
				if (Character.isDigit(cnpj.charAt(i))) {
					this.cnpj = cnpj;
				} else {
					throw new IllegalArgumentException("Erro o nome pode conter apenas letras");
				}
			}
		}
	}

	public void setProduto(Produto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			this.produto = produto;
		}
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null ) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			this.endereco = endereco;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fabricante [nome=" + nome + ", cnpj=" + cnpj + ", produto=" + produto + ", endereco=" + endereco + "]";
	}

}
