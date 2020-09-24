package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;

public class AnexoExcluirDAO implements ExcluirDAO {
	@Override
    public void excluir(int value) throws SQLException{
	   try(
				Connection conn = ConnectionDAO.getInstance().getConnection();
				Statement stmt = conn.createStatement();
			)
		{
			stmt.execute("DELETE FROM anexos WHERE idanexo=" + String.valueOf(value));
		}
    }
}
