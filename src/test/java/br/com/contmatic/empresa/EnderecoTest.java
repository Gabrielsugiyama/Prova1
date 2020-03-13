package br.com.contmatic.empresa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.Endereco;

public class EnderecoTest {
	private Endereco endereco;
	private Endereco endereco2;

	@BeforeClass
	public static void Inicio_testes() {
		System.out.println("Aqui se inicia os Testes");
	}

	@Before
	public void setUp() {
		endereco = new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá");
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
	public void nao_deve_aceitar_numerocasa_nulo() {
		assertNotNull(endereco.getNumeroCasa());
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
		endereco.setRua("     ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_letra_em_cep() {
		endereco.setCep("abc133584");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_cep_estiver_em_branco() {
		endereco.setCep("   ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_letra_em_numerocasa() {
		endereco.setNumeroCasa("sa");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_numerocasa_estiver_em_branco() {
		endereco.setNumeroCasa("    ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_numero_em_bairro() {
		endereco.setBairro("12345678fdsafdsa9");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_bairro_estiver_em_branco() {
		endereco.setBairro("     ");
	}

	@Test
	public void deve_retornar_true_se_cep_for_diferente_do_cep2() {
		endereco2 = new Endereco("Fernandes Portalegre", "12345678", "123456", "Jardim Maringá");
		assertThat(endereco.getCep(), is(not(endereco2.getCep())));
	}

	@Test
	public void deve_retornar_true_se_numerocasa_for_igual_a_ela_mesma() {
		assertTrue(endereco.getNumeroCasa().equals(endereco.getNumeroCasa()));
	}

	@Test
	public void deve_retornar_false_se_negacao_de_numerocasa_for_diferente_a_ela_mesma() {
		assertFalse(!(endereco.getNumeroCasa()).equals(endereco.getNumeroCasa()));
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
		endereco2 = new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá");
		assertTrue(endereco.equals(endereco2));
	}

	@Test
	public void deve_retornar_false_se_endereco_for_igual_a_endereco2_nulo() {
		endereco2 = new Endereco(null, null, null, null);
		assertFalse(endereco.equals(endereco2));
	}

	@Test
	public void deve_retornar_false_se_cep_for_nulo_e_cep2_for_diferente_de_nulo() {
		endereco2 = new Endereco("Fernandes Portalegre", null, "123456", "Jardim Maringá");
		assertFalse(endereco2.equals(endereco));
	}

	@Test
	public void deve_retornar_true_se_cep01_e_cep02_forem_iguais_a_nulo() {
		Endereco endereco01 = new Endereco("Fernandes Portalegre", null, "123456", "Jardim Maringá");
		endereco2 = new Endereco("Fernandes Portalegre", null, "123456", "Jardim Maringá");
		assertTrue(endereco2.equals(endereco01));
	}

	@Test
	public void deve_retornar_true_se_numerocasa_for_nulo_e_numerocasa2_for_diferente_de_nulo() {
		endereco2 = new Endereco("Fernandes Portalegre", "03523000", null, "Jardim Maringá");
		assertFalse(endereco2.equals((endereco)));
	}

	@Test
	public void deve_retornar_true_se_numerocasa_for_diferente_a_numerocasa2() {
		endereco2 = new Endereco("Fernandes Portalegre", "03523000", "123456", "Jardim Maringá");
		assertFalse(endereco.equals((endereco2)));
	}

	@Test
	public void deve_retornar_true_se_numerocasa1_e_numerocasa02_forem_nulos() {
		Endereco endereco03 = new Endereco("Fernandes Portalegre", "03523000", null, "Jardim Maringá");
		endereco2 = new Endereco("Fernandes Portalegre", "03523000", null, "Jardim Maringá");
		assertTrue(endereco2.equals(endereco03));
	}

	@Test
	public void deve_retornar_true_se_numerocasa_for_igual_a_numerocasa2() {
		endereco2 = new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá");
		assertThat(endereco.getNumeroCasa(), is(endereco2.getNumeroCasa()));
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
}
