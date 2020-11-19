package br.com.animati.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.animati.entity.Paciente;

public class PacienteDAOImpl implements PacienteDAO {

	private List<Paciente> listaPacientes;

	public PacienteDAOImpl() {
		listaPacientes = new ArrayList<Paciente>();
	}

	@Override
	public void cadastrar(Paciente p) {
		listaPacientes.add(p);

	}

	@Override
	public List<Paciente> list() {
		return listaPacientes;
	}

	@Override
	public void editar(Paciente p) {
		boolean encontrar = true;
		int indice = 0;

		do {
			if(listaPacientes.get(indice).getIdPaciente() == p.getIdPaciente()) {
				listaPacientes.set(indice, p);
				encontrar = false;
			}
			indice++;
		} while (encontrar);

	}

	@Override
	public void deletar(long idPaciente) {
		boolean encontrar = true;
		int indice = 0;

		do {
			if(listaPacientes.get(indice).getIdPaciente() == idPaciente) {
				listaPacientes.remove(indice);
				encontrar = false;
			}
			indice++;
		} while (encontrar);

	}

	@Override
	public Paciente listarPeloId(long idPaciente) {
		Paciente pacienteEncontrado = null;
		boolean encontrar = true;
		int indice = 0;
		
		do {
			if(listaPacientes.get(indice).getIdPaciente() == idPaciente) {
				pacienteEncontrado = listaPacientes.get(indice);
				encontrar = false;
			}
			indice++;
		} while(encontrar);
		return pacienteEncontrado;
	}

	@Override
	public void limparLista() {
		listaPacientes.clear();

	}

}
