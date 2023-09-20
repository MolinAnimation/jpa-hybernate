package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Categoria categoria) {
        this.em.persist(categoria);
    }

}
