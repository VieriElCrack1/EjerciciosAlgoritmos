package com.practica.EjerciciosAlgoritmos.controller;

import com.practica.EjerciciosAlgoritmos.model.Ejercicio3;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ejercicio3Controller {

    @GetMapping("/ejercicio3")
    public String ejercicio3(Model model) {
        model.addAttribute("ejercicio3", new Ejercicio3());
        return "backoffice/ejercicio3/ejercicio3";
    }

    @PostMapping("/ejercicio3")
    public String ejercicio3(@ModelAttribute("ejercicio3") Ejercicio3 ejercicio3, Model model) {
        int idprod, cantidad;
        idprod = ejercicio3.getIdproducto();
        cantidad = ejercicio3.getCantidad();
        double unidadesPrecio;
        String regalo;
        if(idprod == 0) {
            model.addAttribute("error", "Ingrese Valor");
            return "backoffice/ejercicio3/ejercicio3";
        } else if (idprod == 1) {
            unidadesPrecio = cantidad * 15.0;
        } else if (idprod == 2) {
            unidadesPrecio = cantidad * 17.5;
        }else {
            unidadesPrecio = cantidad * 20.0;
        }

        if(cantidad <= 25) {
            regalo = "Un Lapicero";
        } else if (cantidad <= 50) {
            regalo = "Un Cuaderno";
        }else {
            regalo = "Una Agenda";
        }

        model.addAttribute("regalo", "Regalo : " + regalo);
        model.addAttribute("preciospromedio", "Total : " + String.valueOf(unidadesPrecio));
        return "backoffice/ejercicio3/ejercicio3";
    }
}
