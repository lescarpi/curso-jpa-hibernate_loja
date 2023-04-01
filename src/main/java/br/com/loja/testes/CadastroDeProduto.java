package br.com.loja.testes;

import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Produto celular = new Produto();
        celular.setNome("Xiaomi REDMI 9");
        celular.setDescricao("Legal");
        celular.setPreco(new BigDecimal("2200"));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }

}
