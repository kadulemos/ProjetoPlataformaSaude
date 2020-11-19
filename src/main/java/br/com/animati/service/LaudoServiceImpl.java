package br.com.animati.service;

import java.util.List;

import br.com.animati.dao.LaudoDAO;
import br.com.animati.dao.LaudoDAOImpl;
import br.com.animati.entity.Laudo;

public class LaudoServiceImpl implements LaudoSevice {
	
	private LaudoDAO dao;

	@Override
	public void cadastrar(Laudo l) {
		dao = new LaudoDAOImpl();

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

}