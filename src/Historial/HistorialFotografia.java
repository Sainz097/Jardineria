/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Historial;

/**
 *
 * @author SAINZ
 */
public class HistorialFotografia {
        String id_historial,fechahistorial,fotografia;
        public HistorialFotografia(String id_historial, String fechahistorial,String fotografia) {
        this.id_historial = id_historial;
        this.fotografia = fotografia;
        this.fechahistorial = fechahistorial;
    }
    
    public String getId_historial() {
        return id_historial;
    }

    public void setId_historial(String id_historial) {
        this.id_historial = id_historial;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getFechahistorial() {
        return fechahistorial;
    }

    public void setFechahistorial(String fechahistorial) {
        this.fechahistorial = fechahistorial;
    }
}
