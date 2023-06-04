package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import modelo.VentaEntity;


import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;


public class VentaController implements Serializable {
    private EntityManagerFactory emf = createEntityManagerFactory("minimarket");
    private EntityManager em = emf.createEntityManager();

    public void cerrarConexion() {
        em.close();
        emf.close();
    }

    public boolean createVenta(VentaEntity venta) {
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO venta (cicliente, fecha, total) VALUES (?, ?, ?)")
                .setParameter(1, venta.getCicliente())
                .setParameter(2, venta.getFecha())
                .setParameter(3, venta.getTotal())
                .executeUpdate();
        em.getTransaction().commit();
        return true;
    }

    public VentaEntity leerProducto(String codigo) {
        return em.find(VentaEntity.class, codigo);
    }

    public List<VentaEntity> listarVentas() {
        return em.createQuery("SELECT e FROM VentaEntity e ORDER BY id", VentaEntity.class).getResultList();
    }

    public VentaEntity readLastVenta() {
        TypedQuery<VentaEntity> query =
                em.createQuery("SELECT e FROM VentaEntity e WHERE e.id = (SELECT MAX(v.id) FROM VentaEntity v)", VentaEntity.class);
        return query.getSingleResult();
    }


}
