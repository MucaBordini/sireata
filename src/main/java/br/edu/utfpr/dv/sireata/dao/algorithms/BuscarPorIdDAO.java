package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.SQLException;
import java.util.Set;

import br.edu.utfpr.dv.sireata.model.EntityDAO;

public interface BuscarPorIdDAO {
	
	public Set<? extends EntityDAO> buscarPorId(int value) throws SQLException;
	
}
