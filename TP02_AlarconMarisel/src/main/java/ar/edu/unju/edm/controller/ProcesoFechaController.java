package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.ProcesoFecha;

@Controller
public class ProcesoFechaController {

	//get
	@GetMapping("/procesoFecha")
	public ModelAndView cargarFechas() {
		
		ProcesoFecha primerProceso = new ProcesoFecha();
		ModelAndView nuevoModelAndView = new ModelAndView("procesoFecha");
		nuevoModelAndView.addObject("procesoForm", primerProceso);
		
		return nuevoModelAndView;
	}
	
	//post
	@PostMapping("/mostrarProceso")
	public ModelAndView mostrarProcesoFecha(@ModelAttribute("procesoForm") ProcesoFecha procesoGuardar) {
		
		compararFechas(procesoGuardar);
		ModelAndView unModelAndView = new ModelAndView("mostrarProceso");
		unModelAndView.addObject("procesoForm",procesoGuardar);
		
		return unModelAndView;
	}
	
	private void compararFechas(ProcesoFecha procesoGuardado) {
		LocalDate f1 = procesoGuardado.getFecha1();
		LocalDate f2 = procesoGuardado.getFecha2();
		String mensaje1="";
		String mensaje2="";
		LocalDate menor = f1;
		LocalDate mayor = f2;
		if(f1.compareTo(f2)<0) {
			mensaje1="La fecha1 es anterior a fecha2.";
			
		}else {
			if(f1.compareTo(f2)>0) {
				mensaje1="La fecha1 es posterior a fecha2.";
				menor = f2;
				mayor =f1;
			}else {
				mensaje1="Las fechas son iguales";
			}
		}
		
		Period periodo = Period.between(menor, mayor);
		mensaje2="Han transcurrido "+periodo.getYears()+" años, "+periodo.getMonths()+" meses y "+periodo.getDays()+" dias desde la fecha menor ("+menor+") hasta la fecha mayor ("+mayor+")";
		
		procesoGuardado.setMensaje1(mensaje1);
		procesoGuardado.setMensaje2(mensaje2);
	}
}
