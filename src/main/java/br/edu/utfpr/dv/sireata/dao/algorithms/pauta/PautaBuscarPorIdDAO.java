package br.edu.utfpr.dv.sireata.dao.algorithms.pauta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class PautaBuscarPorIdDAO implements BuscarPorIdDAO<Pauta> {
	@Override
    public Set<? extends Pauta> buscarPorId(int value) throws SQLException{
   
	    PautaCarregarObjetoDAO pautaCarregarObjeto;
	    pautaCarregarObjeto = new PautaCarregarObjetoDAO();
	    
		try (
				Connection conn = ConnectionDAO.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pautas WHERE idPauta = ?");
			)
		{
		
			stmt.setInt(1, value);
			try(ResultSet rs = stmt.executeQuery();)
			{
				if(rs.next()){
					return (Set<? extends Pauta>)pautaCarregarObjeto.carregarObjeto(rs);
				}else{
					return null;
				}
			}
		}
    }
}
