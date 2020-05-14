package org.formacio.setmana1.mvc;

import org.formacio.setmana1.data.LlibreNoExisteixException;
import org.formacio.setmana1.data.LlibreOpsBasic;
import org.formacio.setmana1.domini.Llibre;
import org.formacio.setmana1.domini.Recomanacio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Completeu el codi per tal que la peticio /titol retorni el titol del llibre
 * amb l'isbn enviat com a parametre
 * 
 * Aquesta classe ha de fer un de LlibreOpsBasic: No poseu aqui codi de persistencia!
 */

@Controller
public class LlibreController {

	// Per aqui vos fara falta una referencia a un LlibreOpsBasic
	
	@Autowired
	LlibreOpsBasic ops;
	
	@RequestMapping(path = "/titol", method = RequestMethod.GET)
	public String obteTitol(@RequestParam String isbn) throws LlibreNoExisteixException {
		Llibre llibre = ops.carrega(isbn);
		return llibre.getTitol();
	}
	
	// Aquestes anotacions i firma del metode ja son correctes
	@RequestMapping(path="/recomanacio")
	@ResponseBody
 	public Recomanacio obteLlibre (String isbn) throws LlibreNoExisteixException {
		// Feis que retorni la recomanacio per el llibre indicat 
		// emprat LlibreOpsBasic
		Llibre llibre = ops.carrega(isbn);
		return llibre.getRecomanacio();
	}
}
