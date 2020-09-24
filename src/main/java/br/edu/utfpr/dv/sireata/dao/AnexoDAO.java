package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoDAO extends FullDAO<Anexo>{
	
	BuscarPorIdDAO<Anexo> buscarPorIdDAO;
    CarregarObjetoDAO<Anexo> carregarObjetoDAO;
    ExcluirDAO excluirDAO;
    ListarPorAtaDAO<Anexo> listarPorAtaDAO;
    SalvarDAO<Anexo> salvarDAO;

   
    public AnexoDAO(BuscarPorIdDAO<Anexo> buscar,
                    CarregarObjetoDAO<Anexo> carregar,
                    ExcluirDAO excluir,
                    ListarPorAtaDAO<Anexo> listar,
                    SalvarDAO<Anexo> salvar)
    {
   
        this.buscarPorIdDAO = buscar;
        this.carregarObjetoDAO = carregar;
        this.excluirDAO = excluir;
        this.listarPorAtaDAO = listar;
        this.salvarDAO = salvar;
    }

}
