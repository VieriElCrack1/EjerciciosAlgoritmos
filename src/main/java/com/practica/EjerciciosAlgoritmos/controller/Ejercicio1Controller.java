package com.practica.EjerciciosAlgoritmos.controller;

import com.practica.EjerciciosAlgoritmos.model.Ejercicio1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ejercicio1Controller {

    @GetMapping("/ejercicio1")
    public String ejercicio1(Model model) {
        model.addAttribute("area", new Ejercicio1());
        return "backoffice/ejercicio1/ejercicio1";
    }

    @PostMapping("/ejercicio1")
    public String ejercicio2(@ModelAttribute("area") Ejercicio1 area, BindingResult result, Model model) {
        model.addAttribute("area", new Ejercicio1());
        if (result.hasErrors()) {
            return "backoffice/ejercicio1/ejercicio1";
        }

        double al, at, ab;
        ab = 3.14 * area.getR() * 2;
        al = 2 * 3.14 * area.getR() * area.getH();
        at = 2 * 3.14 * area.getR() * (area.getR() + area.getH());

        String abFormat = String.format("%.2f", ab);
        String alFormat = String.format("%.2f", al);
        String atFormat = String.format("%.2f", at);
        model.addAttribute("areabase", "Area Base : " + String.valueOf(abFormat));
        model.addAttribute("arealateral", "Area Lateral : " + String.valueOf(alFormat));
        model.addAttribute("areatotal", "Area Total : " + String.valueOf(atFormat));
        return "backoffice/ejercicio1/ejercicio1";
    }
}
