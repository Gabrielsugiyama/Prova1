package br.com.contmatic.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({FabricanteTest.class, ProdutoTest.class, EnderecoTest.class, ClienteTest.class})
public class RunnerTest {
}
