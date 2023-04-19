package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.Persona;

@Controller
public class PersonaController {
	//get
	@GetMapping("/persona") 
	public ModelAndView cargarPersona() {
		Persona nuevaPersona = new Persona();
		
		ModelAndView modelAndView = new ModelAndView("persona");
		modelAndView.addObject("persona", nuevaPersona);
		return modelAndView;
	}
	
	//post
	@PostMapping("/guardarPersona")
	public ModelAndView guardarPersona(@ModelAttribute("persona") Persona personaGuardar) {
		
		personaGuardar.setEdad(calcularEdad(personaGuardar.getFechaNac()));
		personaGuardar.setSignoZodiaco(determinarZodiaco(personaGuardar.getFechaNac()));
		personaGuardar.setEstacion(determinarEstacion(personaGuardar.getFechaNac()));
		
		ModelAndView modelAndView = new ModelAndView("listarPersonas");
		modelAndView.addObject("persona", personaGuardar);
		
		return modelAndView;
	}
	
	private Integer calcularEdad (LocalDate fNacimiento) {
	
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fNacimiento, fechaActual);
		
		return periodo.getYears();
	}
	private String determinarZodiaco(LocalDate fNacimiento) {
		int dia = fNacimiento.getDayOfMonth();
		int mes = fNacimiento.getMonthValue();
		String signo="";
		
		switch(mes) {
		case 1:
			if(dia>=21) {
				signo = "Acuario";
			}else {
				signo = "Capricornio";
			}
			break;
		case 2:
			if(dia>=20) {
				signo = "Piscis";
			}else {
				signo = "Acuario";
			}
			break;
		case 3:
			if(dia>=21) {
				signo = "Aries";
			}else {
				signo = "Piscis";
			}
			break;
		case 4:
			if(dia>=21) {
				signo = "Tauro";
			}else {
				signo = "Aries";
			}
			break;
		case 5:
			if(dia>=22) {
				signo = "Géminis";
			}else {
				signo = "Tauro";
			}
			break;
		case 6:
			if(dia>=22) {
				signo = "Cáncer";
			}else {
				signo = "Géminis";
			}
			break;
		case 7:
			if(dia>=23) {
				signo = "Leo";
			}else {
				signo = "Cáncer";
			}
			break;
		case 8:
			if(dia>=23) {
				signo = "Virgo";
			}else {
				signo = "Leo";
			}
			break;
		case 9:
			if(dia>=23) {
				signo = "Libra";
			}else {
				signo = "Virgo";
			}
			break;
		case 10:
			if(dia>=23) {
				signo = "Escorpio";
			}else {
				signo = "Libra";
			}
		case 11:
			if(dia>=23) {
				signo = "Sagitario";
			}else {
				signo = "Escorpio";
			}
			break;
		case 12:
			if(dia>=22) {
				signo = "Capricornio";
			}else {
				signo = "Sagitario";
			}
			break;
		}
		return signo;
	}
	private String determinarEstacion(LocalDate fNacimiento) {
		String estacion="";
		int mes = fNacimiento.getMonthValue();
		int dia = fNacimiento.getDayOfMonth();
		
		switch(mes) {
		case 1,2:
			estacion = "Verano";
			break;
		case 3: 
			if(dia>=21) {
				estacion = "Otonio";
			}else {
				estacion = "Verano";
			}
			break;
		case 4,5:
			estacion = "Otonio";
			break;
		case 6:
			if(dia>=20) {
				estacion = "Invierno";
			}else {
				estacion = "Otonio";
			}
			break;
		case 7,8:
			estacion = "Invierno";
			break;
		case 9:
			if(dia>=21) {
				estacion = "Primavera";
			}else {
				estacion = "Invierno";
			}
			break;
		case 10,11:
			estacion = "Primavera";
			break;
		case 12:
			if(dia>=21) {
				estacion = "Verano";
			}else {
				estacion = "Primavera";
			}
			break;
		}

		return estacion;
	}
}
