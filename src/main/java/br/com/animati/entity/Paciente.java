package br.com.animati.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Paciente {

	private long idPaciente;
	private String empresa;
	private String nome;
	private String nomeSocial;
	private String nomeMae;
	private UfType uf;
	private String cpf;
	private String password;
	private String rg;
	private String sexo;

}
