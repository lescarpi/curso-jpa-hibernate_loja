package br.com.loja.testes;

import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BuscaDeProduto {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        ProdutoDao produtoDao = new ProdutoDao(em);

        List<Produto> lista = produtoDao.buscarPorParametro("", null, LocalDate.of(2023,04,01));

        lista.forEach(produto -> System.out.println(produto.getNome()));

    }

}
