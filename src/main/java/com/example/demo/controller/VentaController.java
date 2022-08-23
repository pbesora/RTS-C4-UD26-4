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
public class VentaController {
	
	@Autowired
	ReservaServiceImpl ventaServiceImpl;
	
	@GetMapping("/ventas")
	public List<Reserva> listarVenta(){
		return ventaServiceImpl.listarVentas();
	}
	
	
	@PostMapping("/ventas")
	public Reserva salvarVenta(@RequestBody Reserva venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	
	@GetMapping("/ventas/{id}")
	public Reserva VentaXID(@PathVariable(name="id") int id) {
		
		Reserva Venta_xid= new Reserva();
		
		Venta_xid=ventaServiceImpl.ventaXID(id);
		
		System.out.println("Venta XID: "+Venta_xid);
		
		return Venta_xid;
	}
	
	@PutMapping("/ventas/{id}")
	public Reserva actualizarVenta(@PathVariable(name="id")int id,@RequestBody Reserva Venta) {
		
		Reserva venta_seleccionada= new Reserva();
		Reserva venta_actualizado= new Reserva();
		
		venta_seleccionada= ventaServiceImpl.ventaXID(id);
		
		
		venta_seleccionada.setCajero(Venta.getCajero());
		venta_seleccionada.setProducto(Venta.getProducto());
		venta_seleccionada.setMaquinaRegistradora(Venta.getMaquinaRegistradora());
		
		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionada);
		
		System.out.println("El Venta actualizado es: "+ venta_actualizado);
		
		return venta_actualizado;
	}
	
	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name="id")int id) {
		ventaServiceImpl.eliminarVenta(id);
	}
	
	
}
