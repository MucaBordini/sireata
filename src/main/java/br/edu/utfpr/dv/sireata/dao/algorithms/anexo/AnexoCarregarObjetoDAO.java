package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoCarregarObjetoDAO implements CarregarObjetoDAO<Anexo> {

	@Override
	public Anexo carregarObjeto(ResultSet rs) throws SQLException {
		Anexo anexo = new Anexo();
		
		anexo.setIdAnexo(rs.getInt("idAnexo"));
		anexo.getAta().setIdAta(rs.getInt("idAta"));
		anexo.setDescricao(rs.getString("descricao"));
		anexo.setOrdem(rs.getInt("ordem"));
		anexo.setArquivo(rs.getBytes("arquivo"));
		
		return (anexo);
	}

}
