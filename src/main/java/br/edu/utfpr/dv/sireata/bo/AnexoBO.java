package br.edu.utfpr.dv.sireata.bo;

import java.util.List;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoBuscaPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoCarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoSalvarDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoBO {

	private AnexoDAO anexoDAO;

    public AnexoBO() {
        anexoDAO = new AnexoDAO(
                new AnexoBuscaPorIdDAO(),
                new AnexoCarregarObjetoDAO(),
                new AnexoExcluirDAO(),
                new AnexoListarPorAtaDAO(),
                new AnexoSalvarDAO());
    }

    public Anexo buscarPorId(int id) throws Exception {
        return (Anexo) anexoDAO.buscar(id);
    }

    public List<Anexo> listarPorAta(int idAta) throws Exception {
        return anexoDAO.listar(idAta);
    }

    public void validarDados(Anexo anexo) throws Exception {
        if (anexo.getArquivo() == null) {
            throw new Exception("Efetue o envio do arquivo.");
        }
        if (anexo.getDescricao().isEmpty()) {
            throw new Exception("Informe a descrição do anexo.");
        }
    }

    public int salvar(Anexo anexo) throws Exception {
        return anexoDAO.salvar(anexo);
    }

    public void excluir(Anexo anexo) throws Exception {
        anexoDAO.excluir(anexo.getIdAnexo());
    }

    public void excluir(int id) throws Exception {
        anexoDAO.excluir(id);
	}

	
}
