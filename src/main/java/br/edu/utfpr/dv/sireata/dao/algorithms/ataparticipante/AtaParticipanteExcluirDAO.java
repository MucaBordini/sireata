package br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;

public class AtaParticipanteExcluirDAO implements ExcluirDAO {
	@Override
    public void excluir(int value) throws SQLException{
	   try(
				Connection conn = ConnectionDAO.getInstance().getConnection();
				Statement stmt = conn.createStatement();
			)
		{
			stmt.execute("DELETE FROM ataparticipantes WHERE idAtaParticipante=" + String.valueOf(value));
		}
    }
}
