package br.edu.utfpr.dv.sireata.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;

public abstract class FullDAO<T> {
	protected BuscarPorIdDAO<T> buscarPorIdDAO;
    protected CarregarObjetoDAO<T> carregarObjetoDAO;
    protected ListarPorAtaDAO<T> listarPorAtaDAO;
    protected SalvarDAO<T> salvarDAO;
    protected ExcluirDAO excluirDAO;
    
    public Set<? extends T> buscar(int value) throws SQLException {
        return buscarPorIdDAO.buscarPorId(value);
    }
    
    public T carregarObjeto(ResultSet rs) throws SQLException {
        return carregarObjetoDAO.carregarObjeto(rs);
    }
    
    public List<T> listar(int value) throws SQLException {
        return listarPorAtaDAO.listarPorAta(value);
    }

    public int salvar(T newEntity) throws SQLException {
        return salvarDAO.salvar(newEntity);
    }

    public void excluir(int value) throws SQLException {
        excluirDAO.excluir(value);
    }
}
