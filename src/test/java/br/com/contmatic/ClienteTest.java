package br.com.contmatic;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.cliente.Cliente;
import br.com.contmatic.endereco.Endereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {

    private Cliente cliente;

    private Cliente cliente2;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Aqui se inicia os Testes");
    }

    @Before
    public void setUp() {
        cliente = new Cliente("Gabriel", "23666158846", "11963220164", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
    }

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        assertNotNull(cliente.getNome());
    }

    @Test
    public void nao_deve_aceitar_cpf_nulo() {
        assertNotNull(cliente.getCpf());
    }

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        assertNotNull(cliente.getTelefone());
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        assertNotNull(cliente.getEndereco());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_numero_em_nome() {
        cliente.setNome("Gabriel123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_nome_for_nulo() {
        cliente.setNome(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_nome_estiver_em_branco() {
        cliente.setNome("                     ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_letra_em_cpf() {
        cliente.setCpf("23666158846abcd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_cpf_for_nulo() {
        cliente.setCpf(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_cpf_estiver_em_branco() {
        cliente.setCpf("                      ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_letra_em_telefone() {
        cliente.setTelefone("11963220164abcd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_telefone_for_nulo() {
        cliente.setTelefone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_telefone_estiver_em_branco() {
        cliente.setTelefone("                 ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_endereco_for_nulo() {
        cliente.setEndereco(null);
    }

    @Test
    public void deve_retornar_true_se_telefone1_for_igual_a_ele_mesmo() {
        assertTrue(cliente.getNome().equals(cliente.getNome()));
    }

    @Test
    public void deve_retornar_true_se_telefone1_for_igual_a_telefone2() {
        cliente2 = new Cliente("Gabriel", "23666158846", "11963220164", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertTrue(cliente.getNome().equals(cliente2.getNome()));
    }

    @Test
    public void deve_retornar_true_se_telefone1_for_diferente_do_telefone2() {
        cliente2 = new Cliente("FULANO", "23666158846", "11963220164", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(cliente.getNome(), is(not(cliente2.getNome())));
    }

    @Test
    public void deve_retornar_true_se_cpf1_for_igual_a_ele_mesmo() {
        assertTrue(cliente.getCpf().equals(cliente.getCpf()));
    }

    @Test
    public void deve_retornar_true_se_cpf1_for_igual_a_cpf2() {
        cliente2 = new Cliente("Gabriel", "23666158846", "11963220164", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertEquals(cliente.getCpf(), (cliente2.getCpf()));
    }

    @Test
    public void deve_retornar_true_se_cpf1_for_diferente_do_cpf2() {
        cliente2 = new Cliente("FULANO", "12345678910", "11912345678", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(cliente.getCpf(), is(not(cliente2.getCpf())));
    }

    @Test
    public void deve_retornar_false_se_nome_do_cliente1_for_diferente_de_nome_do_cliente2() {
        cliente2 = new Cliente("FULANO", "23666158846", "11963220164", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(cliente, is(not(cliente2)));
    }

    @Test
    public void deve_retornar_false_se_cpf_do_cliente1_for_diferente_de_cpf_do_cliente2() {
        cliente2 = new Cliente("Gabriel", "12345678910", "11963220164", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(cliente, is(not(cliente2)));
    }

    @Test
    public void deve_retornar_true_se_cliente1_for_igual_ao_cliente2() {
        cliente2 = new Cliente("Gabriel", "23666158846", "11963220164", new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertTrue(cliente.equals(cliente2));
    }

    @Test
    public void deve_retornar_true_se_cliente_for_diferente_de_nulo() {
        assertFalse(cliente.equals(null));
    }

    @Test
    public void deve_retornar_true_se_endereco_for_igual_a_ele_mesmo() {
        assertTrue(cliente.equals(cliente));
    }

    @Test
    public void deve_retornar_false_se_cliente_for_diferente_de_cliente2() {
        assertFalse(cliente.equals(new Object()));
    }

    @Test
    public void deve_retornar_true_se_nome_estiver_em_tostring() {
        assertThat(cliente.toString(), containsString("nome"));
    }

    @Test
    public void deve_retornar_true_se_cpf_estiver_em_tostring() {
        assertThat(cliente.toString(), containsString("cpf"));
    }

    @Test
    public void deve_retornar_true_se_numero_estiver_em_tostring() {
        assertThat(cliente.toString(), containsString("numero"));
    }

    @Test
    public void deve_retornar_true_se_endereco_estiver_em_tostring() {
        assertThat(cliente.toString(), containsString("endereco"));
    }

    @Test
    public void deve_retornar_false_se_nome2_estiver_em_tostring() {
        assertThat(cliente.toString(), is(not(containsString("nome2"))));
    }

    @Test
    public void deve_retornar_false_se_cpf2_estiver_em_tostring() {
        assertThat(cliente.toString(), is(not(containsString("cpf2"))));
    }

    @Test
    public void deve_retornar_false_se_numero2_estiver_em_tostring() {
        assertThat(cliente.toString(), is(not(containsString("numero2"))));
    }

    @Test
    public void deve_retornar_false_se_idade2_estiver_em_tostring() {
        assertThat(cliente.toString(), is(not(containsString("idade2"))));
    }

    @Test
    public void deve_retornar_false_se_endereco2_estiver_em_tostring() {
        assertThat(cliente.toString(), is(not(containsString("endereco2"))));
    }

    @Test(timeout = 200)
    public void deve_retornar_true_se_cpf2_for_igual_a_ele_mesmo_usando_hashcode() {
        Cliente cliente2 = new Cliente("Gabriel", "23666158846", "11963220164", new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá", "São Paulo", "SP", "Brasil"));
        assertThat(cliente2.hashCode(), is(cliente2.hashCode()));
    }

    @Test 
    @Ignore
    public void o_mesmo_teste_anterior_para_usar_ignore_test() {
        Cliente cliente2 = new Cliente("Gabriel", "23666158846", "11963220164", new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá", "São Paulo", "SP", "Brasil"));
        assertThat(cliente2.hashCode(), is(cliente2.hashCode()));
    }

    @After
    public void tearDown() {
        cliente = null;
        cliente2 = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Aqui finalizamos os Testes");
    }

}
