package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class PautaDAO extends FullDAO<Pauta>{
	
	BuscarPorIdDAO<Pauta> buscarPorIdDAO;
    CarregarObjetoDAO<Pauta> carregarObjetoDAO;
    ExcluirDAO excluirDAO;
    ListarPorAtaDAO<Pauta> listarPorAtaDAO;
    SalvarDAO<Pauta> salvarDAO;

   
    public PautaDAO (BuscarPorIdDAO<Pauta> buscar,
                    CarregarObjetoDAO<Pauta> carregar,
                    ExcluirDAO excluir,
                    ListarPorAtaDAO<Pauta> listar,
                    SalvarDAO<Pauta> salvar)
    {
   
        this.buscarPorIdDAO = buscar;
        this.carregarObjetoDAO = carregar;
        this.excluirDAO = excluir;
        this.listarPorAtaDAO = listar;
        this.salvarDAO = salvar;
    }
	
}
