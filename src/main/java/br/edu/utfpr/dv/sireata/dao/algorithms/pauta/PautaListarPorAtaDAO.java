package br.edu.utfpr.dv.sireata.dao.algorithms.pauta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class PautaListarPorAtaDAO implements ListarPorAtaDAO<Pauta> {
	
	@Override
    public List<Pauta> listarPorAta(int value) throws SQLException{
            
		PautaCarregarObjetoDAO pautaCarregarObjeto;
	    pautaCarregarObjeto = new PautaCarregarObjetoDAO();
	            
		try(
				Connection conn = ConnectionDAO.getInstance().getConnection();
				Statement stmt = conn.createStatement();
			)
		{
		
			try(ResultSet rs = stmt.executeQuery("SELECT * FROM pautas WHERE idAta=" + String.valueOf(value) + " ORDER BY ordem");)
			{
				List<Pauta> list = new ArrayList<Pauta>();
				
				while(rs.next()){
		                        list.add((Pauta) pautaCarregarObjeto.carregarObjeto(rs));
				}
				
				return list;
			}
		}
    }
}
