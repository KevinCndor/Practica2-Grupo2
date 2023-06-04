package modelo;

import java.sql.Date;

public class GestorVentas {

    public GestorVentas() {
    }

    public boolean[] comprobarCedulas(String cedula, Date fecha, double total){
        boolean [] esvalido = new boolean[3];
        VentaEntity v = new VentaEntity(cedula,fecha,total);
        if(v.esCedulaEcuatoriana(cedula)){
            esvalido[0] = true;
            esvalido[1] = true;
            esvalido[2] = true;
        }else{
            esvalido[0] = false;
            esvalido[1] = false;
            esvalido[2] = false;
        }
        return esvalido;
    }

}
