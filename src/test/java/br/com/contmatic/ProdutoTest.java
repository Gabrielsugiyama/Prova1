package br.com.contmatic;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.Produto;

public class ProdutoTest {

	private Produto produto1;

	@BeforeClass
	public static void Inicio_testes() {
		System.out.println("Aqui se inicia os Testes");
	}

	@Before
	public void setUp() {
		produto1 = new Produto("Etios", 12000.00, "Toyota", "1");
	}

	@Test
	public void nao_deve_aceitar_rua_nulo() {
		assertNotNull(produto1.getModelo());
	}

	@Test
	public void nao_deve_aceitar_cep_nulo() {
		assertNotNull(produto1.getPreco());
	}

	@Test
	public void nao_deve_aceitar_numerocasa_nulo() {
		assertNotNull(produto1.getMarca());
	}

	@Test
	public void nao_deve_aceitar_bairro_nulo() {
		assertNotNull(produto1.getCodigoProduto());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_nome_for_nulo() {
		produto1.setModelo(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_preco_for_zero() {
		produto1.setPreco(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_preco_for_maior_que_cem_milhoes() {
		produto1.setPreco(2000000000.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_marca_for_nulo() {
		produto1.setMarca(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_marca_estiver_em_branco() {
		produto1.setMarca("     			  		  		");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_numero_marca() {
		produto1.setMarca("fdsafsa123fdsafsad123456");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_codigoProduto_for_nulo() {
		produto1.setCodigoProduto(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_nome_estiver_em_branco() {
		produto1.setModelo("                     ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_numero_negativo_em_preco() {
		produto1.setPreco(-5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_preco_for_nulo() {
		produto1.setPreco(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_letra_em_codigo_do_produto() {
		produto1.setCodigoProduto("11963220164abcd");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_codigo_do_produto_estiver_em_branco() {
		produto1.setCodigoProduto("                 ");
	}

	@Test
	public void deve_retornar_true_se_codigo_do_produto1_for_igual_a_ele_mesmo() {
		assertTrue(produto1.getCodigoProduto().equals(produto1.getCodigoProduto()));
	}

	@Test
	public void deve_retornar_true_se_codigo_do_produto1_for_igual_a_codigo_do_produto2() {
		Produto produto2 = new Produto("Etios", 12000.00, "Toyota", "1");
		assertTrue(produto1.getCodigoProduto().equals(produto2.getCodigoProduto()));
	}

	@Test
	public void deve_retornar_true_se_codigo_do_produto1_for_diferente_do_codigo_do_produto2() {
		Produto produto2 = new Produto("Etios", 12000.00, "Toyota", "1");
		assertTrue(produto1.equals(produto2));
	}

	@Test
	public void deve_retornar_true_se_preco_for_igual_a_ele_mesmo() {
		assertThat(produto1.getPreco(), is(produto1.getPreco()));
	}

	@Test
	public void deve_retornar_true_se_nome_for_igual_a_ele_mesmo() {
		assertThat(produto1.getModelo(), is(produto1.getModelo()));
	}

	@Test
	public void deve_retornar_true_se_marca_for_igual_a_ela_mesma() {
		assertThat(produto1.getMarca(), is(produto1.getMarca()));
	}

	@Test
	public void deve_retornar_true_se_preco_do_produto1_for_igual_a_preco_do_produto2() {
		Produto produto2 = new Produto("Etios", 12000.00, "Toyota", "1");
		assertThat(produto1.getPreco(), is((produto2.getPreco())));
	}

	@Test
	public void deve_retornar_true_se_preco_do_produto1_for_diferente_do_preco_do_produto2() {
		Produto produto2 = new Produto("Etios", 60000.00, "Toyota", "1");
		assertThat(produto1.getPreco(), is(not(produto2.getPreco())));
	}

	@Test
	public void deve_retornar_true_se_endereco2_for_diferente_de_nulo() {
		assertFalse(produto1.equals(null));
	}

	@Test
	public void deve_retornar_true_se_produto1_for_diferente_do_produto2() {
		Produto produto2 = new Produto("Carro", 55000.00, "Ford", "3");
		assertThat(produto1, is(not((produto2))));
	}

	@Test
	public void deve_retornar_true_se_produto1_for_igual_a_ele_mesmo() {
		assertTrue(produto1.equals(produto1));
	}

	@Test
	public void deve_retornar_false_se_objeto_produto1_for_diferente_de_outro_objeto() {
		assertFalse(produto1.equals(new Object()));
	}

	@Test
	public void deve_retornar_true_se_produto1_for_igual_a_produto2() {
		Produto produto2 = new Produto("Etios", 12000.00, "Toyota", "1");
		assertTrue(produto1.equals(produto2));
	}

	@Test
	public void deve_retornar_false_se_negacao_de_codigo_do_produto1_for_diferente_a_outro_codigo_de_produto() {
		Produto produto2 = new Produto("Etios", 12000.00, "Toyota", "1");
		assertFalse(!(produto1.getCodigoProduto()).equals(produto2.getCodigoProduto()));
	}

	@Test
	public void deve_retornar_true_se_cpf2_for_igual_a_ele_mesmo_usando_hashcode() {
		Produto produto2 = new Produto("Etios", 12000.00, "Toyota", "1");
		assertThat(produto2.hashCode(), is(produto2.hashCode()));
	}
	
	@Test
	@Ignore
	public void o_mesmo_teste_anterior_para_usar_ignore_test() {
		Produto produto2 = new Produto("Etios", 12000.00, "Toyota", "1");
		assertThat(produto2.hashCode(), is(produto2.hashCode()));
	}
	
	@After
	public void tearDown() {
		produto1 = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Aqui finalizamos os Testes");
	}
}
