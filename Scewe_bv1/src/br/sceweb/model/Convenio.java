package br.sceweb.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Convenio {
	/**
	* valida o formato da data
	* @param data no formato dd/MM/yyyy
	* @return true se a data estiver no formato valido e false para formato invalido
	*/
	public boolean validaData(String data){
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false); //
		try {
			df.parse (data); // data válida
			return true;
		} catch (ParseException ex) {
			System.out.println("Erro na validacao de data - " + ex.getMessage());
			return false;
		}
	}
}
