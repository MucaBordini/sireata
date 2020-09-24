package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoCarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoBuscaPorIdDAO implements BuscarPorIdDAO<Anexo> {
	@Override
    public Set<? extends Anexo> buscarPorId(int value) throws SQLException{
   
	    AnexoCarregarObjetoDAO anexoCarregarObjeto;
	    anexoCarregarObjeto = new AnexoCarregarObjetoDAO();
	    
		try (
				Connection conn = ConnectionDAO.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT anexos.* FROM anexos " +
						"WHERE idAnexo = ?");
			)
		{
		
			stmt.setInt(1, value);
			try(ResultSet rs = stmt.executeQuery();)
			{
				if(rs.next()){
					return (Set<? extends Anexo>)anexoCarregarObjeto.carregarObjeto(rs);
				}else{
					return null;
				}
			}
		}
    }
}
