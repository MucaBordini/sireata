package br.edu.utfpr.dv.sireata.dao.algorithms.pauta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;

public class PautaExcluirDAO implements ExcluirDAO {
	@Override
    public void excluir(int value) throws SQLException{
	   try(
				Connection conn = ConnectionDAO.getInstance().getConnection();
				Statement stmt = conn.createStatement();
			)
		{
			stmt.execute("DELETE FROM pautas WHERE idPauta=" + String.valueOf(value));
		}
    }
}
