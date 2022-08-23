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

import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {
	
	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultad> listarFacultads(){
		return facultadServiceImpl.listarFacultades();
	}
	
	
	@PostMapping("/facultades")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	
	@GetMapping("/facultades/{id}")
	public Facultad facultadXID(@PathVariable(name="id") int id) {
		
		Facultad Facultad_xid= new Facultad();
		
		Facultad_xid=facultadServiceImpl.facultadXID(id);
		
		System.out.println("Facultad XID: "+Facultad_xid);
		
		return Facultad_xid;
	}
	
	@PutMapping("/facultades/{id}")
	public Facultad actualizarFacultad(@PathVariable(name="id")int id,@RequestBody Facultad facultad) {
		
		Facultad facultad_seleccionado= new Facultad();
		Facultad facultad_actualizado= new Facultad();
		
		facultad_seleccionado= facultadServiceImpl.facultadXID(id);
		
		facultad_seleccionado.setNombre(facultad.getNombre());
		
		facultad_actualizado = facultadServiceImpl.actualizarFacultad(facultad_seleccionado);
		
		System.out.println("El Facultad actualizado es: "+ facultad_actualizado);
		
		return facultad_actualizado;
	}
	
	@DeleteMapping("/facultades/{id}")
	public String eliminarFacultad(@PathVariable(name="id")int id) {
		try {
			facultadServiceImpl.eliminarFacultad(id);
			return "Facultad eliminada";
		} catch (Exception e) {
			return "La facultad no se puede eliminar";
		}
	}
	
	
}
