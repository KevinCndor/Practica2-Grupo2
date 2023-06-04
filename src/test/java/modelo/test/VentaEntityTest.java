package modelo.test;


import modelo.VentaEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VentaEntityTest {

    @Test
    public void given_letters_in_CI_when_register_sale_then_error(){
        VentaEntity v = new VentaEntity("175s422321",java.sql.Date.valueOf("2023-05-04"),3.50);
        boolean condicion = v.verificarCedula(v.getCicliente());
        assertFalse(condicion);
    }

    @Test
    public void given_ecuadorian_CI_when_register_sale_then_ok(){
        VentaEntity v = new VentaEntity("1752123016",java.sql.Date.valueOf("2023-05-04"),4.00);
        boolean condicion = v.esCedulaEcuatoriana(v.getCicliente());
        assertTrue(condicion);
    }

}