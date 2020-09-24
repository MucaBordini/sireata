package br.edu.utfpr.dv.sireata.dao.algorithms.pauta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class PautaSalvarDAO implements SalvarDAO<Pauta>{

	@Override
    public int salvar(Pauta newEntity) throws SQLException{
    
        Pauta pauta = (Pauta) newEntity;
        
        boolean insert = (pauta.getIdPauta() == 0);
        
		if(insert) {
			try(
					Connection conn = ConnectionDAO.getInstance().getConnection();
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO pautas(idAta, ordem, titulo, descricao) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				)
			{
				stmt.setInt(1, pauta.getAta().getIdAta());
				stmt.setInt(2, pauta.getOrdem());
				stmt.setString(3, pauta.getTitulo());
				stmt.setString(4, pauta.getDescricao());
				stmt.execute();
				try(ResultSet rs = stmt.getGeneratedKeys();)
				{
					if(rs.next()){
						pauta.setIdPauta(rs.getInt(1));
					}
				}
			}
		} else {
			try(
					Connection conn = ConnectionDAO.getInstance().getConnection();
					PreparedStatement stmt = conn.prepareStatement("UPDATE pautas SET idAta=?, ordem=?, titulo=?, descricao=? WHERE idPauta=?");
				)
			{
				stmt.setInt(1, pauta.getAta().getIdAta());
				stmt.setInt(2, pauta.getOrdem());
				stmt.setString(3, pauta.getTitulo());
				stmt.setString(4, pauta.getDescricao());
				stmt.setInt(5, pauta.getIdPauta());
				stmt.execute();
			}
		}
		
		return pauta.getIdPauta();
	}
}
