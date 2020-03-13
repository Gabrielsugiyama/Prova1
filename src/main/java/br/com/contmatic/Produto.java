package br.com.contmatic;

public class Produto {

	private String modelo;

	private double preco;

	private String marca;

	private String codigoProduto;

	public Produto(String modelo, double preco, String marca, String codigoProduto) {
		setModelo(modelo);
		setPreco(preco);
		setMarca(marca);
		setCodigoProduto(codigoProduto);
	}

	public String getModelo() {
		return modelo;
	}

	public double getPreco() {
		return preco;
	}

	public String getMarca() {
		return marca;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setModelo(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			this.modelo = nome;
		}
	}

	public void setPreco(double preco) {
		if (preco <= 0 || preco > 1000000000.00) {
			throw new IllegalArgumentException("Erro o preco está incorreto!");
		} else {
			this.preco = preco;
		}
	}

	public void setMarca(String marca) {
		if (marca == null || marca.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			for (int i = 0; i < marca.length(); i++) {
				if (Character.isLetter(marca.charAt(i))) {
					this.marca = marca;
				} else {
					throw new IllegalArgumentException("Erro o nome pode conter apenas letras");
				}
			}
		}
	}

	public void setCodigoProduto(String codigoProduto) {
		if (codigoProduto == null || codigoProduto.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro o nome tem que ser preenchido!!");
		} else {
			for (int i = 0; i < codigoProduto.length(); i++) {
				if (Character.isLetter(codigoProduto.charAt(i))) {
					throw new IllegalArgumentException("Erro o nome pode conter apenas letras");
				} else {
					this.codigoProduto = codigoProduto;
				}
			}
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProduto == null) ? 0 : codigoProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (!codigoProduto.equals(other.codigoProduto))
			return false;
		if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	public String toString() {
		return "Produto [modelo=" + modelo + ", preco=" + preco + ", marca=" + marca + "]";
	}

}
