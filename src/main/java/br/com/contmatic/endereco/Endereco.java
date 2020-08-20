package br.com.contmatic.endereco;

public class Endereco {

    private String rua;

    private String cep;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    public Endereco(String rua, String cep, String numero, String bairro, String cidade, String estado, String pais) {
        this.setRua(rua);
        this.setCep(cep);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setPais(pais);
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    private void ruaIsNull(String rua) {
        if (rua == null) {
            throw new NullPointerException("A rua não pode ficar nulo");
        }
    }

    private void ruaIsEmpty(String rua) {
        if (rua.isEmpty() || rua.trim().equals("")) {
            throw new IllegalArgumentException("A rua não pode ficar vazio");
        }
    }

    private void ruaSizeValidation(String rua) {
        if (rua.length() < 0 || rua.length() > 25) {
            throw new IllegalArgumentException("A rua está errado");
        } else {
            for(int i = 0 ; i < rua.length() ; i++) {
                if (Character.isLetter(rua.charAt(i))) {
                    this.rua = rua;
                }
            }
        }
    }

    private void cepIsNull(String cep) {
        if (cep == null) {
            throw new NullPointerException("O cep não pode ficar nulo");
        }
    }

    private void cepIsEmpty(String cep) {
        if (cep.isEmpty() || cep.trim().equals("")) {
            throw new IllegalArgumentException("O cep não pode ficar vazio");
        }
    }

    private void cepSizeValidation(String cep) {
        if (cep.length() < 0 || cep.length() > 25) {
            throw new IllegalArgumentException("O cep está errado");
        } else {
            for(int i = 0 ; i < cep.length() ; i++) {
                if (Character.isLetter(cep.charAt(i))) {
                    throw new IllegalArgumentException("Erro o cep pode conter apenas numeros");
                }
            }
        }
    }

    private void numeroIsNull(String numero) {
        if (numero == null) {
            throw new NullPointerException("O numero não pode ficar nulo");
        }
    }

    private void numeroIsEmpty(String numero) {
        if (numero.isEmpty() || numero.trim().equals("")) {
            throw new IllegalArgumentException("O numero não pode ficar vazio");
        }
    }

    private void numeroSizeValidation(String numero) {
        if (numero.length() < 0 || numero.length() > 25) {
            throw new IllegalArgumentException("O numero está errado");
        } else {
            for(int i = 0 ; i < numero.length() ; i++) {
                if (Character.isLetter(numero.charAt(i))) {
                    throw new IllegalArgumentException("Erro o numero da casa pode conter apenas numeros");
                }
            }
        }
    }

    private void bairroIsNull(String bairro) {
        if (bairro == null) {
            throw new NullPointerException("O bairro não pode ficar nulo");
        }
    }

    private void bairroIsEmpty(String bairro) {
        if (bairro.isEmpty() || bairro.trim().equals("")) {
            throw new IllegalArgumentException("O bairro não pode ficar vazio");
        }
    }

    private void bairroSizeValidation(String bairro) {
        if (bairro.length() < 0 || bairro.length() > 25) {
            throw new IllegalArgumentException("O bairro está errado");
        } else {
            for(int i = 0 ; i < bairro.length() ; i++) {
                if (Character.isLetter(bairro.charAt(i))) {
                    this.bairro = bairro;
                }
            }
        }
    }

    private void cidadeIsNull(String cidade) {
        if (cidade == null) {
            throw new NullPointerException("A cidade não pode ficar nulo");
        }
    }

    private void cidadeIsEmpty(String cidade) {
        if (cidade.isEmpty() || cidade.trim().equals("")) {
            throw new IllegalArgumentException("A cidade não pode ficar vazio");
        }
    }

    private void cidadeSizeValidation(String cidade) {
        if (cidade.length() < 0 || cidade.length() > 25) {
            throw new IllegalArgumentException("A cidade está errado");
        } else {
            for(int i = 0 ; i < cidade.length() ; i++) {
                if (Character.isLetter(cidade.charAt(i))) {
                    this.cidade = cidade;
                }
            }
        }
    }

    private void estadoIsNull(String estado) {
        if (estado == null) {
            throw new NullPointerException("O estado não pode ficar nulo");
        }
    }

    private void estadoIsEmpty(String estado) {
        if (estado.isEmpty() || estado.trim().equals("")) {
            throw new IllegalArgumentException("O estado não pode ficar vazio");
        }
    }

    private void estadoSizeValidation(String estado) {
        if (estado.length() < 0 || estado.length() > 25) {
            throw new IllegalArgumentException("O estado está errado");
        } else {
            for(int i = 0 ; i < estado.length() ; i++) {
                if (Character.isLetter(estado.charAt(i))) {
                    this.estado = estado;
                }
            }
        }
    }

    private void paisIsNull(String pais) {
        if (pais == null) {
            throw new NullPointerException("O pais não pode ficar nulo");
        }
    }

    private void paisIsEmpty(String pais) {
        if (pais.isEmpty() || pais.trim().equals("")) {
            throw new IllegalArgumentException("O pais não pode ficar vazio");
        }
    }

    private void paisSizeValidation(String pais) {
        if (pais.length() < 0 || pais.length() > 25) {
            throw new IllegalArgumentException("O pais está errado");
        } else {
            for(int i = 0 ; i < pais.length() ; i++) {
                if (Character.isLetter(pais.charAt(i))) {
                    this.pais = pais;
                }
            }
        }
    }

    public void setRua(String rua) {
        ruaIsNull(rua);
        ruaIsEmpty(rua);
        ruaSizeValidation(rua);
        this.rua = rua;
    }

    public void setCep(String cep) {
        cepIsNull(cep);
        cepIsEmpty(cep);
        cepSizeValidation(cep);
        this.cep = cep;
    }

    public void setNumero(String numero) {
        numeroIsNull(numero);
        numeroIsEmpty(numero);
        numeroSizeValidation(numero);
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        bairroIsNull(bairro);
        bairroIsEmpty(bairro);
        bairroSizeValidation(bairro);
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        cidadeIsNull(cidade);
        cidadeIsEmpty(cidade);
        cidadeSizeValidation(cidade);
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        estadoIsNull(estado);
        estadoIsEmpty(estado);
        estadoSizeValidation(estado);
        this.estado = estado;
    }

    public void setPais(String pais) {
        paisIsNull(pais);
        paisIsEmpty(pais);
        paisSizeValidation(pais);
        this.pais = pais;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
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
        if (!cep.equals(other.cep))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Endereco [rua=" + rua + ", cep=" + cep + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + "]";
    }

}
