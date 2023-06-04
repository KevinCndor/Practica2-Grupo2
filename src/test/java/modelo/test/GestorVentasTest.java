package modelo.test;

import modelo.GestorVentas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class GestorVentasTest {

    String cedula;
    Date fecha;
    double total;

    @Parameterized.Parameters
    public static Iterable<Object[]> Parametros(){
        List<Object[]> listaProd = new ArrayList<Object[]>();
        listaProd.add(new Object[]{"1752123016",java.sql.Date.valueOf("2023-05-04"),4.00});
        listaProd.add(new Object[]{"1725665309",java.sql.Date.valueOf("2023-05-04"),2.50});
        listaProd.add(new Object[]{"1103360929",java.sql.Date.valueOf("2023-05-04"),4.00});
        return listaProd;
    }


    public GestorVentasTest(String cedula, Date fecha, double total) {
        this.cedula = cedula;
        this.fecha = fecha;
        this.total = total;
    }

    @Test
    public void given_parameters_when_register_sale_then_ok(){
        GestorVentas gv = new GestorVentas();
        boolean[] esperados = {true,true,true};
        assertArrayEquals(esperados,gv.comprobarCedulas(cedula,fecha,total));
    }
}