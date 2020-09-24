package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.SQLException;
import java.util.List;

public interface ListarPorAtaDAO<T> {

	public List<T> listarPorAta(int value) throws SQLException;
	
}
