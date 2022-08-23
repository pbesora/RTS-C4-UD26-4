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
public class MaquinaRegistradoraController {
	
	@Autowired
	EquipoServiceImpl maquinaRegistradoraServiceImpl;
	
	@GetMapping("/maquinas_registradoras")
	public List<Equipo> listarMaquinasRegistradoras(){
		return maquinaRegistradoraServiceImpl.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/maquinas_registradoras")
	public Equipo salvarMaquinaRegistradora(@RequestBody Equipo maquinaRegistradora) {
		
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}
	
	
	@GetMapping("/maquinas_registradoras/{id}")
	public Equipo maquinaRegistradoraXID(@PathVariable(name="id") int id) {
		
		Equipo MaquinaRegistradora_xid= new Equipo();
		
		MaquinaRegistradora_xid=maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		System.out.println("MaquinaRegistradora XID: "+MaquinaRegistradora_xid);
		
		return MaquinaRegistradora_xid;
	}
	
	@PutMapping("/maquinas_registradoras/{id}")
	public Equipo actualizarMaquinaRegistradora(@PathVariable(name="id")int id,@RequestBody Equipo maquinaRegistradora) {
		
		Equipo maquinaRegistradora_seleccionado= new Equipo();
		Equipo maquinaRegistradora_actualizado= new Equipo();
		
		maquinaRegistradora_seleccionado= maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		maquinaRegistradora_seleccionado.setPiso(maquinaRegistradora.getPiso());
		
		maquinaRegistradora_actualizado = maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(maquinaRegistradora_seleccionado);
		
		System.out.println("El MaquinaRegistradora actualizado es: "+ maquinaRegistradora_actualizado);
		
		return maquinaRegistradora_actualizado;
	}
	
	@DeleteMapping("/maquinas_registradoras/{id}")
	public String eliminarMaquinaRegistradora(@PathVariable(name="id")int id) {
		try {
			maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
			return "MaquinaRegistradora eliminada";
		} catch (Exception e) {
			return "La maquinaRegistradora no se puede eliminar";
		}
	}
	
	
}