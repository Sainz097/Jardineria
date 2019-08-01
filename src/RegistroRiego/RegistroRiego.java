/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroRiego;

/**
 *
 * @author SAINZ
 */
public class RegistroRiego {
    
    String id_riego,fechariego,producto;

    public RegistroRiego(String id_riego, String fechariego, String producto) {
        this.id_riego = id_riego;
        this.fechariego = fechariego;
        this.producto = producto;
    }

    public String getId_riego() {
        return id_riego;
    }

    public void setId_riego(String id_riego) {
        this.id_riego = id_riego;
    }

    public String getFechariego() {
        return fechariego;
    }

    public void setFechariego(String fechariego) {
        this.fechariego = fechariego;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    
}
