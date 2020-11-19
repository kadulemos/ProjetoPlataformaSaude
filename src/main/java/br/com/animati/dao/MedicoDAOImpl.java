package br.com.animati.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.animati.entity.Medico;

public class MedicoDAOImpl implements MedicoDAO {

	private List<Medico> listaMedicos;

	public MedicoDAOImpl() {
		listaMedicos = new ArrayList<Medico>();
	}

	@Override
	public void cadastrar(Medico m) {
		listaMedicos.add(m);

	}

	@Override
	public List<Medico> list() {
		return listaMedicos;
	}

	@Override
	public void editar(Medico m) {
		boolean encontrar = true;
		int indice = 0;

		do {
			if (listaMedicos.get(indice).getIdMedico() == m.getIdMedico()) {
				listaMedicos.set(indice, m);
				encontrar = false;
			}
			indice++;
		} while (encontrar);

	}

	@Override
	public void deletar(long idMedico) {
		boolean encontrar = true;
		int indice = 0;

		do {
			if(listaMedicos.get(indice).getIdMedico() == idMedico) {
				listaMedicos.remove(indice);
				encontrar = false;
			}
			indice++;
		} while(encontrar);
	}

	@Override
	public Medico listarPeloId(long idMedico) {
		Medico medicoEncontrado = null;
		boolean encontrar = true;
		int indice = 0;

		do {
			if(listaMedicos.get(indice).getIdMedico() == idMedico) {
				medicoEncontrado = listaMedicos.get(indice);
				encontrar = false;
			}
			indice++;
		} while (encontrar);
		return medicoEncontrado;
	}

	@Override
	public void limparLista() {
		listaMedicos.clear();
		
	}

}
