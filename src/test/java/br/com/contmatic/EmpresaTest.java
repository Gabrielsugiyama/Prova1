package br.com.contmatic;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.endereco.Endereco;

public class EmpresaTest {

    private Empresa empresa1;

    private Empresa empresa2;

    private static List<Endereco> enderecos;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Aqui se inicia os Testes");
    }

    @Before
    public void setUp() {
        enderecos = new ArrayList<>();
        enderecos.add(new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá", "São Paulo", "SP", "Brasil"));
        empresa1 = new Empresa("EmpresaTeste.LTDA", "Empresa", "Empresa01@hotmail.com", "12345678901234", enderecos);
    }

    @Test
    public void nao_deve_aceitar_nomeFantasia_nulo() {
        assertNotNull(empresa1.getNomeFantasia());
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        assertNotNull(empresa1.getCnpj());
    }

    @Test
    public void nao_deve_aceitar_email_nulo() {
        assertNotNull(empresa1.getEmail());
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        assertNotNull(empresa1.getEndereco());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_numero_em_nome() {
        empresa1.setNomeFantasia("Empresa1234");
    }

    @Test(expected = NullPointerException.class)
    public void deve_retornar_exception_se_nomeFantasia_for_nulo() {
        empresa1.setNomeFantasia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_nomeFantasia_estiver_em_branco() {
        empresa1.setNomeFantasia("                     ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_houver_letra_em_cnpj() {
        empresa1.setCnpj("23666158846abcd");
    }

    @Test(expected = NullPointerException.class)
    public void deve_retornar_exception_se_cnpj_for_nulo() {
        empresa1.setCnpj(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_cnpj_estiver_em_branco() {
        empresa1.setCnpj("                      ");
    }

    @Test(expected = NullPointerException.class)
    public void deve_retornar_exception_se_email_for_nulo() {
        empresa1.setEmail(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_retornar_exception_se_email_estiver_em_branco() {
        empresa1.setEmail("                 ");
    }

    @Test(expected = NullPointerException.class)
    public void deve_retornar_exception_se_endereco_for_nulo() {
        empresa1.setEnderecos(null);
    }

    @Test
    public void deve_retornar_true_se_NomeFantasia_for_igual_a_ele_mesmo() {
        assertTrue(empresa1.getNomeFantasia().equals(empresa1.getNomeFantasia()));
    }

    @Test
    public void deve_retornar_true_se_NomeFantasia_for_igual_a_NomeFantasia2() {
        empresa2 = new Empresa("EmpresaTeste.LTDA", "Empresa", "Empresa01@hotmail.com", "12345678901234", enderecos);
        assertTrue(empresa1.getNomeFantasia().equals(empresa2.getNomeFantasia()));
    }

    @Test
    public void deve_retornar_true_se_NomeFantasia_for_diferente_do_NomeFantasia2() {
        empresa2 = new Empresa("EmpresaTeste.LTDA", "Empresinha", "Empresa01@hotmail.com", "12345678901234", enderecos);
        assertThat(empresa1.getNomeFantasia(), is(not(empresa2.getNomeFantasia())));
    }

    @Test
    public void deve_retornar_true_se_cnpj_for_igual_a_ele_mesmo() {
        assertTrue(empresa1.getCnpj().equals(empresa1.getCnpj()));
    }

    @Test
    public void deve_retornar_true_se_cnpj_for_igual_a_cnpj2() {
        empresa2 = new Empresa("EmpresaTeste.LTDA", "Empresa", "Empresa01@hotmail.com", "12345678901234", enderecos);
        assertEquals(empresa1.getCnpj(), (empresa2.getCnpj()));
    }

    @Test
    public void deve_retornar_true_se_cnpj_for_diferente_do_cnpj2() {
        empresa2 = new Empresa("EmpresaTeste.LTDA", "Empresa", "Empresa01@hotmail.com", "44444444444444", enderecos);
        assertThat(empresa1.getCnpj(), is(not(empresa2.getCnpj())));
    }

    @Test
    public void deve_retornar_true_se_razaoSocial_da_empresa1_for_diferente_de_razaoSocial_da_empresa2() {
        empresa2 = new Empresa("EmpresaTesteDois.LTDA", "EmpresaDois", "Empresa02@hotmail.com", "11111111111111", enderecos);
        assertThat(empresa1, is(not(empresa2)));
    }

    @Test
    public void deve_retornar_false_se_cnpj_da_empresa1_for_diferente_de_cnpj_do_empresa2() {
        empresa2 = new Empresa("EmpresaTeste.LTDA", "Empresa", "Empresa01@hotmail.com", "44444444444444", enderecos);
        assertThat(empresa1, is(not(empresa2)));
    }

    @Test
    public void deve_retornar_true_se_empresa1_for_igual_a_empresa2() {
        empresa2 = new Empresa("EmpresaTeste.LTDA", "Empresa", "Empresa01@hotmail.com", "12345678901234", enderecos);
        assertTrue(empresa1.equals(empresa2));
    }

    @Test
    public void deve_retornar_true_se_empresa_for_diferente_de_nulo() {
        assertFalse(empresa1.equals(null));
    }

    @Test
    public void deve_retornar_true_se_endereco_for_igual_a_ele_mesmo() {
        assertTrue(empresa1.equals(empresa1));
    }

    @Test
    public void deve_retornar_false_se_empresa_for_diferente_de_outra_empresa() {
        assertFalse(empresa1.equals(new Object()));
    }

    @Test
    public void deve_retornar_true_se_nome_estiver_em_tostring() {
        assertThat(empresa1.toString(), containsString("nomeFantasia"));
    }

    @Test
    public void deve_retornar_true_se_cpf_estiver_em_tostring() {
        assertThat(empresa1.toString(), containsString("cnpj"));
    }

    @Test
    public void deve_retornar_true_se_razaoSocial_estiver_em_tostring() {
        assertThat(empresa1.toString(), containsString("razaoSocial"));
    }

    @Test
    public void deve_retornar_true_se_endereco_estiver_em_tostring() {
        assertThat(empresa1.toString(), containsString("enderecos"));
    }

    @Test
    public void deve_retornar_true_se_email_estiver_em_tostring() {
        assertThat(empresa1.toString(), containsString("email"));
    }

    @Test
    public void deve_retornar_false_se_nomeFantasia2_estiver_em_tostring() {
        assertThat(empresa1.toString(), is(not(containsString("nomeFantasia2"))));
    }

    @Test
    public void deve_retornar_false_se_cnpj2_estiver_em_tostring() {
        assertThat(empresa1.toString(), is(not(containsString("cnpj2"))));
    }

    @Test
    public void deve_retornar_false_se_razaoSocial2_estiver_em_tostring() {
        assertThat(empresa1.toString(), is(not(containsString("razaoSocial2"))));
    }

    @Test
    public void deve_retornar_false_se_email2_estiver_em_tostring() {
        assertThat(empresa1.toString(), is(not(containsString("email2"))));
    }

    @Test
    public void deve_retornar_false_se_endereco2_estiver_em_tostring() {
        assertThat(empresa1.toString(), is(not(containsString("endereco2"))));
    }

    @Test(timeout = 200)
    public void deve_retornar_true_se_cnpj2_for_igual_a_ele_mesmo_usando_hashcode() {
        Empresa empresa2 = new Empresa("EmpresaTesteDois.LTDA", "Empresa", "Empresa01@hotmail.com", "12345678901234", enderecos);
        assertThat(empresa2.hashCode(), is(empresa2.hashCode()));
    }

    public void deve_retornar_true_se_cnpj2_for_igual_a_zero_hashcode() {
        Empresa empresa2 = new Empresa("EmpresaTesteDois.LTDA", "Empresa", "Empresa01@hotmail.com", "0", enderecos);
        assertThat(empresa2.hashCode(), is(0));
    }

    @Test
    @Ignore
    public void o_mesmo_teste_anterior_para_usar_ignore_test() {
        Empresa cliente2 = new Empresa("EmpresaTesteDois.LTDA", "Empresa", "Empresa01@hotmail.com", "11111111111111", enderecos);
        assertThat(cliente2.hashCode(), is(cliente2.hashCode()));
    }

    @After
    public void tearDown() {
        empresa1 = null;
        empresa2 = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Aqui finalizamos os Testes");
    }

}
