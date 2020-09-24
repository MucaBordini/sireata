package br.edu.utfpr.dv.sireata.bo;

import java.util.List;

import br.edu.utfpr.dv.sireata.dao.PautaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.pauta.PautaBuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.pauta.PautaCarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.pauta.PautaExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.pauta.PautaListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.pauta.PautaSalvarDAO;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class PautaBO {
	
	private PautaDAO pautaDAO;

    public PautaBO() {
        pautaDAO = new PautaDAO(
                new PautaBuscarPorIdDAO(),
                new PautaCarregarObjetoDAO(),
                new PautaExcluirDAO(),
                new PautaListarPorAtaDAO(),
                new PautaSalvarDAO());
    }

    public Pauta buscarPorId(int id) throws Exception {
        return (Pauta) pautaDAO.buscar(id);
    }

    public List<Pauta> listarPorAta(int idAta) throws Exception {
        return pautaDAO.listar(idAta);
    }

    public void validarDados(Pauta pauta) throws Exception{
		if(pauta.getTitulo().isEmpty()){
			throw new Exception("Informe o título da pauta.");
		}
	}

    public int salvar(Pauta pauta) throws Exception {
        return pautaDAO.salvar(pauta);
    }

    public void excluir(Pauta pauta) throws Exception {
        pautaDAO.excluir(pauta.getIdPauta());
    }

    public void excluir(int id) throws Exception {
        pautaDAO.excluir(id);
	}

}
