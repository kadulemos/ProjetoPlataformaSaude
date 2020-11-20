package br.com.animati;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.animati.entity.Atendimento;
import br.com.animati.entity.Laudo;
import br.com.animati.entity.Medico;
import br.com.animati.entity.Paciente;
import br.com.animati.entity.SexType;
import br.com.animati.entity.UfType;
import br.com.animati.service.AtendimentoService;
import br.com.animati.service.LaudoService;
import br.com.animati.service.MedicoService;
import br.com.animati.service.PacienteService;

public class LaudoTest {
	
	private LaudoService laudoService;
	private AtendimentoService atendimentoService;
	private MedicoService medicoService;
	private PacienteService pacienteService;
	
	@Before
	public void init() throws Exception {
		
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
		
		Medico medico = new Medico();
		medico.setIdMedico(64321);
		medico.setCrm("12345678-9");
		medico.setNome("José da Silva");
		medico.setUf(UfType.SP);

		medicoService.cadastrar(medico);
		
		Paciente pacienteCadastrado = pacienteService.listarPeloId(12345);
		Medico medicoCadastrado = medicoService.listarPeloId(64321);
		

		Atendimento atendimento = new Atendimento();
		atendimento.setIdAtendimento(234);
		atendimento.setDataHora("20/11/2020");
		atendimento.setNomeProcedimento("RX Coluna");
		atendimento.setModalidade("Algo");
		atendimento.setMedico(medicoCadastrado);
		atendimento.setPaciente(pacienteCadastrado);
		
		atendimentoService.cadastrar(atendimento);
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

}
