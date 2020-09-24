package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoListarPorAtaDAO implements ListarPorAtaDAO<Anexo> {
	
	@Override
    public List<Anexo> listarPorAta(int value) throws SQLException{
            
		AnexoCarregarObjetoDAO anexoCarregarObjeto;
	    anexoCarregarObjeto = new AnexoCarregarObjetoDAO();
	            
		try(
				Connection conn = ConnectionDAO.getInstance().getConnection();
				Statement stmt = conn.createStatement();
			)
		{
		
			try(ResultSet rs = stmt.executeQuery("SELECT anexos.* FROM anexos " +
					"WHERE idAta=" + String.valueOf(value) + " ORDER BY anexos.ordem");)
			{
				List<Anexo> list = new ArrayList<Anexo>();
				
				while(rs.next()){
		                        list.add((Anexo) anexoCarregarObjeto.carregarObjeto(rs));
				}
				
				return list;
			}
		}
    }
}
