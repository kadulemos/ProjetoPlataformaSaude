package br.com.animati;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.animati.entity.Paciente;
import br.com.animati.entity.SexType;
import br.com.animati.entity.UfType;
import br.com.animati.service.PacienteService;
import br.com.animati.service.PacienteServiceImpl;

public class PacienteTest {

	private PacienteService pacienteService;

	@Before
	public void init() {
		pacienteService = new PacienteServiceImpl();
	}

	@Test
	public void cadastrarTest() {

		pacienteService.limparLista();

		Paciente paciente = new Paciente();
		paciente.setIdPaciente(12345);
		paciente.setEmpresa("LG");
		paciente.setNome("José da Silva");
		paciente.setNomeSocial("");
		paciente.setNomeMae("Laura da Silva");
		paciente.setUf(UfType.SP);
		paciente.setCpf("123.456.789-0");
		paciente.setPassword("1111");
		paciente.setRg("1.234.567-8");
		paciente.setSexo(SexType.M);

		pacienteService.cadastrar(paciente);

		assertEquals(1, pacienteService.list().size());

	}

	@Test
	public void listarTest() {

		pacienteService.limparLista();

		Paciente paciente1 = new Paciente();
		paciente1.setIdPaciente(12345);
		paciente1.setEmpresa("LG");
		paciente1.setNome("José da Silva");
		paciente1.setNomeSocial("");
		paciente1.setNomeMae("Laura da Silva");
		paciente1.setUf(UfType.SP);
		paciente1.setCpf("123.456.789-0");
		paciente1.setPassword("1111");
		paciente1.setRg("1.234.567-8");
		paciente1.setSexo(SexType.M); 

		pacienteService.cadastrar(paciente1);

		Paciente paciente2 = new Paciente();
		paciente2.setIdPaciente(54321);
		paciente2.setEmpresa("Sony");
		paciente2.setNome("Julia da Silva");
		paciente2.setNomeSocial("");
		paciente2.setNomeMae("Joana da Silva");
		paciente2.setUf(UfType.MG);
		paciente2.setCpf("908.765.432-1");
		paciente2.setPassword("2222");
		paciente2.setRg("9.897.432-4");
		paciente2.setSexo(SexType.F);

		pacienteService.cadastrar(paciente2);

		List<Paciente> list = pacienteService.list();

		assertEquals(2, list.size());
	}

	@Test
	public void editarTest() {

		pacienteService.limparLista();

		Paciente paciente1 = new Paciente();
		paciente1.setIdPaciente(12345);
		paciente1.setEmpresa("LG");
		paciente1.setNome("José da Silva");
		paciente1.setNomeSocial("");
		paciente1.setNomeMae("Laura da Silva");
		paciente1.setUf(UfType.SP);
		paciente1.setCpf("123.456.789-0");
		paciente1.setPassword("1111");
		paciente1.setRg("1.234.567-8");
		paciente1.setSexo(SexType.M);

		pacienteService.cadastrar(paciente1);

		Paciente paciente2 = new Paciente();
		paciente2.setIdPaciente(54321);
		paciente2.setEmpresa("Sony");
		paciente2.setNome("Julia da Silva");
		paciente2.setNomeSocial("");
		paciente2.setNomeMae("Joana da Silva");
		paciente2.setUf(UfType.MG);
		paciente2.setCpf("908.765.432-1");
		paciente2.setPassword("2222");
		paciente2.setRg("9.897.432-4");
		paciente2.setSexo(SexType.F);

		pacienteService.cadastrar(paciente2);

		Paciente pacienteEditar = pacienteService.listarPeloId(12345);
		pacienteEditar.setNome("João da Silva");
		pacienteService.editar(pacienteEditar);

		Paciente pacienteEditado = pacienteService.listarPeloId(12345);

		assertEquals("João da Silva", pacienteEditado.getNome());
	}
	
	@Test
	public void deletarTest() {
		
		pacienteService.limparLista();
		
		Paciente paciente = new Paciente();
		paciente.setIdPaciente(12345);
		paciente.setEmpresa("LG");
		paciente.setNome("José da Silva");
		paciente.setNomeSocial("");
		paciente.setNomeMae("Laura da Silva");
		paciente.setUf(UfType.SP);
		paciente.setCpf("123.456.789-0");
		paciente.setPassword("1111");
		paciente.setRg("1.234.567-8");
		paciente.setSexo(SexType.M);

		pacienteService.cadastrar(paciente);
		
		pacienteService.deletar(12345);
		
		Assert.assertTrue(pacienteService.list().isEmpty());
	}
	
	@Test
	public void listarPeloIdTest() {
		
		pacienteService.limparLista();
		
		Paciente paciente = new Paciente();
		paciente.setIdPaciente(54321);
		paciente.setEmpresa("Sony");
		paciente.setNome("Julia da Silva");
		paciente.setNomeSocial("");
		paciente.setNomeMae("Joana da Silva");
		paciente.setUf(UfType.MG);
		paciente.setCpf("908.765.432-1");
		paciente.setPassword("2222");
		paciente.setRg("9.897.432-4");
		paciente.setSexo(SexType.F);
		
		pacienteService.cadastrar(paciente);
		
		assertNotNull(pacienteService.listarPeloId(54321));
	}

}
