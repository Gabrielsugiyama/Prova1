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

    public void setRua(String rua) {
        if (rua == null || rua.trim().isEmpty() || rua.length() < 5 || rua.length() > 50) {
            throw new IllegalArgumentException("Rua invalido");
        } else {
            for(int i = 0 ; i < rua.length() ; i++) {
                if (Character.isDigit(rua.charAt(i))) {
                    throw new IllegalArgumentException("Erro a Rua pode conter apenas letras");
                } else {
                    this.rua = rua;
                }
            }
        }
    }

    public void setCep(String cep) {
        if (cep == null || cep.trim().isEmpty() || cep.length() < 8 || cep.length() > 8) {
            throw new IllegalArgumentException("Cep invalido");
        } else {
            for(int i = 0 ; i < cep.length() ; i++) {
                if (Character.isLetter(cep.charAt(i))) {
                    throw new IllegalArgumentException("Erro o CEP pode conter apenas numeros");
                } else {
                    this.cep = cep;
                }
            }
        }
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty() || numero.length() < 0) {
            throw new IllegalArgumentException("NumeroCasa invalido");
        } else {
            for(int i = 0 ; i < numero.length() ; i++) {
                if (Character.isLetter(numero.charAt(i))) {
                    throw new IllegalArgumentException("Erro o numero da casa pode conter apenas numeros");
                } else {
                    this.numero = numero;
                }
            }
        }
    }

    public void setBairro(String bairro) {
        if (bairro == null || bairro.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro o Bairro tem que ser preenchido");
        } else {
            for(int i = 0 ; i < bairro.length() ; i++) {
                if (Character.isDigit(bairro.charAt(i))) {
                    throw new IllegalArgumentException("Erro o Bairro pode conter apenas letras");
                } else {
                    this.bairro = bairro;
                }
            }
        }
    }

    public void setCidade(String cidade) {
        if (cidade == null || cidade.trim().isEmpty() || cidade.length() < 5 || cidade.length() > 50) {
            throw new IllegalArgumentException("Rua invalido");
        } else {
            for(int i = 0 ; i < cidade.length() ; i++) {
                if (Character.isDigit(cidade.charAt(i))) {
                    throw new IllegalArgumentException("Erro a Rua pode conter apenas letras");
                } else {
                    this.cidade = cidade;
                }
            }
        }
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty() || estado.length() < 2 || estado.length() > 2) {
            throw new IllegalArgumentException("Rua invalido");
        } else {
            for(int i = 0 ; i < estado.length() ; i++) {
                if (Character.isDigit(estado.charAt(i))) {
                    throw new IllegalArgumentException("Erro a Rua pode conter apenas letras");
                } else {
                    this.estado = estado;
                }
            }
        }
    }

    public void setPais(String pais) {
        if (pais == null || pais.trim().isEmpty() || pais.length() < 2 || pais.length() > 2) {
            throw new IllegalArgumentException("Rua invalido");
        } else {
            for(int i = 0 ; i < pais.length() ; i++) {
                if (Character.isDigit(pais.charAt(i))) {
                    throw new IllegalArgumentException("Erro a Rua pode conter apenas letras");
                } else {
                    this.pais = pais;
                }
            }
        }
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
