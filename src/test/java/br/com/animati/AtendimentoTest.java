package br.com.animati;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.animati.entity.Atendimento;
import br.com.animati.entity.Medico;
import br.com.animati.entity.Paciente;
import br.com.animati.entity.SexType;
import br.com.animati.entity.UfType;
import br.com.animati.service.AtendimentoService;
import br.com.animati.service.MedicoService;
import br.com.animati.service.PacienteService;

public class AtendimentoTest {

	private AtendimentoService atendimentoService;
	private PacienteService pacienteService;
	private MedicoService medicoService;

	@Before
	public void init() throws Exception {
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

		Medico medico = new Medico();
		medico.setIdMedico(64321);
		medico.setCrm("12345678-9");
		medico.setNome("José da Silva");
		medico.setUf(UfType.SP);

		medicoService.cadastrar(medico);
	}

	@Test
	public void cadastrarAtendimentoTest() {

		Paciente paciente = pacienteService.listarPeloId(12345);
		Medico medico = medicoService.listarPeloId(64321);

		Atendimento atendimento = new Atendimento();
		atendimento.setIdAtendimento(234);
		atendimento.setDataHora("20/11/2020");
		atendimento.setNomeProcedimento("RX Coluna");
		atendimento.setModalidade("Algo");
		atendimento.setMedico(medico);
		atendimento.setPaciente(paciente);
		
		atendimentoService.cadastrar(atendimento);
		
		Atendimento atendimentoPeloId = atendimentoService.listarPeloId(234);
		
		assertEquals("José da Silva", atendimentoPeloId.getPaciente().getNome());

	}
	
	@Test
	public void listarAtendimentoTest() {
		
		Paciente paciente = pacienteService.listarPeloId(12345);
		Medico medico = medicoService.listarPeloId(64321);

		Atendimento atendimento1 = new Atendimento();
		atendimento1.setIdAtendimento(234);
		atendimento1.setDataHora("20/11/2020");
		atendimento1.setNomeProcedimento("RX Coluna");
		atendimento1.setModalidade("Algo");
		atendimento1.setMedico(medico);
		atendimento1.setPaciente(paciente);
		
		atendimentoService.cadastrar(atendimento1);

		Atendimento atendimento2 = new Atendimento();
		atendimento2.setIdAtendimento(432);
		atendimento2.setDataHora("18/11/2020");
		atendimento2.setNomeProcedimento("RX Torax");
		atendimento2.setModalidade("Algo");
		atendimento2.setMedico(medico);
		atendimento2.setPaciente(paciente);
		
		atendimentoService.cadastrar(atendimento2);
		
		List<Atendimento> list = atendimentoService.list();
		
		assertEquals(2, list.size());
		
	}

}
