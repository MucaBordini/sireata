package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.SQLException;
import java.util.Set;

public interface BuscarPorIdDAO<T> {
	
	public Set<? extends T> buscarPorId(int value) throws SQLException;
	
}
