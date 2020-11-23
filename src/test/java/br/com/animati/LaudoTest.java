package br.com.animati;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.animati.entity.Atendimento;
import br.com.animati.entity.Laudo;
import br.com.animati.entity.Medico;
import br.com.animati.entity.Paciente;
import br.com.animati.entity.SexType;
import br.com.animati.entity.UfType;
import br.com.animati.service.AtendimentoService;
import br.com.animati.service.AtendimentoServiceImpl;
import br.com.animati.service.LaudoService;
import br.com.animati.service.LaudoServiceImpl;
import br.com.animati.service.MedicoService;
import br.com.animati.service.MedicoServiceImpl;
import br.com.animati.service.PacienteService;
import br.com.animati.service.PacienteServiceImpl;

public class LaudoTest {

	private LaudoService laudoService;
	private AtendimentoService atendimentoService;
	private MedicoService medicoService;
	private PacienteService pacienteService;

	@Before
	public void init() throws Exception {
		
		pacienteService = new PacienteServiceImpl();

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
		
		medicoService = new MedicoServiceImpl();

		Medico medico = new Medico();
		medico.setIdMedico(64321);
		medico.setCrm("12345678-9");
		medico.setNome("José da Silva");
		medico.setUf(UfType.SP);

		medicoService.cadastrar(medico);

		Paciente pacienteCadastrado = pacienteService.listarPeloId(12345);
		Medico medicoCadastrado = medicoService.listarPeloId(64321);

		atendimentoService = new AtendimentoServiceImpl();

		Atendimento atendimento = new Atendimento();
		atendimento.setIdAtendimento(234);
		atendimento.setDataHora("20/11/2020");
		atendimento.setNomeProcedimento("RX Coluna");
		atendimento.setModalidade("Algo");
		atendimento.setMedico(medicoCadastrado);
		atendimento.setPaciente(pacienteCadastrado);

		atendimentoService.cadastrar(atendimento);
		
		laudoService = new LaudoServiceImpl();
	}

	@Test
	public void cadastroLaudoTest() {

		Atendimento atendimento = atendimentoService.listarPeloId(234);
		Medico medico = medicoService.listarPeloId(64321);

		Laudo laudo = new Laudo();
		laudo.setIdLaudo(98765);
		laudo.setTexto("Lorem ipsum...");
		laudo.setMedico(medico);
		laudo.setAtendimento(atendimento);

		laudoService.cadastrar(laudo);

		Laudo laudoPeloId = laudoService.listarPeloId(98765);

		assertEquals("234", laudoPeloId.getAtendimento().getIdAtendimento());

	}

	@Test
	public void listarLaudoTest() {
		Atendimento atendimento = atendimentoService.listarPeloId(234);
		Medico medico = medicoService.listarPeloId(64321);

		Laudo laudo1 = new Laudo();
		laudo1.setIdLaudo(98765);
		laudo1.setTexto("Lorem ipsum...");
		laudo1.setMedico(medico);
		laudo1.setAtendimento(atendimento);

		laudoService.cadastrar(laudo1);

		Laudo laudo2 = new Laudo();
		laudo2.setIdLaudo(56789);
		laudo2.setTexto("Lorem ipsum...");
		laudo2.setMedico(medico);
		laudo2.setAtendimento(atendimento);

		laudoService.cadastrar(laudo2);

		List<Laudo> list = laudoService.list();

		assertEquals(2, list.size());

	}

	@Test
	public void editarLaudoTest() {
		Atendimento atendimento = atendimentoService.listarPeloId(234);
		Medico medico = medicoService.listarPeloId(64321);

		Laudo laudo = new Laudo();
		laudo.setIdLaudo(56789);
		laudo.setTexto("Lorem ipsum...");
		laudo.setMedico(medico);
		laudo.setAtendimento(atendimento);

		laudoService.cadastrar(laudo);

		Laudo laudoEditar = laudoService.listarPeloId(56789);
		laudoEditar.setTexto("Mudança...");
		laudoService.editar(laudoEditar);

		Laudo laudoEditado = laudoService.listarPeloId(56789);

		assertEquals("Mudança...", laudoEditado.getTexto());
	}

	@Test
	public void deletarLaudoTest() {
		Atendimento atendimento = atendimentoService.listarPeloId(234);
		Medico medico = medicoService.listarPeloId(64321);

		Laudo laudo = new Laudo();
		laudo.setIdLaudo(98765);
		laudo.setTexto("Lorem ipsum...");
		laudo.setMedico(medico);
		laudo.setAtendimento(atendimento);

		laudoService.cadastrar(laudo);

		laudoService.deletar(98765);

		Assert.assertTrue(laudoService.list().isEmpty());

	}

	@Test
	public void listarPeloIdLaudoTest() {
		Atendimento atendimento = atendimentoService.listarPeloId(234);
		Medico medico = medicoService.listarPeloId(64321);

		Laudo laudo = new Laudo();
		laudo.setIdLaudo(98765);
		laudo.setTexto("Lorem ipsum...");
		laudo.setMedico(medico);
		laudo.setAtendimento(atendimento);

		laudoService.cadastrar(laudo);

		assertNotNull(laudoService.listarPeloId(98765));

	}

	/*
	@Test
	public void listarPeloIdMedicoTest() {
		Atendimento atendimento = atendimentoService.listarPeloId(234);
		Medico medico = medicoService.listarPeloId(64321);

		Laudo laudo = new Laudo();
		laudo.setIdLaudo(98765);
		laudo.setTexto("Lorem ipsum...");
		laudo.setMedico(medico);
		laudo.setAtendimento(atendimento);

		laudoService.cadastrar(laudo);
		
		assertNotNull(laudoService.listarPeloIdMedico(64321));
	}
	*/

}
