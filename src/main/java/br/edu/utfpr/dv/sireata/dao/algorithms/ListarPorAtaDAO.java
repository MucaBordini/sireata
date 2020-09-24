package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.SQLException;
import java.util.List;

import br.edu.utfpr.dv.sireata.model.EntityDAO;

public interface ListarPorAtaDAO {

	public List<EntityDAO> listarPorAta(int value) throws SQLException;
	
}
