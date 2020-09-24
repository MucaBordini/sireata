package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface CarregarObjetoDAO<T> {

	public T carregarObjeto(ResultSet rs) throws SQLException;
	
}
