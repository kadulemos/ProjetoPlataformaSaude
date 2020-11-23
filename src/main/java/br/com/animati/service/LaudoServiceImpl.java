package br.com.animati.service;

import java.util.List;

import br.com.animati.dao.LaudoDAO;
import br.com.animati.dao.LaudoDAOImpl;
import br.com.animati.entity.Laudo;

public class LaudoServiceImpl implements LaudoService {
	
	private LaudoDAO dao;
	
	public LaudoServiceImpl() {
		dao = new LaudoDAOImpl();
	}

	@Override
	public void cadastrar(Laudo l) {
		dao.cadastrar(l);

	}

	@Override
	public List<Laudo> list() {
		return dao.list();
	}

	@Override
	public void editar(Laudo l) {
		dao.editar(l);

	}

	@Override
	public void deletar(long idLaudo) {
		dao.deletar(idLaudo);

	}

	@Override
	public Laudo listarPeloId(long idLaudo) {
		return dao.listarPeloId(idLaudo);
	}
	

	@Override
	public Laudo listarPeloIdMedico(long idMedico) {
		return dao.listarPeloIdMedico(idMedico);
	}

	@Override
	public void limparLista() {
		dao.limparLista();
		
	}

}