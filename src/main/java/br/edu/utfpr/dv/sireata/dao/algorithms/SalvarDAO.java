package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.SQLException;

import br.edu.utfpr.dv.sireata.model.EntityDAO;

public interface SalvarDAO {

	public int salvar(EntityDAO newEntity) throws SQLException;
	
}
