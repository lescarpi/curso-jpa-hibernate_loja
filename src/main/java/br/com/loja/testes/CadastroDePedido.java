package br.com.loja.testes;

import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.PedidoDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import br.com.loja.vo.RelatorioDeVendasVo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CadastroDePedido {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(2L);

        em.getTransaction().begin();

        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(1L);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(15, produto, pedido));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();

        List<RelatorioDeVendasVo> listaRelatorio = pedidoDao.relatorioVendas();
        listaRelatorio.forEach(System.out::println);


    }

}
