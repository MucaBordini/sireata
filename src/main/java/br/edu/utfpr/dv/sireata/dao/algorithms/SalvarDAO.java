package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.SQLException;

public interface SalvarDAO <T>{

	public int salvar(T newEntity) throws SQLException;
	
}
