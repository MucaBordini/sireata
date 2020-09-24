package br.edu.utfpr.dv.sireata.dao.algorithms.pauta;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class PautaCarregarObjetoDAO implements CarregarObjetoDAO<Pauta> {
	@Override
	public Pauta carregarObjeto(ResultSet rs) throws SQLException{
		Pauta pauta = new Pauta();
		
		pauta.setIdPauta(rs.getInt("idPauta"));
		pauta.getAta().setIdAta(rs.getInt("idAta"));
		pauta.setOrdem(rs.getInt("ordem"));
		pauta.setTitulo(rs.getString("titulo"));
		pauta.setDescricao(rs.getString("descricao"));
		
		return pauta;
	}
}
