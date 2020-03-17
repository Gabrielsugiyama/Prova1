package br.com.contmatic;

public class Cliente {

	private String nome;

	private String cpf;

	private String telefone;

	private Endereco endereco;

	public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEndereco(endereco);
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro o telefone tem que ser preenchido!!");
		} else {
			for (int i = 0; i < telefone.length(); i++) {
				if (Character.isDigit(telefone.charAt(i))) {
					this.telefone = telefone;
				} else {
					throw new IllegalArgumentException("Erro o telefone pode conter apenas numeros");
				}
			}
		}
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

	public void setCpf(String cpf) {
		if (cpf == null || cpf.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro o CPF tem que ser preenchido!!");
		} else {
			for (int i = 0; i < cpf.length(); i++) {
				if (Character.isLetter(cpf.charAt(i))) {
					throw new IllegalArgumentException("Erro o CPF pode conter apenas numeros");
				} else {
					this.cpf = cpf;
				}
			}
		}
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			this.endereco = endereco;
		}
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (!nome.equals(other.nome))
			return false;
		if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone" + telefone + "]";
	}

}
