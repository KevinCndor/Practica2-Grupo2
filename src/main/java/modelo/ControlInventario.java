package modelo;

public class ControlInventario {

    public int updateUnidadesProducto(ProductoEntity producto, int cantidad){
        return 0;
    }

    public boolean [] validarregistroProductor(String codigo, String distribuidor,String nombre, double precio,int unidades){
        boolean [] actuales = new boolean[5];
        ProductoEntity p = new ProductoEntity(codigo,distribuidor,nombre,precio,unidades);
        for(int i = 0 ; i < actuales.length ; i++){
            actuales [i] = true;
        }
        return actuales;
    }
}
