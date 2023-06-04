package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.DetalleventaEntity;


import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class DetalleVentaController implements Serializable {

    private EntityManagerFactory emf = createEntityManagerFactory("minimarket");
    private EntityManager em = emf.createEntityManager();

    public void createDetalleVenta(DetalleventaEntity detalleventa) {
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO detalleventa (codigoventa, cantidad, nombreprod, precio) VALUES (?, ?, ?, ?)")
                .setParameter(1, detalleventa.getCodigoventa())
                .setParameter(2, detalleventa.getCantidad())
                .setParameter(3, detalleventa.getNombreprod())
                .setParameter(4, detalleventa.getPrecio())
                .executeUpdate();
        em.getTransaction().commit();
    }

    public DetalleventaEntity leerDetallesVenta(String codigo) {
        return em.find(DetalleventaEntity.class, codigo);
    }


    public List<DetalleventaEntity> listarDetalleVenta() {
        return em.createQuery("SELECT e FROM DetalleventaEntity e ORDER BY id", DetalleventaEntity.class).getResultList();
    }

}
