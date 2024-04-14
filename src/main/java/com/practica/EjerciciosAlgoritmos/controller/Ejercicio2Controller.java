package com.practica.EjerciciosAlgoritmos.controller;

import com.practica.EjerciciosAlgoritmos.model.Ejercicio2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ejercicio2Controller {

    @GetMapping("/ejercicio2")
    public String ejercicio2(Model model) {
        model.addAttribute("ejercicio2", new Ejercicio2());
        return "backoffice/ejercicio2/ejercicio2";
    }

    @PostMapping("/ejercicio2")
    public String ejercicio2(@ModelAttribute("ejercicio2") Ejercicio2 ejercicio2, BindingResult result, Model model) {
        model.addAttribute("ejercicio2", new Ejercicio2());
        int mes, cdias, anio;
        mes = ejercicio2.getMes();
        anio = ejercicio2.getAnio();
        String rsMes = "";
        String bisicesto = "";
        if(anio%4 == 0) {
            bisicesto = "Año Bisiesto";
        }else{
            bisicesto = "Año No Bisiesto";
        }
        switch (mes) {
            case 1 :
                rsMes = "Enero";
                cdias = 31;
                break;
            case 2 :
                rsMes = "Febrero";
                cdias = anio%4 == 0 ? 29 : 28;
                break;
            case 3 :
                rsMes = "Marzo";
                cdias = 31;
                break;
            case 4 :
                rsMes = "Abril";
                cdias = 30;
                break;
            case 5 :
                rsMes = "Mayo";
                cdias = 31;
                break;
            case 6 :
                rsMes = "Junio";
                cdias = 30;
                break;
            case 7 :
                rsMes = "Julio";
                cdias = 31;
                break;
            case 8 :
                rsMes = "Agosto";
                cdias = 31;
                break;
            case 9 :
                rsMes = "Septiembre";
                cdias = 30;
                break;
            case 10 :
                rsMes = "Octubre";
                cdias = 31;
                break;
            case 11 :
                rsMes = "Noviembre";
                cdias = 30;
                break;
            default :
                rsMes = "Diciembre";
                cdias = 31;
                break;
        }
        model.addAttribute("rsmes", "Mes: " + rsMes);
        model.addAttribute("cdias", "Cantidad Dias: " + cdias);
        model.addAttribute("anio", "Año: " + bisicesto);
        return "backoffice/ejercicio2/ejercicio2";
    }
}
