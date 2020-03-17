package br.com.contmatic;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.Funcionario;
import br.com.contmatic.Endereco;

public class FuncionarioTest {
	private Funcionario funcionario;

	private Funcionario funcionario2;

	@BeforeClass
	public static void Inicio_testes() {
		System.out.println("Aqui se inicia os Testes");
	}

	@Before
	public void setUp() {
		funcionario = new Funcionario("Gabriel", "23666158846", "11963220164", 20 ,
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
	}

	@Test
	public void nao_deve_aceitar_nome_nulo() {
		assertNotNull(funcionario.getNome());
	}

	@Test
	public void nao_deve_aceitar_cpf_nulo() {
		assertNotNull(funcionario.getCpf());
	}

	@Test
	public void nao_deve_aceitar_telefone_nulo() {
		assertNotNull(funcionario.getTelefone());
	}

	@Test
	public void nao_deve_aceitar_idade_nulo() {
		assertNotNull(funcionario.getIdade());
	}
	
	@Test
	public void nao_deve_aceitar_endereco_nulo() {
		assertNotNull(funcionario.getEndereco());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_numero_em_nome() {
		funcionario.setNome("Gabriel123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_nome_for_nulo() {
		funcionario.setNome(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_nome_estiver_em_branco() {
		funcionario.setNome("                     ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_letra_em_cpf() {
		funcionario.setCpf("23666158846abcd");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_cpf_for_nulo() {
		funcionario.setCpf(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_cpf_estiver_em_branco() {
		funcionario.setCpf("                      ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_houver_letra_em_telefone() {
		funcionario.setTelefone("11963220164abcd");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_telefone_for_nulo() {
		funcionario.setTelefone(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_telefone_estiver_em_branco() {
		funcionario.setTelefone("                 ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_idade_for_menor_que_0() {
		funcionario.setIdade(-5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_idade_for_maior_que_125() {
		funcionario.setIdade(127);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_exception_se_endereco_for_nulo() {
		funcionario.setEndereco(null);
	}

	@Test
	public void deve_retornar_true_se_nome_for_igual_a_ele_mesmo() {
		assertTrue(funcionario.getNome().equals(funcionario.getNome()));
	}

	@Test
	public void deve_retornar_true_se_telefone1_for_igual_a_telefone2() {
		funcionario2 = new Funcionario("Gabriel", "23666158846", "11963220164",20 , 
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertTrue(funcionario.getTelefone().equals(funcionario2.getTelefone()));
	}

	@Test
	public void deve_retornar_true_se_telefone1_for_diferente_do_telefone2() {
		funcionario2 = new Funcionario("FULANO", "12345678910", "11912345678",20 ,
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertThat(funcionario.getTelefone(), is(not(funcionario2.getTelefone())));
	}

	@Test
	public void deve_retornar_true_se_cpf1_for_igual_a_ele_mesmo() {
		assertTrue(funcionario.getCpf().equals(funcionario.getCpf()));
	}

	@Test
	public void deve_retornar_true_se_cpf1_for_igual_a_cpf2() {
		funcionario2 = new Funcionario("Gabriel", "23666158846", "11963220164",20 ,
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertEquals(funcionario.getCpf(), (funcionario2.getCpf()));
	}

	@Test
	public void deve_retornar_true_se_cpf1_for_diferente_do_cpf2() {
		funcionario2 = new Funcionario("FULANO", "12345678910", "11912345678",20 ,
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertThat(funcionario.getCpf(), is(not(funcionario2.getCpf())));
	}

	@Test
	public void deve_retornar_false_se_nome_do_funcionario_for_diferente_do_nome_do_funcionario2() {
		funcionario2 = new Funcionario("FULANO", "23666158846", "11963220164", 20,
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertThat(funcionario,is(not(funcionario2)));
	}
	
	@Test
	public void deve_retornar_false_se_cpf_do_funcionario_for_diferente_de_cpf_do_funcionario2() {
		funcionario2 = new Funcionario("Gabriel", "12345678910", "11963220164", 20,
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertThat(funcionario,is(not(funcionario2)));
	}
	
	@Test
	public void deve_retornar_true_se_funcionario_for_igual_ao_funcionario2() {
		funcionario2 = new Funcionario("Gabriel", "23666158846", "11963220164", 20,
				new Endereco("FernandesPortalegre", "03523000", "774", "JardimMaringá"));
		assertTrue(funcionario.equals(funcionario2));
	}

	@Test
	public void deve_retornar_true_se_funcionario_for_diferente_de_nulo() {
		assertFalse(funcionario.equals(null));
	}

	@Test
	public void deve_retornar_true_se_funcionario_for_igual_a_ele_mesmo() {
		assertTrue(funcionario.equals(funcionario));
	}

	@Test
	public void deve_retornar_false_se_funcionario_for_diferente_de_um_objeto_qualquer() {
		assertFalse(funcionario.equals(new Object()));
	}

	@Test
	public void deve_retornar_true_se_nome_estiver_em_tostring() {
		assertThat(funcionario.toString(), containsString("nome"));
	}
	@Test
	public void deve_retornar_true_se_cpf_estiver_em_tostring() {
		assertThat(funcionario.toString(), containsString("cpf"));
	}
	@Test
	public void deve_retornar_true_se_numero_estiver_em_tostring() {
		assertThat(funcionario.toString(), containsString("numero"));
	}

	@Test
	public void deve_retornar_true_se_idade_estiver_em_tostring() {
		assertThat(funcionario.toString(), containsString("idade"));
	}

	@Test
	public void deve_retornar_false_se_endereco_estiver_em_tostring() {
		assertThat(funcionario.toString(), containsString("endereco"));
	}
	
	@Test
	public void deve_retornar_false_se_nome2_estiver_em_tostring() {
		assertThat(funcionario.toString(),is(not(containsString("nome2"))));
	}
	@Test
	public void deve_retornar_false_se_cpf2_estiver_em_tostring() {
		assertThat(funcionario.toString(),is(not(containsString("cpf2"))));
	}
	@Test
	public void deve_retornar_false_se_numero2_estiver_em_tostring() {
		assertThat(funcionario.toString(),is(not(containsString("numero2"))));
	}

	@Test
	public void deve_retornar_false_se_idade2_estiver_em_tostring() {
		assertThat(funcionario.toString(),is(not(containsString("idade2"))));
	}

	@Test
	public void deve_retornar_false_se_endereco2_estiver_em_tostring() {
		assertThat(funcionario.toString(),is(not(containsString("endereco2"))));
	}
	
	@Test(timeout = 200)
	public void deve_retornar_true_se_cpf2_for_igual_a_ele_mesmo_usando_hashcode() {
		Funcionario cliente2 = new Funcionario("Gabriel", "23666158846", "11963220164", 20,
				new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá"));
		assertThat(cliente2.hashCode(), is(cliente2.hashCode()));
	}
	
	@Test
	@Ignore
	public void o_mesmo_teste_anterior_para_usar_ignore_test() {
		Funcionario cliente2 = new Funcionario("Gabriel", "23666158846", "11963220164", 20,
				new Endereco("Fernandes Portalegre", "03523000", "774", "Jardim Maringá"));
		assertThat(cliente2.hashCode(), is(cliente2.hashCode()));
	}
	
	@After
	public void tearDown() {
		funcionario = null;
		funcionario2 = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Aqui finalizamos os Testes");
	}
}