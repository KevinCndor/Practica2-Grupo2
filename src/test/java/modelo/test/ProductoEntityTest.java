package modelo.test;

import modelo.ProductoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoEntityTest{

    @Test
    public void given_negative_prices_when_register_product_then_error(){
        ProductoEntity p = new ProductoEntity("00014","Coca - Cola","Jugos del Valle(Durazno)",
                -0.5,20);
        assertTrue(p.getPrecio() > 0);
    }

    @Test
    public void given_negative_units_when_product_register_then_error(){
        ProductoEntity p = new ProductoEntity("00014","Coca - Cola","Jugos del Valle(Durazno)",
                0.5,-20);
        assertTrue(p.getUnidades() > 0);
    }

    @Test
    public void given_new_name_when_update_product_then_error(){
        ProductoEntity p = new ProductoEntity("00014","Coca - Cola","Juegos del Valle(Durazno)",
                0.5,20);
        p.actualizarNombreProducto("00014","Jugos del Valle(Durazno)");
        assertEquals("Jugos del Valle(Durazno)", p.getNombre());
    }

    @Test
    public void given_new_price_when_update_product_then_error(){
        ProductoEntity p = new ProductoEntity("00014","Coca - Cola","Jugos del Valle(Durazno)",
                0.8,20);
        p.actualizarPrecioProducto("00014",0.5);
        assertEquals(0.5,p.getPrecio());
    }

}