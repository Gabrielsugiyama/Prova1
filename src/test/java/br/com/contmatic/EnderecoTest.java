package br.com.contmatic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.endereco.Endereco;

public class EnderecoTest {
    private Endereco endereco;
    private Endereco endereco2;

    @BeforeClass
    public static void Inicio_testes() {
        System.out.println("Aqui se inicia os Testes");
    } 

    @Before
    public void setUp() {
        endereco = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
    }

    @Test
    public void nao_deve_aceitar_rua_nulo() {
        assertNotNull(endereco.getRua());
    }

    @Test
    public void nao_deve_aceitar_cep_nulo() {
        assertNotNull(endereco.getCep());
    }

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        assertNotNull(endereco.getNumero());
    }

    @Test
    public void nao_deve_aceitar_bairro_nulo() {
        assertNotNull(endereco.getBairro());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_numero_em_rua() {
        endereco.setRua("fdsafdas123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_rua_for_nulo() {
        endereco.setRua(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_rua_estiver_em_branco() {
        endereco.setRua("   		  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_os_digitos_do_cep_for_maior_que_8() {
        endereco.setCep("12345678910");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_letra_em_cep() {
        endereco.setCep("abc13358");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_cep_estiver_em_branco() {
        endereco.setCep("  		 ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_letra_em_numerocasa() {
        endereco.setNumero("sfdsafdsadasa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_numerocasa_estiver_em_branco() {
        endereco.setNumero("  		  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_numero_em_bairro() {
        endereco.setBairro("12345678fdsafdsa9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_bairro_estiver_em_branco() {
        endereco.setBairro("   		  ");
    }

    @Test
    public void deve_retornar_true_se_cep_for_diferente_do_cep2() {
        endereco2 = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
        assertThat(endereco.getCep(), is(not(endereco2.getCep())));
    }

    @Test
    public void deve_retornar_true_se_numerocasa_for_igual_a_ela_mesma() {
        assertTrue(endereco.getNumero().equals(endereco.getNumero()));
    }

    @Test
    public void deve_retornar_true_se_endereco2_for_diferente_de_nulo() {
        assertFalse(endereco.equals(null));
    }

    @Test
    public void deve_retornar_true_se_endereco_for_igual_a_ele_mesmo() {
        assertTrue(endereco.equals(endereco));
    }

    @Test
    public void deve_retornar_false_se_endereco_for_diferente_de_outro_objeto_qulquer() {
        assertFalse(endereco.equals(new Object()));
    }

    @Test
    public void deve_retornar_true_se_endereco_for_igual_a_endereco2() {
        endereco2 = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_retornar_true_se_numerocasa_for_diferente_ao_numerocasa2() {
        endereco2 = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
        assertFalse(endereco.equals((endereco2)));
    }

    @Test
    public void deve_retornar_false_se_o_equals_do_cep_for_diferente_do_cep2() {
        endereco2 = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
        assertFalse(endereco.equals((endereco2)));
    }

    @Test
    public void deve_retornar_true_se_numerocasa_for_igual_a_numerocasa2() {
        endereco2 = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
        assertThat(endereco.getNumero(), is(endereco2.getNumero()));
    }

    @Test
    public void deve_retornar_true_se_rua_estiver_em_tostring() {
        assertThat(endereco.toString(), containsString("rua"));
    }

    @Test
    public void deve_retornar_true_se_cep_estiver_em_tostring() {
        assertThat(endereco.toString(), containsString("cep"));
    }

    @Test
    public void deve_retornar_true_se_numerocasa_estiver_em_tostring() {
        assertThat(endereco.toString(), containsString("numeroCasa"));
    }

    @Test
    public void deve_retornar_true_se_bairro_estiver_em_tostring() {
        assertThat(endereco.toString(), containsString("bairro"));
    }

    @Test
    public void deve_retornar_false_se_rua2_estiver_em_tostring() {
        assertThat(endereco.toString(), is(not(containsString("rua2"))));
    }

    @Test
    public void deve_retornar_false_se_cep2_estiver_em_tostring() {
        assertThat(endereco.toString(), is(not(containsString("cep2"))));
    }

    @Test
    public void deve_retornar_false_se_numerocasa2_estiver_em_tostring() {
        assertThat(endereco.toString(), is(not(containsString("numerocasa2"))));
    }

    @Test
    public void deve_retornar_false_se_bairro2_estiver_em_tostring() {
        assertThat(endereco.toString(), is(not(containsString("bairro2"))));
    }

    @Test(timeout = 150)
    public void deve_retornar_true_se_cep2_for_igual_a_ele_mesmo_usando_hashcode() {
        Endereco endereco2 = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
        assertThat(endereco2.hashCode(), is(endereco2.hashCode()));
    }

    @Test
    @Ignore
    public void o_mesmo_teste_anterior_para_usar_ignore_test() {
        Endereco endereco2 = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil");
        assertThat(endereco2.hashCode(), is(endereco2.hashCode()));
        System.out.println();
    }

    @After
    public void tearDown() {
        endereco = null;
        endereco2 = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Aqui finalizamos os Testes");
    }
}
