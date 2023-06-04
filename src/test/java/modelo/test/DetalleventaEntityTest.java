package modelo.test;

import modelo.DetalleventaEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DetalleventaEntityTest {


    @Test
    public void given_wrong_name_when_buy_a_product_then_error(){
        DetalleventaEntity dv = new DetalleventaEntity(12,2,"Dortos",0.6);
        boolean verifyName = dv.verificarNombreProd(12,"Doritos");
        assertFalse(verifyName);
    }

    @Test
    public void given_negative_quantity_when_buy_a_product_then_error(){
        DetalleventaEntity dv = new DetalleventaEntity(12,-2,"Papas",0.6);
        assertTrue(dv.getCantidad() > 0);
    }

    @Test
    public void given_product_add_when_purchase_being_made_then_shopping_car_displayed(){
        DetalleventaEntity dv = Mockito.mock(DetalleventaEntity.class);
        List<DetalleventaEntity> listaDetalles = new ArrayList<>();

        DetalleventaEntity detalleventa1 = new DetalleventaEntity(2,2,"Doritos",0.6);
        DetalleventaEntity detalleventa2 = new DetalleventaEntity(2,1,"Chocolate",1);

        listaDetalles.add(detalleventa1);
        listaDetalles.add(detalleventa2);

        Mockito.when(dv.verCarrito(2)).thenReturn(listaDetalles);

        assertEquals(listaDetalles,dv.verCarrito(2));

        System.out.println("Carrito de Compra");
        System.out.println(detalleventa1.getCodigoventa() + " " + detalleventa1.getNombreprod() + " " + detalleventa1.getPrecio());
        System.out.println(detalleventa2.getCodigoventa() + " " + detalleventa2.getNombreprod() + " " + detalleventa2.getPrecio());

    }

}