package br.com.animati.service;

import java.util.List;

import br.com.animati.dao.MedicoDAO;
import br.com.animati.dao.MedicoDAOImpl;
import br.com.animati.entity.Medico;

public class MedicoServiceImpl implements MedicoService {
	
	private MedicoDAO dao;
	
	public MedicoServiceImpl() {
		dao = new MedicoDAOImpl();
	}
	
	@Override
	public void cadastrar(Medico m) {
		dao.cadastrar(m);
	}

	@Override
	public List<Medico> list() {
		return dao.list();
	}

	@Override
	public void editar(Medico m) {
		dao.editar(m);
	}

	@Override
	public void deletar(long idMedico) {
		dao.deletar(idMedico);

	}

	@Override
	public Medico listarPeloId(long idMedico) {
		return dao.listarPeloId(idMedico);
	}

	@Override
	public void limparLista() {
		dao.limparLista();
		
	}

}
