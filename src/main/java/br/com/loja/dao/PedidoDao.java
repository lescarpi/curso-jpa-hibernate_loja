package br.com.loja.dao;

import br.com.loja.modelo.Pedido;
import jakarta.persistence.EntityManager;

public class PedidoDao {

    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        em.persist(pedido);
    }

}
