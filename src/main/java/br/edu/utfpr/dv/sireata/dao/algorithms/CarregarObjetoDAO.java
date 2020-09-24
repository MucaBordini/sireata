package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.sireata.model.EntityDAO;

public interface CarregarObjetoDAO {

	public EntityDAO carregarObjeto(ResultSet rs) throws SQLException;
	
}
