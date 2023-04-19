package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.ProcesoString;

@Controller
public class ProcesoStringController {
	
	//get
	@GetMapping("/procesoString")
	public ModelAndView cargarCadena() {
		ModelAndView unModelAndView = new ModelAndView("procesoString");
		ProcesoString nuevoProceso = new ProcesoString();
		unModelAndView.addObject("nuevaCadena", nuevoProceso);
		
		return unModelAndView;
	}
	
	//post
	@PostMapping("/cadenaProcesada")
	public ModelAndView mostrarProcesoString(@ModelAttribute("nuevaCadena") ProcesoString stringGuardar) {
		
		determinarLongitud(stringGuardar);
		invertirCadena(stringGuardar);
		ModelAndView otroModelAndView = new ModelAndView("mostrarProcesoCadena");
		otroModelAndView.addObject("nuevaCadena", stringGuardar);
		
		return otroModelAndView;
	}
	
	//Metodos particulares
	private void determinarLongitud(ProcesoString procesoGuardado) {
		
		String cad = procesoGuardado.getCadena().toUpperCase();
		int caracteres = cad.length();
		int vocales = 0;
		for(int x=0; x<=caracteres-1; x++) {
			if(cad.charAt(x)=='A'||cad.charAt(x)=='E'||cad.charAt(x)=='I'||cad.charAt(x)=='O'||cad.charAt(x)=='U') {
				vocales++;
			}
		}
		
		procesoGuardado.setMensaje1("La cadena tiene "+caracteres+" caracteres y "+vocales+ " vocales");
	}
	private void invertirCadena(ProcesoString procesoGuardado) {
		String cad = procesoGuardado.getCadena();
		String cadInvertida = "";
		int palabras=1;
		for(int x=cad.length()-1;x>=0;x--) {
			if(cad.charAt(x)!=' ') {
				cadInvertida+=cad.charAt(x);
			}else {
				palabras++;
			}
		}
		procesoGuardado.setCadenaInvertida(cadInvertida);
		procesoGuardado.setMensaje2("La cadena tiene "+palabras+" palabras");
	}
	
}
