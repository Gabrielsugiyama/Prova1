package br.com.contmatic.empresa;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.Cliente;
import br.com.contmatic.Endereco;

public class ClienteTest {

	private Cliente cliente;

	private Cliente cliente2;

	@BeforeClass
	public static void Inicio_testes() {
		System.out.println("Aqui se inicia os Testes");
	}

	@Before
	public void setUp() {
		cliente = new Cliente("Gabriel", "23666158846", "11963220164",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
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

	@Test
	public void deve_retornar_true_se_telefone1_for_igual_a_ele_mesmo() {
		assertTrue(cliente.getTelefone().equals(cliente.getTelefone()));
	}

	@Test
	public void deve_retornar_true_se_telefone1_for_igual_a_telefone2() {
		cliente2 = new Cliente("Gabriel", "23666158846", "11963220164",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertTrue(cliente.getTelefone().equals(cliente2.getTelefone()));
	}

	@Test
	public void deve_retornar_true_se_telefone1_for_diferente_do_telefone2() {
		cliente2 = new Cliente("FULANO", "12345678910", "11912345678",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertThat(cliente.getTelefone(), is(not(cliente2.getTelefone())));
	}

	@Test
	public void deve_retornar_true_se_cpf1_for_igual_a_ele_mesmo() {
		assertTrue(cliente.getCpf().equals(cliente.getCpf()));
	}

	@Test
	public void deve_retornar_true_se_cpf1_for_igual_a_cpf2() {
		cliente2 = new Cliente("Gabriel", "23666158846", "11963220164",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertEquals(cliente.getCpf(), (cliente2.getCpf()));
	}

	@Test
	public void deve_retornar_true_se_cpf1_for_diferente_do_cpf2() {
		cliente2 = new Cliente("FULANO", "12345678910", "11912345678",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertThat(cliente.getCpf(), is(not(cliente2.getCpf())));
	}

	@Test
	public void deve_retornar_true_se_cliente1_for_diferente_do_cliente2() {
		cliente2 = new Cliente("FULANO", "12345678910", "11912345678",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertTrue(cliente != (cliente2));
	}

	@Test
	public void deve_retornar_false_se_cpf_for_nulo_e_cpf2_for_diferente_de_nulo() {
		Cliente cliente2 = new Cliente("FULANO", null, "11912345678",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertFalse(cliente2.equals(cliente));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_true_se_cpf01_e_cpf02_forem_iguais_a_nulo() {
		Cliente cliente = new Cliente("FULANO", "12345678911", "11912345678",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		Cliente cliente2 = new Cliente("FULANO", null, "11912345678",
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertNull(cliente.getCpf());
//		assertNull(cliente2.getCpf());
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
	public void deve_retornar_true_se_endereco_for_igual_a_endereco2() {
		Cliente cliente2 = new Cliente("Gabriel", "23666158846", "1196322-0164",
				new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá"));
		assertTrue(cliente.equals(cliente2));
	}

	@Test
	public void deve_retornar_false_se_cliente_for_diferente_a_cliente2_nulo() {
		Cliente cliente2 = new Cliente(null, null, null, null);
		assertFalse(cliente.equals(cliente2));
	}
	@Test
	public void deve_retornar_false_se_cpf_for_diferente_a_cpf2_nulo() {
		Cliente cliente2 = new Cliente(null, null, null, null);
		assertFalse(cliente.equals(cliente2));
	}
	@Test
	public void deve_retornar_true_se_cpf2_for_igual_a_ele_mesmo_usando_hashcode() {
		Cliente cliente2 = new Cliente("Gabriel", "23666158846", "1196322-0164",
				new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá"));
		assertThat(cliente2.hashCode(), is(cliente2.hashCode()));
	}
	@Test
	public void deve_retornar_true_se_cpf2_for_nulo_usando_hashcode() {
		Cliente cliente2 = new Cliente("Gabriel", null, "11963220164",
				new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá"));
		assertThat(cliente2.hashCode(), is(cliente2.hashCode()));
	}
	
}