package modelo.test;

import modelo.ControlInventario;
import modelo.ProductoEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ControlInventarioTest {
    String codigo;
    String distribuidor;
    String nombre;
    double precio;
    int unidades;

    @Test
    public void given_product_sold_when_register_sale_then_update_stock(){
        ProductoEntity p = new ProductoEntity("00014","Coca - Cola","Jugos del Valle(Durazno)",
                0.5,20);
        ControlInventario control = Mockito.mock(ControlInventario.class);

        Mockito.when(control.updateUnidadesProducto(p,2)).thenReturn(18);

        assertEquals(18,control.updateUnidadesProducto(p,2));
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> Parametros(){
        List<Object[]> listaProd = new ArrayList<Object[]>();
        listaProd.add(new Object[]{"00014","Coca - Cola","Jugos del Valle(Durazno)", 0.8,20});
        listaProd.add(new Object[]{"00015","Frito Lay","Platanitos", 0.6,20});
        listaProd.add(new Object[]{"00016","Nestle","Chocolate", 0.8,20});
        return listaProd;
    }

    public ControlInventarioTest(String codigo, String distribuidor, String nombre, double precio, int unidades) {
        this.codigo = codigo;
        this.distribuidor = distribuidor;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    @org.junit.Test
    public void given_parameters_when_register_product_then_ok(){
        ControlInventario c = new ControlInventario();
        boolean[] esperados = {true,true,true,true,true};
        assertArrayEquals(esperados,c.validarregistroProductor(codigo,distribuidor,nombre,precio,unidades));
    }
}