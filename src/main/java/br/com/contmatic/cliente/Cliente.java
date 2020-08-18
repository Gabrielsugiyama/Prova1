package br.com.contmatic.cliente;

import br.com.contmatic.endereco.Endereco;

public class Cliente {

    private String nome;

    private String cpf;

    private String telefone;

    private Endereco endereco;

    public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
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

    private void telefoneIsNull(String telefone) {
        if (telefone == null) {
            throw new NullPointerException("O telefone não pode ficar nulo");
        }
    }

    private void telefoneIsEmpty(String telefone) {
        if (telefone.isEmpty() || telefone.trim().equals("")) {
            throw new IllegalArgumentException("O Telefone não pode ficar vazio");
        }
    }

    private void telefoneSizeValidation(String telefone) {
        if (telefone.length() < 0 || telefone.length() > 25) {
            throw new IllegalArgumentException("O telefone está errado");
        } else {
            for(int i = 0 ; i < telefone.length() ; i++) {
                if (Character.isDigit(telefone.charAt(i))) {
                    this.telefone = telefone;
                }
            }
        }
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

    private void cpfIsNull(String cpf) {
        if (cpf == null) {
            throw new NullPointerException("O cpf não pode ficar nulo");
        }
    }

    private void cpfIsEmpty(String cpf) {
        if (cpf.isEmpty() || cpf.trim().equals("")) {
            throw new IllegalArgumentException("O cpf não pode ficar vazio");
        }
    }

    private void cpfSizeValidation(String cpf) {
        if (cpf.length() < 0 || cpf.length() > 25) {
            throw new IllegalArgumentException("O cpf está errado");
        } else {
            for(int i = 0 ; i < cpf.length() ; i++) {
                if (Character.isLetter(cpf.charAt(i))) {
                    throw new IllegalArgumentException("Erro o CPF pode conter apenas numeros");
                } else {
                    this.cpf = cpf;
                }
            }
        }
    }

    private void enderecoIsNull(Endereco endereco) {
        if (endereco == null) {
            throw new NullPointerException("O endereco não pode ficar nulo");
        }
    }

    public void setTelefone(String telefone) {
        telefoneIsNull(telefone);
        telefoneIsEmpty(telefone);
        telefoneSizeValidation(telefone);
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        nomeIsNull(nome);
        nomeIsEmpty(nome);
        nomeSizeValidation(nome);
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        cpfIsNull(cpf);
        cpfIsEmpty(cpf);
        cpfSizeValidation(cpf);
        this.cpf = cpf;
    }

    public void setEndereco(Endereco endereco) {
        enderecoIsNull(endereco);
        this.endereco = endereco;
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
