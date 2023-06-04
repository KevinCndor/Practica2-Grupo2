package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public class ProductosController implements Serializable {
/*
    SessionFactory sessionFactory = new
            Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ProductoEntity.class).buildSessionFactory();
    Session session = sessionFactory.openSession();


    public String createProducto(String codigo, String distribuidor, String nombre, Double precio, Integer unidades){

        try {
            ProductoEntity producto = new ProductoEntity(codigo,distribuidor,nombre,precio,unidades);
            session.beginTransaction();
            session.persist(producto);
            session.getTransaction().commit();
            return "Producto Registrado con Exito!";
        }catch (Exception e){
            System.out.println(e);
        }
        return "Error al registrar producto";
    }

    public String updateProducto(String codigo, Integer unidades){

        try {
            session.beginTransaction();
            ProductoEntity producto = session.get(ProductoEntity.class,codigo);
            producto.setUnidades(unidades);
            session.update(producto);
            session.getTransaction().commit();
            return "Producto actualizado con éxito";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al actualizar unidades";
    }

    public String readOneProducto(String codigo){
        try {
            session.beginTransaction();
            ProductoEntity producto = session.get(ProductoEntity.class,codigo);
            session.getTransaction().commit();
            return producto.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al buscar producto";
    }

    public List<ProductoEntity> readProduct(){
        try {
            List<ProductoEntity> listaProductos =
                    session.createQuery("Select p from ProductoEntity p ORDER BY id").getResultList();
            return  listaProductos;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("minimarket");
    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("minimarket");;
    private EntityManager em = emf.createEntityManager();

    public void cerrarConexion() {
        em.close();
        emf.close();
    }

    public void createProducto(ProductoEntity producto) {
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO producto (codigo, distribuidor, nombre, precio, unidades) VALUES (?, ?, ?, ?, ?)")
                .setParameter(1, producto.getCodigo())
                .setParameter(2, producto.getDistribuidor())
                .setParameter(3, producto.getNombre())
                .setParameter(4, producto.getPrecio())
                .setParameter(5, producto.getUnidades())
                .executeUpdate();
        em.getTransaction().commit();
    }

/*
    public void crearProducto(ProductoEntity producto) {
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
    }
*/
    public ProductoEntity leerProducto(String codigo) {
        return em.find(ProductoEntity.class, codigo);
    }

    public void actualizarProducto(ProductoEntity producto) {
        em.getTransaction().begin();
        em.merge(producto);
        em.getTransaction().commit();
    }

    public void eliminarProducto(ProductoEntity producto) {
        em.getTransaction().begin();
        em.remove(producto);
        em.getTransaction().commit();
    }

    public List<ProductoEntity> listarProductos() {
        return em.createQuery("SELECT e FROM ProductoEntity e ORDER BY id", ProductoEntity.class).getResultList();
    }

}
