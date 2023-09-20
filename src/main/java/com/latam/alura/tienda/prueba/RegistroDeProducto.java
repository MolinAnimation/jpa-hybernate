package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		// crea la instancia de la entidad producto con sus respectivos atributos
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Telefono usado");
		celular.setPrecio(new BigDecimal("1000"));

		EntityManager em = JPAUtils.getEntityManager();

		ProductoDAO productoDAO = new ProductoDAO(em);
		em.getTransaction().begin();

		productoDAO.guardar(celular);
		em.getTransaction().commit();
		em.close();

	}

}
