package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	
	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores(){
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	
	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	
	@GetMapping("/investigadores/{id}")
	public Investigador InvestigadorXID(@PathVariable(name="id") String id) {
		
		Investigador Investigador_xid= new Investigador();
		
		Investigador_xid=investigadorServiceImpl.investigadorXID(id);
		
		System.out.println("Investigador XID: "+Investigador_xid);
		
		return Investigador_xid;
	}
	
	@PutMapping("/investigadores/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name="id")String id,@RequestBody Investigador investigador) {
		
		Investigador investigador_seleccionado= new Investigador();
		Investigador investigador_actualizado= new Investigador();
		
		investigador_seleccionado= investigadorServiceImpl.investigadorXID(id);
		
		investigador_seleccionado.setNomApels(investigador.getNomApels());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		
		investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionado);
		
		System.out.println("El Investigador actualizado es: "+ investigador_actualizado);
		
		return investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{id}")
	public String eliminarInvestigador(@PathVariable(name="id")String id) {
		try {
			investigadorServiceImpl.eliminarInvestigador(id);
			return "Investigador eliminado";
		} catch (Exception e) {
			return "El investigador no se puede eliminar";
		}
	}
	
	
}
