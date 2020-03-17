package br.com.contmatic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ClienteTest.class, EnderecoTest.class, FabricanteTest.class, FuncionarioTest.class, ProdutoTest.class})
public class RunnerTest {
}
