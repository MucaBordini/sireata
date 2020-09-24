package br.edu.utfpr.dv.sireata.bo;

import java.util.List;

import br.edu.utfpr.dv.sireata.dao.AtaParticipanteDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante.AtaParticipanteBuscaPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante.AtaParticipanteCarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante.AtaParticipanteExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante.AtaParticipanteListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ataparticipante.AtaParticipanteSalvarDAO;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;

public class AtaParticipanteBO {
	
	private AtaParticipanteDAO ataParticipanteDAO;

    public AtaParticipanteBO() {
    	ataParticipanteDAO = new AtaParticipanteDAO(
                new AtaParticipanteBuscaPorIdDAO(),
                new AtaParticipanteCarregarObjetoDAO(),
                new AtaParticipanteExcluirDAO(),
                new AtaParticipanteListarPorAtaDAO(),
                new AtaParticipanteSalvarDAO());
    }

    public AtaParticipante buscarPorId(int id) throws Exception {
        return (AtaParticipante) ataParticipanteDAO.buscar(id);
    }

    public List<AtaParticipante> listarPorAta(int idAta) throws Exception {
        return ataParticipanteDAO.listar(idAta);
    }

    public void validarDados(AtaParticipante participante) throws Exception{
		if((participante.getParticipante() == null) || (participante.getParticipante().getIdUsuario() == 0)){
			throw new Exception("Informe o usuário.");
		}
		if((!participante.isPresente()) && (participante.getMotivo().trim().isEmpty())){
			throw new Exception("Informe o motivo da ausência.");
		}
		if(participante.isPresente()){
			participante.setMotivo("");
		}
	}

    public int salvar(AtaParticipante ataParticipante) throws Exception {
        return ataParticipanteDAO.salvar(ataParticipante);
    }

    public void excluir(AtaParticipante ataParticipante) throws Exception {
    	ataParticipanteDAO.excluir(ataParticipante.getIdAtaParticipante());
    }

    public void excluir(int id) throws Exception {
    	ataParticipanteDAO.excluir(id);
	}


}
