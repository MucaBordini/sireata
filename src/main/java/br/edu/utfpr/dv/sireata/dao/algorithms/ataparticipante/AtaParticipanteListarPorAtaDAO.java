package br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;

public class AtaParticipanteListarPorAtaDAO implements ListarPorAtaDAO<AtaParticipante> {
	
	@Override
    public List<AtaParticipante> listarPorAta(int value) throws SQLException{
            
		AtaParticipanteCarregarObjetoDAO ataParticipanteCarregarObjeto;
		ataParticipanteCarregarObjeto = new AtaParticipanteCarregarObjetoDAO();
	            
		try(
				Connection conn = ConnectionDAO.getInstance().getConnection();
				Statement stmt = conn.createStatement();
			)
		{
		
			try(ResultSet rs = stmt.executeQuery("SELECT ataparticipantes.*, usuarios.nome AS nomeParticipante FROM ataparticipantes " +
					"INNER JOIN usuarios ON usuarios.idUsuario=ataparticipantes.idUsuario " + 
					"WHERE idAta=" + String.valueOf(value) + " ORDER BY usuarios.nome");)
			{
				List<AtaParticipante> list = new ArrayList<AtaParticipante>();
				
				while(rs.next()){
		                        list.add((AtaParticipante) ataParticipanteCarregarObjeto.carregarObjeto(rs));
				}
				
				return list;
			}
		}
    }
}
