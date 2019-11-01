/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Grafica.Controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;


import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author JUAN DAVID REYES
 *  @author ALEJANDRO TORRES
 */
@Named(value = "estadistica")
@SessionScoped
public class Estadistica implements Serializable {
    /**
     * permite pintar la grafica
     */
    private PieChartModel pieModel1;
    /**
     * votos de la banda 1
     */
    
    int voto1=0;
    /**
     * votos de la banda 2
     */
    int voto2=0;
    /**
     * votos de la banda 3
     */
    int voto3=0;
   
    /**
     * retorna los votos de la banda 1
     * @return 
     */
    public int getVoto1() {
        return voto1;
    }
    /**
     * parametro con los votos de la vanda 1
     * @param voto1 
     */
    public void setVoto1(int voto1) {
        this.voto1 = voto1;
    }
    /**
     * retorna los votos de la banda 2
     * @return 
     */
    public int getVoto2() {
        return voto2;
    }
    /**
     * parametro de votos de la banda 2
     * @param voto2 
     */
    public void setVoto2(int voto2) {
        this.voto2 = voto2;
    }
    /**
     * retorrna los votos de la banda 3
     * @return 
     */
    public int getVoto3() {
        return voto3;
    }
    /**
     * parametro con los votos de la banda 3
     * @param voto3 
     */
    public void setVoto3(int voto3) {
        this.voto3 = voto3;
    }
    /**
     * retorna el diagramaque se pinta
     * @return 
     */
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    /**
     * parametro de el diagrama que se va a pintar en pantalla
     * @param pieModel1 
     */
    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }
    /**
     * constructor de la clase 
     */
 
    @PostConstruct
    public void init() {    
         mostrar();        
    }
    /**
     * metodo vacio que aumenta los votos de la banda 1
     */
    public void votosCandidato1(){
       setVoto1(getVoto1()+1);

   }
    /**
     * metodo vacio que aumenta los datos de la banda 2
     */
   public void votosCandidato2(){
       setVoto2(getVoto2()+1);

   }
   /**
    * metodo vacio que aumenta los datos de la banda 3
    */
    public void votosCandidato3(){
       setVoto3(getVoto3()+1);

   }
    /**
     * metodo que muestra la grafica en pantalla
     */
    public void mostrar() {
        pieModel1 = new PieChartModel();
        pieModel1.set("Metallica", getVoto1());
        pieModel1.set("AC-DC ", getVoto2());
        pieModel1.set("IMAGINE DRAGONS", getVoto3());
        pieModel1.setTitle("ESTADISTICAS");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
    /**
     * metodo vacio que indica quien es el ganador de la votacion
     * y contiene todo lo de el boton finalizar
     */
    public void fin(){
        if((getVoto1()>getVoto2())&&(getVoto1()>getVoto3())){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "METALLICA GANA");       
        PrimeFaces.current().dialog().showMessageDynamic(message);
        }else if((getVoto2()>getVoto1())&&(getVoto2()>getVoto3())){
              FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "AC-DC GANA");       
        PrimeFaces.current().dialog().showMessageDynamic(message);
            
        }else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "IMAGINE DRAGONS GANA");       
        PrimeFaces.current().dialog().showMessageDynamic(message);
                }
        
        if((getVoto1()== getVoto2()) && (getVoto1()==getVoto3())){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "EMPATE");       
                PrimeFaces.current().dialog().showMessageDynamic(message);
                }
        
        
    }
    
}
