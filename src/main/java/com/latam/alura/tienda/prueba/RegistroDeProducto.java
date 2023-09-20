package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung", "Telefono usado", new BigDecimal("1000"), celulares);

		EntityManager em = JPAUtils.getEntityManager();

		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ProductoDAO productoDAO = new ProductoDAO(em);

		em.getTransaction().begin();
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		em.getTransaction().commit();
		em.close();

	}

}
