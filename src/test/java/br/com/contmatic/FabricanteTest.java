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
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.produto.Fabricante;
import br.com.contmatic.produto.Produto;

public class FabricanteTest {
    private Fabricante fabricante;

    private Fabricante fabricante2;

    @BeforeClass
    public static void Inicio_testes() {
        System.out.println("Aqui se inicia os Testes");
    }

    @Before
    public void setUp() {
        fabricante = new Fabricante("Gabriel", "23666158846", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
    }

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        assertNotNull(fabricante.getNome());
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        assertNotNull(fabricante.getCnpj());
    }

    @Test
    public void nao_deve_aceitar_produto_nulo() {
        assertNotNull(fabricante.getProduto());
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        assertNotNull(fabricante.getEndereco());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_numero_em_nome() {
        fabricante.setNome("Gabriel123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_nome_for_nulo() {
        fabricante.setNome(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_nome_estiver_em_branco() {
        fabricante.setNome("                     ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_letra_em_cnpj() {
        fabricante.setCnpj("23666158846abcd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_cnpj_for_nulo() {
        fabricante.setCnpj(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_cnpj_estiver_em_branco() {
        fabricante.setCnpj("                      ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_produto_for_nulo() {
        fabricante.setProduto(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_endereco_for_nulo() {
        fabricante.setEndereco(null);
    }

    @Test
    public void deve_retornar_true_se_nome_for_igual_a_ele_mesmo() {
        assertTrue(fabricante.getNome().equals(fabricante.getNome()));
    }

    @Test
    public void deve_retornar_true_se_nome1_for_igual_a_nome2() {
        fabricante2 = new Fabricante("Gabriel", "23666158846", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertTrue(fabricante.getNome().equals(fabricante2.getNome()));
    }

    @Test
    public void deve_retornar_true_se_nome_for_diferente_do_nome2() {
        fabricante2 = new Fabricante("FULANO", "12345678910", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(fabricante.getNome(), is(not(fabricante2.getNome())));
    }

    @Test
    public void deve_retornar_true_se_cnpj_for_igual_a_ele_mesmo() {
        assertTrue(fabricante.getCnpj().equals(fabricante.getCnpj()));
    }

    @Test
    public void deve_retornar_true_se_cnpj_for_igual_a_cnpj2() {
        fabricante2 = new Fabricante("FULANO", "23666158846", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertEquals(fabricante.getCnpj(), (fabricante2.getCnpj()));
    }

    @Test
    public void deve_retornar_true_se_cnpj1_for_diferente_do_cnpj2() {
        fabricante2 = new Fabricante("FULANO", "12345678910", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(fabricante.getCnpj(), is(not(fabricante2.getCnpj())));
    }

    @Test
    public void deve_retornar_true_se_fabricante1_for_diferente_do_fabricante2() {
        fabricante2 = new Fabricante("FULANO", "12345678910", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(fabricante, is(not(fabricante2)));
    }

    @Test
    public void deve_retornar_true_se_fabricante1_for_igual_ao_fabricante2() {
        fabricante2 = new Fabricante("Gabriel", "23666158846", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertTrue(fabricante.equals(fabricante2));
    }

    @Test
    public void deve_retornar_true_se_fabricante_for_diferente_de_nulo() {
        assertFalse(fabricante.equals(null));
    }

    @Test
    public void deve_retornar_true_se_endereco_for_igual_a_ele_mesmo() {
        assertTrue(fabricante.equals(fabricante));
    }

    @Test
    public void deve_retornar_false_se_cliente_for_diferente_de_cliente2() {
        assertFalse(fabricante.equals(new Object()));
    }

    @Test
    public void deve_retornar_true_se_nome_estiver_em_tostring() {
        assertThat(fabricante.toString(), containsString("nome"));
    }

    @Test
    public void deve_retornar_true_se_cnpj_estiver_em_tostring() {
        assertThat(fabricante.toString(), containsString("cnpj"));
    }

    @Test
    public void deve_retornar_true_se_produto_estiver_em_tostring() {
        assertThat(fabricante.toString(), containsString("produto"));
    }

    @Test
    public void deve_retornar_true_se_endereco_estiver_em_tostring() {
        assertThat(fabricante.toString(), containsString("endereco"));
    }

    @Test
    public void deve_retornar_false_se_nome2_estiver_em_tostring() {
        assertThat(fabricante.toString(), is(not(containsString("nome2"))));
    }

    @Test
    public void deve_retornar_false_se_cnpj2_estiver_em_tostring() {
        assertThat(fabricante.toString(), is(not(containsString("cnpj2"))));
    }

    @Test
    public void deve_retornar_false_se_produto2_estiver_em_tostring() {
        assertThat(fabricante.toString(), is(not(containsString("produto2"))));
    }

    @Test
    public void deve_retornar_false_se_endereco2_estiver_em_tostring() {
        assertThat(fabricante.toString(), is(not(containsString("endereco2"))));
    }

    @Test(timeout = 200)
    public void deve_retornar_true_se_cpf2_for_igual_a_ele_mesmo_usando_hashcode() {
        Fabricante fabricante2 = new Fabricante("FULANO", "12345678910", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(fabricante2.hashCode(), is(fabricante2.hashCode()));
    }

    @Test
    @Ignore
    public void o_mesmo_teste_anterior_para_usar_ignore_test() {
        Fabricante fabricante2 = new Fabricante("FULANO", "12345678910", new Produto("Carro", "Etios", 12000.00, "Toyota", "1"), new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        assertThat(fabricante2.hashCode(), is(fabricante2.hashCode()));
    }

    @After
    public void tearDown() {
        fabricante = null;
        fabricante2 = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Aqui finalizamos os Testes");
    }
}
