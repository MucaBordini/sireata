package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoSalvarDAO implements SalvarDAO<Anexo>{

	@Override
    public int salvar(Anexo newEntity) throws SQLException{
    
        Anexo anexo = (Anexo) newEntity;
        
        boolean insert = (anexo.getIdAnexo() == 0);
        
		if(insert) {
			try(
					Connection conn = ConnectionDAO.getInstance().getConnection();
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO anexos(idAta, ordem, descricao, arquivo) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				)
			{
				stmt.setInt(1, anexo.getAta().getIdAta());
				stmt.setInt(2, anexo.getOrdem());
				stmt.setString(3, anexo.getDescricao());
				stmt.setBytes(4, anexo.getArquivo());
				stmt.execute();
				try(ResultSet rs = stmt.getGeneratedKeys();)
				{
					if(rs.next()){
						anexo.setIdAnexo(rs.getInt(1));
					}
				}
			}
		} else {
			try(
					Connection conn = ConnectionDAO.getInstance().getConnection();
					PreparedStatement stmt = conn.prepareStatement("UPDATE anexos SET idAta=?, ordem=?, descricao=?, arquivo=? WHERE idAnexo=?");
				)
			{
				stmt.setInt(1, anexo.getAta().getIdAta());
				stmt.setInt(2, anexo.getOrdem());
				stmt.setString(3, anexo.getDescricao());
				stmt.setBytes(4, anexo.getArquivo());
				stmt.setInt(5, anexo.getIdAnexo());
				stmt.execute();
			}
		}
		
		return anexo.getIdAnexo();
	}
}

