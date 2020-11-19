package br.com.animati.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Medico {

	private long idMedico;
	private String nome;
	private UfType uf;
	private String crm;
}