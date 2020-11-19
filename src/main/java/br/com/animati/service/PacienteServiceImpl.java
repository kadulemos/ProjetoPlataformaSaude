package br.com.animati.service;

import java.util.List;

import br.com.animati.dao.PacienteDAO;
import br.com.animati.dao.PacienteDAOImpl;
import br.com.animati.entity.Paciente;

public class PacienteServiceImpl implements PacienteService {
	
	private PacienteDAO dao;
	
	public PacienteServiceImpl() {
		dao = new PacienteDAOImpl();
	}

	@Override
	public void cadastrar(Paciente p) {
		dao.cadastrar(p);

	}

	@Override
	public List<Paciente> list() {
		return dao.list();
	}

	@Override
	public void editar(Paciente p) {
		dao.editar(p);

	}

	@Override
	public void deletar(long idPaciente) {
		dao.deletar(idPaciente);

	}

	@Override
	public Paciente listarPeloId(long idPaciente) {
		return dao.listarPeloId(idPaciente);
	}

	@Override
	public void limparLista() {
		dao.limparLista();

	}

}
