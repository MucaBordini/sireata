package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.AtaParticipante;

public class AtaParticipanteDAO extends FullDAO<AtaParticipante>{
	
	BuscarPorIdDAO<AtaParticipante> buscarPorIdDAO;
    CarregarObjetoDAO<AtaParticipante> carregarObjetoDAO;
    ExcluirDAO excluirDAO;
    ListarPorAtaDAO<AtaParticipante> listarPorAtaDAO;
    SalvarDAO<AtaParticipante> salvarDAO;

   
    public AtaParticipanteDAO (BuscarPorIdDAO<AtaParticipante> buscar,
                    CarregarObjetoDAO<AtaParticipante> carregar,
                    ExcluirDAO excluir,
                    ListarPorAtaDAO<AtaParticipante> listar,
                    SalvarDAO<AtaParticipante> salvar)
    {
   
        this.buscarPorIdDAO = buscar;
        this.carregarObjetoDAO = carregar;
        this.excluirDAO = excluir;
        this.listarPorAtaDAO = listar;
        this.salvarDAO = salvar;
    }

}
