package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        List<Produto> produtoList = produtoDao.buscarPorNomeDaCategoria("Celulares");
        produtoList.forEach(p -> System.out.print(p.getNome() + "\n"));
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Xiaomi REDMI 9", "Legal", new BigDecimal("2200"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDAO = new CategoriaDao(em);

        Cliente cliente = new Cliente("Lucas", "52386432175");
        ClienteDao clienteDao = new ClienteDao(em);
        clienteDao.cadastrar(cliente);

        em.getTransaction().begin();

        categoriaDAO.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }

}
