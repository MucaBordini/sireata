package br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;

public class AtaParticipanteCarregarObjetoDAO implements CarregarObjetoDAO<AtaParticipante>{
	@Override
	public AtaParticipante carregarObjeto(ResultSet rs) throws SQLException{
		AtaParticipante participante = new AtaParticipante();
		
		participante.setIdAtaParticipante(rs.getInt("idAtaParticipante"));
		participante.getAta().setIdAta(rs.getInt("idAta"));
		participante.getParticipante().setIdUsuario(rs.getInt("idUsuario"));
		participante.getParticipante().setNome(rs.getString("nomeParticipante"));
		participante.setPresente(rs.getInt("presente") == 1);
		participante.setMotivo(rs.getString("motivo"));
		participante.setDesignacao(rs.getString("designacao"));
		participante.setMembro(rs.getInt("membro") == 1);
		
		return participante;
	}
}
