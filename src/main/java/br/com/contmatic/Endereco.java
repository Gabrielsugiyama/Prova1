package br.com.contmatic;

public class Endereco {

	private String rua;

	private String cep;

	private String numeroCasa;

	private String bairro;

	public Endereco(String rua, String cep, String numeroCasa, String bairro) {
		setRua(rua);
		setCep(cep);
		setNumeroCasa(numeroCasa);
		setBairro(bairro);
	}

	public String getRua() {
		return rua;
	}

	public String getCep() {
		return cep;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setRua(String rua) {
		if (rua == null || rua.trim().isEmpty() || 5 > rua.length() || 50 > rua.length() ) {
			throw new IllegalArgumentException("Rua invalido");
		} else {
			for (int i = 0; i < rua.length(); i++) {
				if (Character.isDigit(rua.charAt(i))) {
					throw new IllegalArgumentException("Erro a Rua pode conter apenas letras");
				} else {
					this.rua = rua;
				}
			}
		}
	}

	public void setCep(String cep) {
		if (cep == null || cep.trim().isEmpty() || 0 > cep.length() || 7 > cep.length()) {
			throw new IllegalArgumentException("Cep invalido");
		} else {
			for (int i = 0; i < cep.length(); i++) {
				if (Character.isDigit(cep.charAt(i))) {
					throw new IllegalArgumentException("Erro o CEP pode conter apenas numeros");
				} else {
					this.cep = cep;
				}
			}
		}
	}

	public void setNumeroCasa(String numeroCasa) {
		if (numeroCasa == null || numeroCasa.trim().isEmpty()) {
			throw new IllegalArgumentException("NumeroCasa invalido");
		} else {
			for (int i = 0; i < numeroCasa.length(); i++) {
				if (Character.isLetter(numeroCasa.charAt(i))) {
					throw new IllegalArgumentException("Erro o numero da casa pode conter apenas numeros");
				} else {
					this.numeroCasa = numeroCasa;
				}
			}
		}
	}

	public void setBairro(String bairro) {
		if (bairro == null || bairro.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro o Bairro tem que ser preenchido");
		} else {
			for (int i = 0; i < bairro.length(); i++) {
				if (Character.isDigit(bairro.charAt(i))) {
					throw new IllegalArgumentException("Erro o Bairro pode conter apenas letras");
				} else {
					this.bairro = bairro;
				}
			}
		}
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((numeroCasa == null) ? 0 : numeroCasa.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (numeroCasa == null) {
			if (other.numeroCasa != null)
				return false;
		} else if (!numeroCasa.equals(other.numeroCasa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [rua = " +  rua + ", cep = " + cep + ", numeroCasa = " + numeroCasa + ", bairro = " + bairro + "]";
	}
}