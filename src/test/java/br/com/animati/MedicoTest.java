package br.com.animati;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.animati.entity.Medico;
import br.com.animati.entity.UfType;
import br.com.animati.service.MedicoService;
import br.com.animati.service.MedicoServiceImpl;

public class MedicoTest {
	
	private MedicoService medicoService;
	
	@Before
	public void init() {
		medicoService = new MedicoServiceImpl();
	}
	
	@Test
	public void cadastrarMedicoTest() throws Exception {
		
		medicoService.limparLista();
		
		Medico medico = new Medico();
		
		medico.setIdMedico(54321);
		medico.setCrm("12345678-9");
		medico.setNome("José da Silva");
		medico.setUf(UfType.SP);
		
		medicoService.cadastrar(medico);
		
		assertEquals(1, medicoService.list().size());
	}
	
	@Test
	public void listarMedicoTest() throws Exception {
		
		medicoService.limparLista();
		
		Medico medico1 = new Medico();
		medico1.setIdMedico(12345);
		medico1.setCrm("98765432-1");
		medico1.setNome("José da Silva");
		medico1.setUf(UfType.AL);
		medicoService.cadastrar(medico1);
		
		Medico medico2 = new Medico();
		medico2.setIdMedico(54321);
		medico2.setCrm("12345678-9");
		medico2.setNome("João dos Santos");
		medico2.setUf(UfType.AM);
		medicoService.cadastrar(medico2);
		
		List<Medico> list = medicoService.list();
		
		assertEquals(2, list.size());
		
	}

	@Test
	public void editarMedicoTest() throws Exception {
		
		medicoService.limparLista();
		
		Medico medico = new Medico();
		
		medico.setIdMedico(12345);
		medico.setCrm("98765432-1");
		medico.setNome("João dos Santos");
		medico.setUf(UfType.PR);
		
		medicoService.cadastrar(medico);
		
		Medico medicoEditar = medicoService.listarPeloId(12345);
		medicoEditar.setNome("Marcos Pacheco");
		medicoService.editar(medicoEditar);
		
		Medico medicoEditado = medicoService.listarPeloId(12345);
		
		assertEquals("Marcos Pacheco", medicoEditado.getNome());
		
	}
	
	@Test
	public void deletarMedicoTest() throws Exception {
		
		medicoService.limparLista();
		
		Medico medico = new Medico();
		
		medico.setIdMedico(45678-9);
		medico.setCrm("998877665-1");
		medico.setNome("Laura Cristina");
		medico.setUf(UfType.AC);
		
		medicoService.cadastrar(medico);
		
		medicoService.deletar(45678-9);
		
		Assert.assertTrue(medicoService.list().isEmpty());
		
	}
	
	@Test
	public void listarPeloIdMedicoTest() throws Exception {
		
		medicoService.limparLista();
		
		Medico medico = new Medico ();
		
		medico.setIdMedico(12345);
		medico.setCrm("98765432-1");
		medico.setNome("José da Silva");
		medico.setUf(UfType.AL);
		
		medicoService.cadastrar(medico);
		
		assertNotNull(medicoService.listarPeloId(12345));
		
	}
	
}