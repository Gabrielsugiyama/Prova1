package br.com.contmatic.empresa;

import java.util.InputMismatchException;
import java.util.List;

import br.com.contmatic.cliente.Cliente;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.funcionario.Funcionario;
import br.com.contmatic.produto.Produto;

public class Empresa {

    private String razaoSocial;

    private String nomeFantasia;

    private String email;

    private String cnpj;

    private List<Endereco> enderecos;

    private List<Produto> produtos;

    private List<Funcionario> funcionarios;

    private List<Cliente> clientes;

    public Empresa(String razaoSocial, String nomeFantasia, String email, String cnpj, List<Endereco> enderecos) {
        this.setRazaoSocial(razaoSocial);
        this.setNomeFantasia(nomeFantasia);
        this.setEmail(email);
        this.setCnpj(cnpj);
        this.setEnderecos(enderecos);
    }

    public List<Endereco> getEndereco() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        cnpjIsNull(cnpj);
        cnpjIsEmpty(cnpj);
        cnpjHasWord(cnpj);
        cnpjSizeValidation(cnpj);
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        razaoSocialIsNull(razaoSocial);
        razaoSocialIsEmpty(razaoSocial);
        razaoSocialHasWord(razaoSocial);
        razaoSocialSizeValidation(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    public void setNomeFantasia(String nomeFantasia) {
        nomeFantasiaIsNull(nomeFantasia);
        nomeFantasiaIsEmpty(nomeFantasia);
        nomeFantasiaHasWord(nomeFantasia);
        nomeFantasiaSizeValidation(nomeFantasia);
        this.nomeFantasia = nomeFantasia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        emailIsNull(email);
        emailIsEmpty(email);
        emailSizeValidation(email);
        this.email = email;
    }

    public void setProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProduto() {
        return produtos;
    }

    public void setFuncionario(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getFuncionario() {
        return funcionarios;
    }

    public void setCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getCliente() {
        return clientes;
    }

    private void emailIsNull(String email) {
        if (email == null) {
            throw new NullPointerException("A razaoSocial não pode ficar nulo");
        }
    }

    private void emailIsEmpty(String email) {
        if (email.isEmpty() || email.trim().equals("")) {
            throw new IllegalArgumentException("O cnpj não pode ficar vazio");
        }
    }

    private void emailSizeValidation(String email) {
        if (email.length() < 0 || email.length() > 25) {
            throw new IllegalArgumentException("A razaoSocial está errada");
        }
    }

    private void nomeFantasiaIsNull(String nomeFantasia) {
        if (nomeFantasia == null) {
            throw new NullPointerException("A razaoSocial não pode ficar nulo");
        }
    }

    private void nomeFantasiaIsEmpty(String nomeFantasia) {
        if (nomeFantasia.isEmpty() || nomeFantasia.trim().equals("")) {
            throw new IllegalArgumentException("O cnpj não pode ficar vazio");
        }
    }

    private void nomeFantasiaHasWord(String nomeFantasia) {
        for(int i = 0 ; i < nomeFantasia.length() ; i++) {
            if (Character.isDigit(nomeFantasia.charAt(i))) {
                throw new IllegalArgumentException("Erro a razaoSocial pode conter apenas letras");
            } else {
                this.nomeFantasia = nomeFantasia;
            }
        }
    }

    private void nomeFantasiaSizeValidation(String nomeFantasia) {
        if (nomeFantasia.length() < 0 || nomeFantasia.length() > 25) {
            throw new IllegalArgumentException("A razaoSocial está errada");
        }
    }

    private void razaoSocialIsNull(String razaoSocial) {
        if (razaoSocial == null) {
            throw new NullPointerException("A razaoSocial não pode ficar nulo");
        }
    }

    private void razaoSocialIsEmpty(String razaoSocial) {
        if (razaoSocial.isEmpty() || razaoSocial.trim().equals("")) {
            throw new IllegalArgumentException("O cnpj não pode ficar vazio");
        }
    }

    private void razaoSocialHasWord(String razaoSocial) {
        for(int i = 0 ; i < razaoSocial.length() ; i++) {
            if (Character.isDigit(razaoSocial.charAt(i))) {
                throw new IllegalArgumentException("Erro a razaoSocial pode conter apenas letras");
            } else {
                this.razaoSocial = razaoSocial;
            }
        }
    }

    private void razaoSocialSizeValidation(String razaoSocial) {
        if (razaoSocial.length() < 0 || razaoSocial.length() > 25) {
            throw new IllegalArgumentException("A razaoSocial está errada");
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
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || 
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") || 
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || 
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || 
           (cnpj.length() != 14))
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
        Empresa other = (Empresa) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa [razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", email=" + email + ", cnpj=" + cnpj + ", enderecos=" + enderecos + ", produtos=" + produtos +
            ", funcionarios=" + funcionarios + ", clientes=" + clientes + "]";
    }

}
