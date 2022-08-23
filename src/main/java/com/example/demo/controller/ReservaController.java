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

import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReserva(){
		return reservaServiceImpl.listarReservas();
	}
	
	
	@PostMapping("/reservas")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	
	@GetMapping("/reservas/{id}")
	public Reserva ReservaXID(@PathVariable(name="id") int id) {
		
		Reserva Reserva_xid= new Reserva();
		
		Reserva_xid=reservaServiceImpl.reservaXID(id);
		
		System.out.println("Reserva XID: "+Reserva_xid);
		
		return Reserva_xid;
	}
	
	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id,@RequestBody Reserva reserva) {
		
		Reserva reserva_seleccionada= new Reserva();
		Reserva reserva_actualizado= new Reserva();
		
		reserva_seleccionada= reservaServiceImpl.reservaXID(id);
		
		
		reserva_seleccionada.setComienzo(reserva.getComienzo());
		reserva_seleccionada.setFin(reserva.getFin());
		reserva_seleccionada.setInvestigador(reserva.getInvestigador());
		reserva_seleccionada.setEquipo(reserva.getEquipo());
		
		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionada);
		
		System.out.println("El Reserva actualizado es: "+ reserva_actualizado);
		
		return reserva_actualizado;
	}
	
	@DeleteMapping("/reservas/{id}")
	public void eliminarReserva(@PathVariable(name="id")int id) {
		reservaServiceImpl.eliminarReserva(id);
	}
	
	
}
