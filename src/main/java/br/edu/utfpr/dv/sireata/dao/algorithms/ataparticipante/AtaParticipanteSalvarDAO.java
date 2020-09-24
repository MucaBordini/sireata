package br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;

public class AtaParticipanteSalvarDAO implements SalvarDAO<AtaParticipante>{

	@Override
    public int salvar(AtaParticipante newEntity) throws SQLException{
    
		AtaParticipante ataParticipante = (AtaParticipante) newEntity;
        
        boolean insert = (ataParticipante.getIdAtaParticipante() == 0);
        
		if(insert) {
			try(
					Connection conn = ConnectionDAO.getInstance().getConnection();
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO ataparticipantes(idAta, idUsuario, presente, motivo, designacao, membro) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				)
			{
				stmt.setInt(1, ataParticipante.getAta().getIdAta());
				stmt.setInt(2, ataParticipante.getParticipante().getIdUsuario());
				stmt.setInt(3, (ataParticipante.isPresente() ? 1 : 0));
				stmt.setString(4, ataParticipante.getMotivo());
				stmt.setString(5, ataParticipante.getDesignacao());
				stmt.setInt(6, (ataParticipante.isMembro() ? 1 : 0));
				stmt.execute();
				
				try(ResultSet rs = stmt.getGeneratedKeys();)
				{
					if(rs.next()){
						ataParticipante.setIdAtaParticipante(rs.getInt(1));
					}
				}
			}
		} else {
			try(
					Connection conn = ConnectionDAO.getInstance().getConnection();
					PreparedStatement stmt = conn.prepareStatement("UPDATE anexos SET idAta=?, ordem=?, descricao=?, arquivo=? WHERE idAnexo=?");
				)
			{
				stmt.setInt(1, ataParticipante.getAta().getIdAta());
				stmt.setInt(2, ataParticipante.getParticipante().getIdUsuario());
				stmt.setInt(3, (ataParticipante.isPresente() ? 1 : 0));
				stmt.setString(4, ataParticipante.getMotivo());
				stmt.setString(5, ataParticipante.getDesignacao());
				stmt.setInt(6, (ataParticipante.isMembro() ? 1 : 0));
				stmt.setInt(7, ataParticipante.getIdAtaParticipante());
				stmt.execute();
			}
		}
		
		return ataParticipante.getIdAtaParticipante();
	}
}
