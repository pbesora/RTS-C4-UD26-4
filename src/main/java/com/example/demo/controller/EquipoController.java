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

import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {
	
	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarMaquinasRegistradoras(){
		return equipoServiceImpl.listarEquipos();
	}
	
	
	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	
	@GetMapping("/equipos/{id}")
	public Equipo equipoXID(@PathVariable(name="id") int id) {
		
		Equipo Equipo_xid= new Equipo();
		
		Equipo_xid=equipoServiceImpl.equipoXID(id);
		
		System.out.println("Equipo XID: "+Equipo_xid);
		
		return Equipo_xid;
	}
	
	@PutMapping("/equipos/{id}")
	public Equipo actualizarEquipo(@PathVariable(name="id")int id,@RequestBody Equipo equipo) {
		
		Equipo equipo_seleccionado= new Equipo();
		Equipo equipo_actualizado= new Equipo();
		
		equipo_seleccionado= equipoServiceImpl.equipoXID(id);
		
		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setFacultad(equipo.getFacultad());
		
		equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);
		
		System.out.println("El Equipo actualizado es: "+ equipo_actualizado);
		
		return equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{id}")
	public String eliminarEquipo(@PathVariable(name="id")int id) {
		try {
			equipoServiceImpl.eliminarEquipo(id);
			return "Equipo eliminado";
		} catch (Exception e) {
			return "El equipo no se puede eliminar";
		}
	}
	
	
}