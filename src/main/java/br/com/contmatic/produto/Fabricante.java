package br.com.contmatic.produto;

import java.util.InputMismatchException;

import br.com.contmatic.endereco.Endereco;

public class Fabricante {

    private String nome;

    private String cnpj;

    private Produto produto;

    private Endereco endereco;

    public Fabricante(String nome, String cnpj, Produto produto, Endereco endereco) {
        this.setNome(nome);
        this.setCnpj(cnpj);
        this.setProduto(produto);
        this.setEndereco(endereco);
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

    private void nomeIsNull(String nome) {
        if (nome == null) {
            throw new NullPointerException("O nome não pode ficar nulo");
        }
    }

    private void nomeIsEmpty(String nome) {
        if (nome.isEmpty() || nome.trim().equals("")) {
            throw new IllegalArgumentException("O nome não pode ficar vazio");
        }
    }

    private void nomeSizeValidation(String nome) {
        if (nome.length() < 0 || nome.length() > 25) {
            throw new IllegalArgumentException("O nome está errado");
        } else {
            for(int i = 0 ; i < nome.length() ; i++) {
                if (Character.isLetter(nome.charAt(i))) {
                    this.nome = nome;
                }
            }
        }
    }

    private void cnpjIsNull(String cnpj) {
        if (cnpj == null) {
            throw new NullPointerException("O cnpj não pode ficar nulo");
        }
    }

    private void cnpjIsEmpty(String cnpj) {
        if (cnpj.isEmpty() || cnpj.trim().equals("")) {
            throw new IllegalArgumentException("O cnpj não pode ficar vazio");
        }
    }

    private void cnpjHasWord(String cnpj) {
        for(int i = 0 ; i < cnpj.length() ; i++) {
            if (Character.isLetter(cnpj.charAt(i))) {
                throw new IllegalArgumentException("Erro o CNPJ pode conter apenas numeros");
            } else {
                this.cnpj = cnpj;
            }
        }
    }

    private boolean cnpjSizeValidation(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") ||
            cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || (cnpj.length() != 14))
            return (false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for(i = 11 ; i >= 0 ; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else
                dig13 = (char) ((11 - r) + 48);

            sm = 0;
            peso = 2;
            for(i = 12 ; i >= 0 ; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else
                dig14 = (char) ((11 - r) + 48);

            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private void produtoIsNull(Produto produto) {
        if (produto == null) {
            throw new NullPointerException("O nome não pode ficar nulo");
        }
    }

    private void enderecoIsNull(Endereco endereco) {
        if (endereco == null) {
            throw new NullPointerException("O nome não pode ficar nulo");
        }
    }

    public void setNome(String nome) {
        nomeIsNull(nome);
        nomeIsEmpty(nome);
        nomeSizeValidation(nome);
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        cnpjIsNull(cnpj);
        cnpjIsEmpty(cnpj);
        cnpjHasWord(cnpj);
        cnpjSizeValidation(cnpj);
        this.cnpj = cnpj;
    }

    public void setProduto(Produto produto) {
        produtoIsNull(produto);
        this.produto = produto;
    }

    public void setEndereco(Endereco endereco) {
        enderecoIsNull(endereco);
        this.endereco = endereco;
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
